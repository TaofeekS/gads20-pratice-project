package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Bitmap bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.background),size.x,size.y,true);

        ImageView imageView = (ImageView) findViewById(R.id.backView);
        imageView.setImageBitmap(bmp);

        final Handler handler = new Handler();

        Runnable r = new Runnable() {
            @Override
            public void run() {

                changeScene();
                finish();
            };
        };
        handler.postDelayed(r,SPLASH_TIME_OUT);
    }




    public void changeScene(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}