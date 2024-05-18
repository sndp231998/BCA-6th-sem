package com.example.harsh.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class BookHelper extends AppCompatActivity {

    EditText et_date,et_task;
    Button confirm;
    TextView helper;
    Aide help = new Aide();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_helper);
        help = (Aide) getIntent().getExtras().getSerializable("HELPER");
        helper = (TextView) findViewById(R.id.tv_helper);
        confirm = (Button) findViewById(R.id.btn_confirm);
        et_date = (EditText) findViewById(R.id.et_date);
        et_task = (EditText) findViewById(R.id.et_task);

        helper.setText(help.getFname() + " " + help.getLname());
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_task.getText().toString()!="" && et_date.getText().toString()!="") {
                    if (et_task.getText().toString().length() != 0 && et_date.getText().toString().length() != 0) {
                        final apointment apt = new apointment();
                        apt.setDate(et_date.getText().toString());
                        apt.setTask(et_task.getText().toString());
                        apt.setRequester_id(MainActivity.user.getKey());
                        apt.setHelper_id(help.getKey());
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("apointment");
                        DatabaseReference aptRef = databaseReference.push();
                        apt.setKey(aptRef.getKey());
                        aptRef.setValue(apt);
                        Toast.makeText(BookHelper.this,"Thank you for booking!!",Toast.LENGTH_SHORT).show();
                        DatabaseReference aidRef = FirebaseDatabase.getInstance().getReference("Aide").child(help.getKey());
                        aidRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                help  =dataSnapshot.getValue(Aide.class);
                                ArrayList<String> aptList = new ArrayList<String>();
                                if(help.getApointments()!=null){
                                    aptList = help.getApointments();
                                }
                                aptList.add(apt.getKey());
                                help.setApointments(aptList);
                                FirebaseDatabase.getInstance().getReference("Aide").child(help.getKey()).setValue(help);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        Intent intent = new Intent(BookHelper.this,MainActivity.class);
                        intent.putExtra("USER",MainActivity.user);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }
}
