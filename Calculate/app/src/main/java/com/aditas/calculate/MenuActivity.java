package com.aditas.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import static com.aditas.calculate.MainActivity.EXTRA_NAME;


public class MenuActivity extends AppCompatActivity implements View.OnClickListener {h

    Button btnCalc, btnExit, btnCall, btnYt;
    TextView tvNm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCalc = findViewById(R.id.btn_calc);
        btnCall = findViewById(R.id.btn_call);
        btnYt = findViewById(R.id.btn_yt);
        btnExit = findViewById(R.id.btn_exit);
        tvNm = findViewById(R.id.tv_nm);
        btnExit.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnYt.setOnClickListener(this);
        btnCalc.setOnClickListener(this);
        //receiving data from intent
        //If(get.Intent().getExtras() != null){
           Intent i = getIntent();
           String name = i.getStringExtra(EXTRA_NAME);
              //with bundle
               //bundle data = getIntent().getExtras();
               //String name = data.getString(MainActivity.EXTRA_NAME);
           tvNm.setText(name);
           //String nama = getIntent().getStringExtra("extra_name");
          // tvNm.setText(getIntent().getStringExtra(MainActivity.EXTRA_NAME);
        //}
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_calc:
                Intent calc = new Intent(getApplicationContext(), VolActivity.class);
                startActivity(calc);
                break;
            case R.id.btn_call:
                String noHP = "08111856530";
                Uri tel = Uri.parse("tel:"+noHP);

                Intent dialContact = new Intent(Intent.ACTION_DIAL, tel);
                //check if there is activity /apps that can handle this intent
                if(dialContact.resolveActivity(getPackageManager()) != null){
                    startActivity(dialContact);
                }
                else{
                    Toast.makeText(this, "Can't make a call", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_yt:
                String web = "www.youtube.com";
                Uri dom = Uri.parse("http://"+web);

                Intent openWeb = new Intent(Intent.ACTION_VIEW, dom);
                //create chooser apps to open this intent
                Intent chooser = Intent.createChooser(openWeb, "Open with : ");
                if(openWeb.resolveActivity(getPackageManager()) != null){
                    startActivity(openWeb);
                }
                break;
            case R.id.btn_exit:
                Snackbar.make(view, "Ketipuu", Snackbar.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
