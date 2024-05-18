package com.example.harsh.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.*;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;

public class BookAidAactivity extends AppCompatActivity implements ItemClickCallback {

 ArrayList<Aide> list;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_aid_aactivity);
        getSupportActionBar().hide();
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        final String type = getIntent().getExtras().getString("type");
        Log.d("type",type);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Aide");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    if (postSnapshot.getValue(Aide.class).getJob_profile()!=null) {
                        if (postSnapshot.getValue(Aide.class).getJob_profile().equalsIgnoreCase(type)) {
                            list.add(postSnapshot.getValue(Aide.class));
                        }
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(BookAidAactivity.this));
                RecyclerAdapter adapter=new RecyclerAdapter(list,BookAidAactivity.this,R.layout.row_layout,false);
                recyclerView.setAdapter(adapter);
                adapter.setItemClickCallback(BookAidAactivity.this);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void OnItemClick(int id) {
        Intent intent = new Intent(BookAidAactivity.this,HelperInfoActivity.class);
        intent.putExtra("HELPER",list.get(id));
        startActivity(intent);
    }

    @Override
    public void OnSubItemClick(int id) throws IOException {

    }
}
