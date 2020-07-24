package com.aditas.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private final String STATE_LAST_ORIENTATION = "state_last_orientation";
    private final String STATE_COUNT = "state_count"; //konstanta utk state count
    private final String TAG = "MainActivity";
    //pembuatan objek komponen
    TextView tvCount;
    Button btnCount, btnReset;
    int count = 0; //tipe data primitif
    //Integer = 0; //tipe data reference
    //int last_orientation = 1; // 1 for portrait

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //bind activity ke layout yg akan ditampilkan

        //binding component ke view
        tvCount = findViewById(R.id.tv_count);
        btnCount = findViewById(R.id.btn_count);
        btnReset = findViewById(R.id.btn_rst);

        //cara 1 set onClick pada component
        btnCount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //do something here
                count++;
                if(count == 100){
                    tvCount.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.small_count));
                }
                tvCount.setText(String.valueOf(count));
                //tvCount.setText(count.toString());
                String msgCount = String.valueOf(count);
                tvCount.setText(msgCount);
                Log.i("Counter ", String.valueOf(count));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                tvCount.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.small_count));
                tvCount.setText(String.valueOf(count));
                Log.i("Counter ", String.valueOf(count));
            }
        });
        if(savedInstanceState != null){ //cek apakah ada state yg tersimpan
            count = savedInstanceState.getInt(STATE_COUNT);
            tvCount.setText(String.valueOf(count));
        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        //save state
        outState.putInt(STATE_COUNT, count);
    }
}
