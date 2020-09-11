package com.example.leaderboard;

import android.content.Context;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class FetchLeadingLeaderData extends AsyncTask<Void,Void,Void> {
    public String mLeadingLeaderData;
    public Boolean mdataLoaded = false;

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://gadsapi.herokuapp.com/api/hours");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            line = bufferedReader.readLine();
            Log.d("myTag",line);
            mLeadingLeaderData = line;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        super.onPostExecute(v);
        mdataLoaded = true;
       
    }






    }


