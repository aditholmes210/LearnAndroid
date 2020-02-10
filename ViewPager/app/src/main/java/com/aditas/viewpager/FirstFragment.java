package com.aditas.viewpager;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private ListView lvData;
    private UserAdapter adapt;
    private ImageView img;
    private int imgdata;
    private ArrayList<CarSpec.Carf> carlist;

//    public static FirstFragment newInstance(ArrayList<CarSpec.Carf> data){ //ambil data dari CarSpec.Carf trus masukin ke argument
//        FirstFragment firstFrag = new FirstFragment();
//        Bundle args = new Bundle();
//        args.putParcelableArrayList("text", data);
//        firstFrag.setArguments(args);
//        carlist = data;
//        return firstFrag;
//    }
//    public static FirstFragment newInstance(int pos, String Text){ //ambil data dari CarSpec.Carf trus masukin ke argument
//        FirstFragment firstFrag = new FirstFragment();
//        Bundle args = new Bundle();
//        args.putInt("Position", pos);
//        args.putString("Text", Text);
//        firstFrag.setArguments(args);
//        return firstFrag;
//    }

    public FirstFragment() {
        // Required empty public constructor
    }

    public void lvClick(){
        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DescActivity.class);
                intent.putExtra("Deskripsi Mesin", adapt.getItem(position));
                startActivity(intent);
            }
        });
    }

//    public static FirstFragment newInstance(ArrayList<CarSpec.Carf> text) {
//        FirstFragment firstFrag = new FirstFragment();
//        Bundle args = new Bundle();
//        args.putString("text",text);
//        firstFrag.setArguments(args);
//        return firstFrag;
//    }

//    private TextView textData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        lvData = rootView.findViewById(R.id.lv_data);
        img = rootView.findViewById(R.id.iv_jeep);
        //ArrayAdapter<CarSpec.Carf> adapter = new ArrayAdapter<CarSpec.Carf>(getActivity(), android.R.layout.simple_list_item_1, carlist);
        adapt = new UserAdapter(getContext(), carlist);
        lvData.setAdapter(adapt);
        lvClick();

//        if(getArguments() != null){
//            ArrayList<CarSpec.Carf> crf = getArguments().getParcelableArrayList("text");
//            lvData = rootView.findViewById(R.id.lv_data);
//            UserAdapter adaptr = new UserAdapter(getActivity(), crf);
//            lvData.setAdapter(adaptr);
//        }

        return rootView;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View rootView =  inflater.inflate(R.layout.fragment_first, container, false);
//
//        textData = rootView.findViewById(R.id.text_data);
//        textData.setText(getArguments().getString("text"));
//
//        return rootView;
//       // return inflater.inflate(R.layout.fragment_first, container, false);
//    }

//    public fix(ArrayList<CarSpec.Carf>){
//
//    }

    public static FirstFragment newInstance(ArrayList<CarSpec.Carf> cars){
        FirstFragment firstFrag = new FirstFragment();
        return firstFrag;
    }
    public void setData(ArrayList<CarSpec.Carf> data){
        carlist = data;
    }
    public void setData(ArrayList<CarSpec.Carf> data, Integer img){
        carlist = data;
        Integer imgData = img;
    }

}
