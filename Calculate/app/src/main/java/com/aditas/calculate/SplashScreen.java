package com.aditas.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView tvSplash;
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //manghilangkan actionbar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); //feature_no_title menghilangkan ActBar dibagian atas aplikasi
        setContentView(R.layout.activity_splash_screen);
        ivLogo = findViewById(R.id.iv_logo);
        tvSplash = findViewById(R.id.tv_splash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }, 5000L); //3000L = 3 detik
    }
}
