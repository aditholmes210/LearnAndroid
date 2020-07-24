package com.aditas.cars;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private ListView lvData;
    private CustAdapt cust;
    private ArrayList<Type> cartype;

    public FirstFragment() {
        // Required empty public constructor
    }

    public void click(){
        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DescActivity.class);
                intent.putExtra("Deskripsi", cust.getItem(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_first, container,false);
        lvData = rootView.findViewById(R.id.lv_data);
        cust = new CustAdapt(getContext(), cartype);
        lvData.setAdapter(cust);
        click();
        return rootView;
    }

    public static FirstFragment newINstance(ArrayList<Type> cars){
        FirstFragment firstFrag = new FirstFragment();
        return firstFrag;
    }
    public void setData(ArrayList<Type.Cars> data) {
        cartype = data;
    }
}
