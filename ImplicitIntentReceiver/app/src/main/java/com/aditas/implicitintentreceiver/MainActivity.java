package com.aditas.implicitintentreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvResLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResLink = findViewById(R.id.tv_res_link);

        Intent recIntent = getIntent();
        Uri uri = recIntent.getData();
        if(uri != null){
            tvResLink.setText(uri.toString());
        }
    }
}
