package com.example.lab4_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickVideoInternet(View view)
    {
        Intent intent = new Intent (this, InternetActivity.class);
        startActivity(intent);
    }

    public void onClickVideoFolder(View view)
    {
        Intent intent = new Intent (this, VideoActivity.class);
        startActivity(intent);
    }

    public void onClickAudioFolder(View view)
    {
        Intent intent = new Intent (this, AudioActivity.class);
        startActivity(intent);
    }
}