package com.example.leaderboard;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchSkillIQData extends AsyncTask<Void,Void,Void> {
    public String mSkillIQData;
    public Boolean mdataLoaded = false;

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://gadsapi.herokuapp.com/api/skilliq");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            line = bufferedReader.readLine();
            Log.d("myTag",line);
            mSkillIQData = line;

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


