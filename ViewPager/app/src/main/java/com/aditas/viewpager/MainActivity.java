package com.aditas.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
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

    private void deserializeJSON(){
        //JSON from file
        String json = loadJSONFromRaw();
        try {
            //buat JSONArray dari file json
            JSONArray jsonData = new JSONArray(json);

            //ambil smua JSONObject dalam jsonData(jsinArray)
            for(int index = 0; index < jsonData.length(); index++){
                JSONObject carSpecJO = jsonData.getJSONObject(index); //menu makanan json object
                String jenis = carSpecJO.getString("jenis");    //ambil jenis dari json
                JSONArray data = carSpecJO.getJSONArray("data"); //ambil data dari json

                ArrayList<CarSpec.Carf> dataList = new ArrayList<>();   //siapkan arraylist utk data mobil

                //pecah data Carf dari json & jadikan sebuah java object carfJO, kmudian masukkan ke arraylist diatas
                for(int i = 0; i < data.length(); i++){
                    JSONObject carfJO = data.getJSONObject(i);
                    String nama = carfJO.getString("nama");
                    String harga = carfJO.getString("harga");
                    String desc = carfJO.getString("desc");
                    String gambar = carfJO.getString("gambar");

                    CarSpec.Carf carf = new CarSpec.Carf(nama, harga, desc, gambar);  // obj java dari carf
                    dataList.add(carf); //memasukkan data obj java yg diparse dari json ke dlm array list dataList
                }
                CarSpec spec = new CarSpec(jenis, dataList);    //buat obj java carspec
                car.add(spec);      //masukkan java menu makanan ke arraylist
            }
        } catch(JSONException e){
            e.printStackTrace();
        }
    }

    private String loadJSONFromRaw() {

        String json = null;
        try {
            //InputStream is = getActivity().getAssets().open("yourfilename.json"); //from asset
            InputStream is = getResources().openRawResource(R.raw.car);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
