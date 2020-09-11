package com.example.leaderboard;

public class SkillIQItem {
    private String mName;
    private String mCountry;
    private int mScore;


    public SkillIQItem(String name, String Country, int score){
        mName = name;
        mCountry = Country;
        mScore = score;
    }

    public String getName(){
        return mName;
    }
    public String getCountry(){
        return mCountry;
    }
    public int getScore(){
        return mScore;
    }
}
