package com.aditas.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

public class VolActivity extends AppCompatActivity {
    private EditText etLength, etWidth, etHeight;
    private TextView tvHsl;
    private Button btnHtg;
    private double length, width, height, result;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vol);

        pref = getSharedPreferences("prefku", MODE_PRIVATE);

        init();
        btnHtg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getText();

                result = (length * width * height) / 2;
                tvHsl.setText(String.valueOf(result));

            }
        });
        getPref();
    }

    private void setPref(){
        SharedPreferences.Editor editor = pref.edit();
        String l = etLength.getText().toString();
        String h = etHeight.getText().toString();
        String w = etWidth.getText().toString();
        String r = tvHsl.getText().toString();

        editor.putString("length", l);
        editor.putString("height", h);
        editor.putString("width", w);
        editor.putString("result", r);
        editor.apply();
    }

    private void init(){
        etLength = findViewById(R.id.et_pjg);
        etWidth = findViewById(R.id.et_lbr);
        etHeight = findViewById(R.id.et_tgg);
        tvHsl = findViewById(R.id.tv_hsl);
        btnHtg = findViewById(R.id.btn_htg);
    }

    private void getPref(){
        String length = pref.getString("length", "");
        String height = pref.getString("height", "");
        String width = pref.getString("width", "");
        String result = pref.getString("result", "");

        etLength.setText(length);
        etHeight.setText(height);
        etWidth.setText(width);
        tvHsl.setText(result);
    }

    private void getText(){
        String stLength = etLength.getText().toString();
        String stWidth = etWidth.getText().toString();
        String stHeight = etHeight.getText().toString();

        if(stLength.equals("") || stHeight.equals("") || stWidth.equals("")){
            Toast.makeText(this, "Harus ada inputan", Toast.LENGTH_SHORT).show();
        }
        else{
            height = Double.valueOf(stHeight);
            width = Double.valueOf(stWidth);
            length = Double.valueOf(stLength);
            setPref();
        }
    }

    private void resetText(){
        etLength.setText("");
        etWidth.setText("");
        etHeight.setText("");
    }

    @Override
    protected void onPause() {
        setPref();
        super.onPause();
    }
}
