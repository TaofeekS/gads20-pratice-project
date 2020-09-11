package com.example.leaderboard;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tab2 extends Fragment {
    private static final String TAG = "Tab2";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private FetchSkillIQData mProcess;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tab2,container,false);


        mProcess = new FetchSkillIQData();
        mProcess.execute();

        mRecyclerView  = (RecyclerView) view.findViewById(R.id.skillIQView);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        final Handler handler = new Handler();
        Log.d("Skill IQ","working");
        Runnable r = new Runnable() {
            @Override
            public void run() {

                addAdapter();
            };
        };
        handler.postDelayed(r,5000);
        return view;
    }

    private void addAdapter() {
        ArrayList<SkillIQItem> skillIQItems = SkillIQAdapter.extractSkillIQData(mProcess.mSkillIQData);
        Log.d("Skill IQ",skillIQItems.toString());
        SkillIQAdapter adapter = new SkillIQAdapter(getContext(),skillIQItems);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(adapter);

    }
}
