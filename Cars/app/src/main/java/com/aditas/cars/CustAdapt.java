package com.aditas.cars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustAdapt extends BaseAdapter {
    private Context ctx;
    private ArrayList<Type.Cars> car;

    public CustAdapt(Context ctx, ArrayList<Type.Cars> car){
        this.ctx = ctx;
        this.car = car;
    }

    @Override
    public int getCount(){
        return car.size();
    }

    @Override
    public Type.Cars getItem(int position) {
        Type.Cars crz = car.get(position);
        return crz;
    }

    @Override
    public long getItemId(int position){ return position; }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        Type.Cars user = (Type.Cars) getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_user, parent, false);
        }

        TextView tvList = (TextView) convertView.findViewById(R.id.tv_list);
        TextView tvHrg = (TextView) convertView.findViewById(R.id.tv_hrg);
        tvList.setText(user.getName());
        tvHrg.setText(user.getData());
    }
}
