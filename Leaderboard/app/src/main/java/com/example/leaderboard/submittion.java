package com.example.leaderboard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class submittion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submittion);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Bitmap bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.background),size.x,size.y,true);

        ImageView imageView = (ImageView) findViewById(R.id.black_background_view);
        imageView.setImageBitmap(bmp);

        ImageButton backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(submittion.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstName = findViewById(R.id.firstNameView);
                EditText lastName = findViewById(R.id.lastNameView);
                EditText email = findViewById(R.id.emailView);
                EditText linktoGithub = findViewById(R.id.githubView);
                submitForm(firstName.getText().toString(),lastName.getText().toString(),email.getText().toString(),linktoGithub.getText().toString());
            }
        });
}

    private void submitForm(String firstName, String lastName, String email, String linkToGithub) {
        Form form = new Form(firstName,lastName,email,linkToGithub);



    }
}
