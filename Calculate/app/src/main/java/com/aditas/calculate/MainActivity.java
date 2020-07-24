package com.aditas.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_NAME = "MainActivity EXTRA_NAME";
    private EditText etIsi;
    private Button btnSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIsi = findViewById(R.id.et_isi);
        btnSub = findViewById(R.id.btn_sub);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = etIsi.getText().toString();
                if (strName.equals("")) {
                    etIsi.setError("Harus diisi");
                } else {
                    Intent sub = new Intent(getApplicationContext(), MenuActivity.class);
                    sub.putExtra(EXTRA_NAME, strName);
                    startActivity(sub);
                 }
            }
            //cara lain untuk memanggil pada method onClick
            /*switch (v.getid()){
               case R.id.btn_sub:
               Intent sub = new Intent(this, MenuActivity.class);
               sub.putExtra("Nama", personName);
               startActivity(sub);
               break;
            }*/
        });
    }
}
