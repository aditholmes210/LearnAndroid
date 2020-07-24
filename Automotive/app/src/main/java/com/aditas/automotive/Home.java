package com.aditas.automotive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    Button btnStr;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnStr = findViewById(R.id.btn_st);
//        btnStr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intFil = new Intent(Home.this, Form.class);
//                startActivity(intFil);
//            }
//        });
    }
}
