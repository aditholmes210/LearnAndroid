package com.aditas.cars;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class Adapter extends FragmentStatePagerAdapter {
    public static ArrayList<Type> myType;
    public static int numOfItems;   //jml item di viewpager

    public static Adapter newInstance(FragmentManager fm, ArrayList<Type> jns) {
        Adapter adapt = new Adapter(fm);
        myType = jns;
        numOfItems = jns.size(); //masukin jumlah data yg ada di jns ke numOfItems
        return adapt;
    }

    public Adapter(FragmentManager fm){ //bikin constructor adapter buat masukin ke newInstance
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int pos){
        ArrayList<Type.Cars> data = myType.get(pos).getData();
        FirstFragment firstFrag = new FirstFragment(); //menginisiasi fistFrag sbg FirstFragment baru
        firstFrag.setData(data);
        return firstFrag;
    }

    @Override
    public int getCount(){ return numOfItems;}

    @NonNull
    @Override
    public CharSequence getPageTitle(int pos){
        String title = "";
        try{
            title = myType.get(pos).getName();
        }
        catch (IndexOutOfBoundsException e){
            title = "Whatever";
        }
        return title;
    }
}


