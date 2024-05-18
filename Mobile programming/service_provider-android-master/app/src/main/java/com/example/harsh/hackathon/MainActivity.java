package com.example.harsh.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView carpenter,plumber,mason,locksmith,cook,helper;
    static User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        user  = (User) getIntent().getExtras().getSerializable("USER");
        carpenter = (ImageView) findViewById(R.id.iv_carpentry);
        plumber = (ImageView) findViewById(R.id.iv_plumbing);
        mason = (ImageView) findViewById(R.id.iv_mason);
        locksmith = (ImageView) findViewById(R.id.iv_locksmith);
        cook = (ImageView) findViewById(R.id.iv_cook);
        helper = (ImageView) findViewById(R.id.iv_helper);
        carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BookAidAactivity.class);
                intent.putExtra("type","Carpenter");
                startActivity(intent);
            }
        });
        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BookAidAactivity.class);
                intent.putExtra("type","Plumber");
                startActivity(intent);
            }
        });
        mason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BookAidAactivity.class);
                intent.putExtra("type","Mason");
                startActivity(intent);
            }
        });
        locksmith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BookAidAactivity.class);
                intent.putExtra("type","LockSmith");
                startActivity(intent);
            }
        });
        cook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BookAidAactivity.class);
                intent.putExtra("type","Cook");
                startActivity(intent);
            }
        });
        helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BookAidAactivity.class);
                intent.putExtra("type","Helper");
                startActivity(intent);
            }
        });
    }
}
