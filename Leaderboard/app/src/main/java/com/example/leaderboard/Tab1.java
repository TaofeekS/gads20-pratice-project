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

public class Tab1 extends Fragment {
    RecyclerView mRecyclerView;
    private FetchLeadingLeaderData mProcess;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tab1,container,false);

        mProcess = new FetchLeadingLeaderData();
        mProcess.execute();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.leadingLeaderView);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        final Handler handler = new Handler();


        Runnable r = new Runnable() {
            @Override
            public void run() {
                addAdapter();

            };
        };
        handler.postDelayed(r,5000);





        return view;
    }

    public void addAdapter(){





        Log.d("MyData",mProcess.mLeadingLeaderData);
        ArrayList<LeadingLeaderItem> leadingLeaderItems =  LeadingLeaderAdapter.extractLeadingLeadersData(mProcess.mLeadingLeaderData);
        LeadingLeaderAdapter adapter = new LeadingLeaderAdapter(getContext(),leadingLeaderItems);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(adapter);




    }
}
