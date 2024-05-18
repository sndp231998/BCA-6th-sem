package com.example.harsh.hackathon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.*;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.UUID;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class ChatActivity extends AppCompatActivity implements ItemClick {

    RecyclerView recyclerView;
    RecyclerChat adapter;
    String photourl;
    ArrayList<Message> MessageList = new ArrayList<>();
    EditText message;
    ImageButton send,image;
    Aide helper = new Aide();
    conversation c;
    int flag =0;
    String conversation_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = (RecyclerView) findViewById(R.id.rv_chat);
        send = (ImageButton) findViewById(R.id.ib_send);
        message = (EditText) findViewById(R.id.et_msg);
        image = (ImageButton) findViewById(R.id.ib_image);

        ArrayList<String> conversationList= new ArrayList<>();
        conversationList = MainActivity.user.getConversations();
        helper = (Aide) getIntent().getExtras().getSerializable("HELPER");

        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference("conversation");
        final ArrayList<String> finalConversationList = conversationList;
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                   c = new conversation();
                    c = postSnapshot.getValue(conversation.class);
                    if(finalConversationList!=null){
                        if(finalConversationList.contains(c.getKey())){
                            if(c.getTo().equals(helper.getKey())){
                                conversation_id = c.getKey();
                                flag=1;
                                break;
                            }
                        }
                    }else{
                        break;
                    }
                }
                if(flag==0){
                    //conversation does not exists...thus create a new one
                    //create conversation
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("conversation");
                    DatabaseReference conversationRef = databaseReference.push();
                    conversation c1 = new conversation();
                    c1.setFrom(MainActivity.user.getKey());
                    c1.setTo(helper.getKey());
                    c1.setKey(conversationRef.getKey());
                    conversationRef.setValue(c1);
                    c = c1;
                    //add conversation to user
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Users");
                    User u = new User();
                    u = MainActivity.user;
                    ArrayList<String> c = new ArrayList<String>();
                    if(u.getConversations()!=null){
                        c = u.getConversations();
                    }
                    c.add(c1.getKey());
                    u.setConversations(c);
                    dbRef.child(u.getKey()).setValue(u);
                    MainActivity.user = u;
                    //add conversation to helper
                    DatabaseReference dref = FirebaseDatabase.getInstance().getReference("Aide");
                    Aide a = new Aide();
                    a=helper;
                    ArrayList<String> con_arr = new ArrayList<String>();
                    if(a.getConversations()!=null){
                        con_arr = a.getConversations();
                    }
                    con_arr.add(c1.getKey());
                    a.setConversations(con_arr);
                    helper = a;
                    dref.child(helper.getKey()).setValue(helper);
                }
                if(flag==1){
                    //conversation already exists and now we need to fetch the conversation
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("conversation").child(c.getKey());
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("messages");
                            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    MessageList = new ArrayList<Message>();
                                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                                        if(c.getMessages().contains(postSnapshot.getValue(Message.class).getMeg_key())){
                                            MessageList.add(postSnapshot.getValue(Message.class));
                                        }
                                    }
                                    LinearLayoutManager ll = new LinearLayoutManager(ChatActivity.this);
                                   // ll.setReverseLayout(true);
                                    recyclerView.setLayoutManager(ll);
                                    adapter=new RecyclerChat(MessageList,ChatActivity.this);
                                    recyclerView.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(message.getText().toString()!=null){
                    Message m = new Message();
                    m.setTime(System.currentTimeMillis());
                    m.setMessage(message.getText().toString());
                    m.setSent_by(MainActivity.user.getKey());
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("messages");
                    DatabaseReference mRef = reference.push();
                    m.setMeg_key(mRef.getKey());
                    mRef.setValue(m);
                    message.setText("");
                    DatabaseReference dreference = FirebaseDatabase.getInstance().getReference("conversation");
                    ArrayList<String> msgList = new ArrayList<String>();
                    if(c.getMessages()!=null){
                        msgList = c.getMessages();
                    }
                    msgList.add(m.getMeg_key());
                    flag=1;
                    c.setMessages(msgList);
                    dreference.child(c.getKey()).setValue(c);
                }
            }
        });

   image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 100);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri imageUri = data.getData();
        InputStream inputStream = null;
        try {
            inputStream = getContentResolver().openInputStream(imageUri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (inputStream != null) {
            FirebaseStorage.getInstance().getReference("Images").child(UUID.randomUUID().toString()).putStream(inputStream).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    @SuppressWarnings("VisibleForTests") Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    photourl = downloadUrl.toString();
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("messages");
                    final Message m = new Message();
                    m.setImgurl(photourl);
                    m.setSent_by(MainActivity.user.getKey());
                    m.setTime(System.currentTimeMillis());
                    final DatabaseReference push = databaseReference.push();
                    m.setMeg_key(push.getKey());
                    push.setValue(m);
                    DatabaseReference dreference = FirebaseDatabase.getInstance().getReference("conversation");
                    ArrayList<String> msgList = new ArrayList<String>();
                    if(c.getMessages()!=null){
                        msgList = c.getMessages();
                    }
                    msgList.add(m.getMeg_key());
                    flag=1;
                    c.setMessages(msgList);
                    dreference.child(c.getKey()).setValue(c);
                    photourl = null;
                }
            });
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}
