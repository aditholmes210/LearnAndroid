package com.aditas.viewpager;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class Adapt extends FragmentStatePagerAdapter {
//    private static ArrayList<String> myTitles;
//    private static ArrayList<String> myData;
    public static ArrayList<CarSpec> mySpec;
    private static int numOfItems; //jml item di viewpager
    //private static Context ctx;

//    public static Adapt newInstance(FragmentManager fm, ArrayList<String> titles, ArrayList<String> data){
//        Adapt adapt = new Adapt(fm);
//        myTitles = titles;
//        myData = data;
//        numOfItems = data.size(); //set numOfItems as size of data/titles
//        return adapt;
//    }

    //Overload newInstance() above
    public static Adapt newInstance(FragmentManager fm, ArrayList<CarSpec> car){
    Adapt adapt = new Adapt(fm);
    mySpec = car;
    numOfItems = car.size();
    //ctx = context;
    return  adapt;
    }

//    public void Test(ArrayList<CarSpec> car){
//        mySpec = car;
//    }


    //Constructor
    public Adapt(FragmentManager fm){
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT); //deprecated
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ArrayList<CarSpec.Carf> text = mySpec.get(position).getData();

        //FirstFragment firstFrag = FirstFragment.newInstance(text); //call newInstance & ngambil data text dari arraylist dgn text diatas
        FirstFragment firstFrag = new FirstFragment();
        firstFrag.setData(text);
        return firstFrag;
    }
//        FirstFragment firstFrag = new FirstFragment();
//        SecondFragment sndFrag = new SecondFragment();

//        switch (position){
//            case 0:
//                return firstFrag;
//            case 1:
//                return sndFrag;
//            default:
//                return firstFrag;
//        }
//
//    }

//    @Override
//    public int getCount() {
//        return 3;
//    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int pos) {
////        return "Page " + position;
//        String title = null;
//        switch (pos){
//            case 0:
//                title = "Chats";
//                break;
//            case 1:
//                title = "Stats";
//                break;
//            case 2:
//                title = "calls";
//                break;
//        }
//        return title;
//    }

    @Override
    public int getCount(){
        return numOfItems;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        String title = "";
        try{
            title = mySpec.get(position).getName();
        } catch (IndexOutOfBoundsException e){
            title = "whatever";
        }

        return title;
    }

}
