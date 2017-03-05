package com.westwood.trippin;

/**
 * Created by Jenny on 3/4/17.
 */

public class PlaceNum {
    private String place;

    private long num;

    PlaceNum(String place, long num){

        this.place=place;

        this.num=num;

    }

    public void setPlace(String place){

        this.place=place;

    }

    public void setNum(long num){

        this.num=num;

    }

    public String getPlace(){

        return place;

    }

    public long getNum(){

        return num;

    }
}
