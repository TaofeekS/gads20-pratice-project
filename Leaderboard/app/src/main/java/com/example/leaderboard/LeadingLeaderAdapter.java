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

public class LeadingLeaderAdapter extends RecyclerView.Adapter<LeadingLeaderAdapter.LeadingLeaderViewHolder> {
    private Context mContext;
    private ArrayList<LeadingLeaderItem> mLeadingLeaderList;

    public LeadingLeaderAdapter(Context context, ArrayList<LeadingLeaderItem> leadingleaderList){

        mContext = context;
        mLeadingLeaderList = leadingleaderList;
    }

    @NonNull
    @Override
    public LeadingLeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.leading_leader_list,parent,false);
        return new LeadingLeaderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadingLeaderViewHolder holder, int position) {
        LeadingLeaderItem currentItem = mLeadingLeaderList.get(position);
        String name = currentItem.getName();
        String country = currentItem.getCountry();
        int hours = currentItem.getHours();

        holder.mNameView.setText(name);
        holder.mCountryView.setText(country);
        holder.mHoursView.setText(Integer.toString(hours) + " Learning hours,");
    }

    @Override
    public int getItemCount() {
        return mLeadingLeaderList.size();
    }

    public class LeadingLeaderViewHolder extends  RecyclerView.ViewHolder{
        public TextView mNameView;
        public TextView mCountryView;
        public TextView mHoursView;
        public LeadingLeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameView = (TextView) itemView.findViewById(R.id.nameIQView);
            mCountryView  = (TextView) itemView.findViewById(R.id.countryIQView);
            mHoursView  =  (TextView) itemView.findViewById(R.id.hoursView);

        }
    }


    public static  ArrayList<LeadingLeaderItem> extractLeadingLeadersData(String data){
        ArrayList<LeadingLeaderItem> leadingLeaderItems = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(data);


            for (int i = 0; i< jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.optString("name").toString();
                String country = jsonObject.optString("country").toString();
                int hours = jsonObject.optInt("hours");

                LeadingLeaderItem leadingLeaderItem = new LeadingLeaderItem(name,country,hours);
                leadingLeaderItems.add(leadingLeaderItem);
            }
            Log.e("MyTags","hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leadingLeaderItems;
    }


    }




