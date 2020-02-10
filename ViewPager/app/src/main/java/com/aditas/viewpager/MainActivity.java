package com.aditas.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager page;
    private Adapt adapt;
    private TabLayout tabSpec;
    private ListView lvData;
    private ArrayAdapter<String> dataAdapter;

//    ArrayList<String> menuTitleData = new ArrayList<>();
//    ArrayList<String> data = new ArrayList<>();
    ArrayList<CarSpec> car = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvData = findViewById(R.id.lv_data);

//        generateTitle();
//        generateData();
        generateSpec();

        page = findViewById(R.id.vp_page);
        //adapt = new Adapt(getSupportFragmentManager()); //buat obj adapter
        //adapt = Adapt.newInstance(getSupportFragmentManager(), menuTitleData, data);
        adapt = Adapt.newInstance(getSupportFragmentManager(), car); //newInstance di copy pake ctrl+d
        page.setAdapter(adapt);

        tabSpec = findViewById(R.id.tab_spec);
        tabSpec.setupWithViewPager(page);
    }
    //Membuat dummy title data
//    private void generateTitle(){
//        menuTitleData.add("Promo");
//        menuTitleData.add("Paket");
//        menuTitleData.add("Everyday");
//        menuTitleData.add("Top Range");
//        menuTitleData.add("Adventure");
//    }
//    private void generateData(){
//        data.add("Sahara");
//        data.add("Brute");
//        data.add("Sport");
//        data.add("Rubicon");
//        data.add("Gladiator");
//    }

    private void generateSpec(){
//        CarSpec spec = new CarSpec("Promo", "Sahara");
        ArrayList<CarSpec.Carf> Mesin = new ArrayList<>();
        Mesin.add(new CarSpec.Carf("Pentastar","3.604cc", getString(R.string.Pentastar), R.drawable.jeep_engine));
        Mesin.add(new CarSpec.Carf("V6","2.985cc",getString(R.string.Pentastar), R.drawable.jeep_wrangler));
        Mesin.add(new CarSpec.Carf("GME","1.995cc",getString(R.string.Pentastar), R.drawable.jeep_wrangler));

        ArrayList<CarSpec.Carf> Total = new ArrayList<>();
        Total.add(new CarSpec.Carf("Sport ", "1.199",getString(R.string.Pentastar), R.drawable.jeep_wrangler));
        Total.add(new CarSpec.Carf("Sahara ", "1.399",getString(R.string.Pentastar), R.drawable.jeep_wrangler));
        Total.add(new CarSpec.Carf("Rubicon","1.499",getString(R.string.Pentastar), R.drawable.jeep_wrangler));

        ArrayList<CarSpec.Carf> Fitur = new ArrayList<>();
        Fitur.add(new CarSpec.Carf("Keyless entry", "1.000",getString(R.string.Pentastar), R.drawable.jeep_wrangler));
        Fitur.add(new CarSpec.Carf("Automatic transmission","1.500",getString(R.string.Pentastar), R.drawable.jeep_wrangler));
        Fitur.add(new CarSpec.Carf("Hill start assist","800",getString(R.string.Pentastar), R.drawable.jeep_wrangler      ));

//        car.add(new CarSpec("Harga", "Brute"));
        car.add(new CarSpec("Mesin", Mesin));
        car.add(new CarSpec("Fitur", Fitur));
        car.add(new CarSpec("Total", Total));

    }
}
