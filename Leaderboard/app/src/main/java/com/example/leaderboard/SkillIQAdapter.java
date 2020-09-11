package com.example.leaderboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.SkillIQViewHolder> {
    private Context mContext;
    private ArrayList<SkillIQItem> mSkillIQList;

    public SkillIQAdapter(Context context, ArrayList<SkillIQItem> skillIQList){

        mContext = context;
        mSkillIQList = skillIQList;
    }

    @NonNull
    @Override
    public SkillIQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.leading_iq_list,parent,false);
        return new SkillIQViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIQViewHolder holder, int position) {
        SkillIQItem currentItem = mSkillIQList.get(position);
        String name = currentItem.getName();
        String country = currentItem.getCountry();
        int score = currentItem.getScore();

        holder.mNameView.setText(name);
        holder.mCountryView.setText(country);
        holder.mScoreView.setText(Integer.toString(score) + " Skill IQ Score,");
    }

    @Override
    public int getItemCount() {
        return mSkillIQList.size();
    }

    public class SkillIQViewHolder extends  RecyclerView.ViewHolder{
        public TextView mNameView;
        public TextView mCountryView;
        public TextView mScoreView;
        public SkillIQViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameView = (TextView) itemView.findViewById(R.id.nameIQView);
            mCountryView  = (TextView) itemView.findViewById(R.id.countryIQView);
            mScoreView =  (TextView) itemView.findViewById(R.id.scoreIQView);

        }
    }


    public static  ArrayList<SkillIQItem> extractSkillIQData(String data){
        ArrayList<SkillIQItem> skillIQItems = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(data);


            for (int i = 0; i< jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.optString("name").toString();
                String country = jsonObject.optString("country").toString();
                int score = jsonObject.optInt("score");

                SkillIQItem skillIQItem = new SkillIQItem(name,country,score);
                skillIQItems.add(skillIQItem);
            }
            Log.e("MyTags","hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skillIQItems;
    }


    }




