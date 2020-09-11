package com.example.leaderboard;

public class LeadingLeaderItem {

    private String mName;
    private String mCountry;
    private int mHours;


    public LeadingLeaderItem(String name, String Country, int hours){
        mName = name;
        mCountry = Country;
        mHours = hours;
    }

    public String getName(){
        return mName;
    }
    public String getCountry(){
        return mCountry;
    }
    public int getHours(){
        return mHours;
    }
}