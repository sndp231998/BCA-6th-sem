package com.example.harsh.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    Button signup,login;
    EditText et_email,et_pass;
    public static String Key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        signup = (Button) findViewById(R.id.btnsignup);
        login = (Button) findViewById(R.id.btnlogin);
        et_email = (EditText) findViewById(R.id.etusename);
        et_pass = (EditText) findViewById(R.id.etpassword);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_email.getText().toString()!=null && et_pass.getText().toString()!=null){
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                            for (DataSnapshot snap : children) {
                                User value = snap.getValue(User.class);
                                if(et_email.getText().toString().equalsIgnoreCase(value.getEmail())){
                                    if(et_pass.getText().toString().equals(value.getPassword())){
                                        Log.d("demo",value.toString());
                                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                        intent.putExtra("USER",value);
                                        Key = value.getKey();
                                        startActivity(intent);
                                        finish();
                                    }

                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }
}
