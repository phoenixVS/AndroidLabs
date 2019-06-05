package com.example.lab4_2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    String [] myVideos = {"Video 1", "Video 2", "Video 3", "Video 4"};
    VideoView videoPlayer;
    String currentVideo;
    String currentVideo2;
    Spinner spinner;
    Uri myVideoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, myVideos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        videoPlayer =  (VideoView)findViewById(R.id.videoView);
        myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.v1);
        videoPlayer.setVideoURI(myVideoUri);
    }

    public void onClickPlay(View view){
        currentVideo = spinner.getSelectedItem().toString();
        if (currentVideo==currentVideo2)
        {
            videoPlayer.start();
        }
        else
        {
            if (currentVideo=="Video 1")
            {
                myVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.v1);
                videoPlayer.setVideoURI(myVideoUri);
            }
            else if (currentVideo=="Video 2")
            {
                myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.v2);
                videoPlayer.setVideoURI(myVideoUri);
            }
            else if (currentVideo=="Video 3")
            {
                myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.v3);
                videoPlayer.setVideoURI(myVideoUri);
            }
            else if (currentVideo=="Video 4")
            {
                myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.v4);
                videoPlayer.setVideoURI(myVideoUri);
            }
            videoPlayer.start();
        }
        currentVideo2 = currentVideo;
    }
    public void onClickPause(View view){
        videoPlayer.pause();
    }
    public void onClickStop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }
}