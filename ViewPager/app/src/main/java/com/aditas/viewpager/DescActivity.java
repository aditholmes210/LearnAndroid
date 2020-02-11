package com.aditas.viewpager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DescActivity extends AppCompatActivity {
    TextView big;
    ImageView jl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);


        CarSpec.Carf crx = getIntent().getParcelableExtra("Deskripsi Mesin");

        String engine = crx.getDesc();
        String jt = crx.getImage();
        big = findViewById(R.id.jeep_desc);
        big.setText(engine);
        jl = findViewById(R.id.iv_engine);
       // jl.setImageResource(jt);
        jl.setImageResource(getResources().getIdentifier(jt,"drawable",getPackageName()));
    }
}
