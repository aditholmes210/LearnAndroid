package com.aditas.viewpager;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CarSpec.Carf> car;

        public UserAdapter(Context context, ArrayList<CarSpec.Carf> cars) {
            this.context = context;
            this.car = cars;
        }

        @Override
        public int getCount(){
            return car.size();
        }

        @Override
        public CarSpec.Carf getItem(int position){
            CarSpec.Carf crz = car.get(position);
            return crz;
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            CarSpec.Carf user = (CarSpec.Carf) getItem(position);

            // Check if an existing view is being reused, otherwise inflate the view

            if (convertView == null) {

                convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);

            }

            TextView tvJenis = (TextView) convertView.findViewById(R.id.tv_jns);
            TextView tvHarga = (TextView) convertView.findViewById(R.id.tv_hrg);
            tvJenis.setText(user.getName());
            tvHarga.setText(user.getHarga());
            return convertView;

        }

    }

