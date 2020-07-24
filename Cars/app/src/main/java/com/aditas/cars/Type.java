package com.aditas.cars;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class Type {
    private String name;
    private String tahun;
    //private ArrayList<Cars> tahun;
    private String desc;

    public static class Cars implements Parcelable{
        private String name;
        private String tahun;
        private String desc;

        public Cars(String nm, String thn, String dsc){
            this.name = nm;
            this.tahun = thn;
            this.desc = dsc;
        }

        public String getName() {
            return name;
        }
        public String getTahun() {
            return tahun;
        }
        public String getDesc() {
            return desc;
        }

        @Override
        public int describeContent(){ return 0;}

        @Override
        public void writeToParcel(Parcel dest, int flags){
            dest.writeString(this.name);
            dest.writeString(this.tahun);
            dest.writeString(this.desc);
        }

        protected Cars(Parcel in){
            this.name = in.readString();
            this.tahun = in.readString();
            this.desc = in.readString();
        }

        public static final Parcelable.Creator<Cars> CREATOR = new Parcelable.Creator<Cars>() {
            @Override
            public Type.Cars createFromParcel(Parcel source) {
                return new Cars(source);
            }
            @Override
            public Cars[] newArray(int size) {return new Cars(size);}
        };
    }



    public Type(String name, ArrayList<Cars> data){
        this.name = name;
        this.data = data;
    }
    public String getName(){return name;}
    public ArrayList<Cars> getData(){return data;}
}
