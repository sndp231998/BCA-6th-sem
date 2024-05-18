package com.example.harsh.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class HelperInfoActivity extends AppCompatActivity {

    ImageView profilepic;
    TextView name,profile,description,phone,address;
    Button chat,book;
    Aide helper= new Aide();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_info);
        profilepic = (ImageView) findViewById(R.id.imageView);
        name = (TextView) findViewById(R.id.tv_name);
        profile = (TextView) findViewById(R.id.tv_profile);
        description = (TextView) findViewById(R.id.tv_description);
        address = (TextView) findViewById(R.id.tv_address);
        phone = (TextView) findViewById(R.id.tv_phone);
        chat = (Button) findViewById(R.id.btn_discuss);
        book = (Button) findViewById(R.id.btn_bookApt);
        helper = (Aide) getIntent().getExtras().getSerializable("HELPER");
        if(helper.getImage()!=null){
            Picasso.with(HelperInfoActivity.this).load(helper.getImage()).into(profilepic);
        }
        name.setText(helper.getFname() + " "+ helper.getLname());
        profile.setText("Profile: " + helper.getJob_profile());
        description.setText("About "+helper.getFname() + " "+ helper.getLname()+", \n"+helper.getJob_description());
        address.setText("Address: "+helper.address);
        phone.setText("Contact Number: " + helper.getPhone());

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelperInfoActivity.this,ChatActivity.class);
                intent.putExtra("HELPER",helper);
                startActivity(intent);
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelperInfoActivity.this,BookHelper.class);
                intent.putExtra("HELPER",helper);
                startActivity(intent);
            }
        });
    }
}
