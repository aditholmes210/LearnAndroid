package com.aditas.cars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager page;
    private Adapter adapt;
    private TabLayout tabSpec;
    private ListView lvData;
    private ArrayAdapter<String> dataAdapt;
    ArrayList<Type> jns = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvData = findViewById(R.id.lv_data);

        generateSpec(); //ambil data dari method generateSpec

        page = findViewById(R.id.vp_page);
        adapt = Adapter.newInstance(getSupportFragmentManager(), jns);
        page.setAdapter(adapt);

        tabSpec = findViewById(R.id.tab_spec);
        tabSpec.setupWithViewPager(page);
    }

    private void generateSpec(){
        //nambahin data buat dimasukin ke listview
        ArrayList<Type> frd = new ArrayList<>();
        frd.add(new Type("Mustang", "2016"));
        ArrayList<Type> ddg = new ArrayList<>();
        frd.add(new Type("Challanger", "2016"));
        ArrayList<Type> chv = new ArrayList<>();
        frd.add(new Type("Camaro", "2016"));

        //nambahin data ke array list
        jns.add(new Type("Ford", frd));
        jns.add(new Type("Dodge", ddg));
        jns.add(new Type("Chevrolet", chv));
    }
}
