package com.example.audiovideo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer=MediaPlayer.create(this,R.raw.alien);

        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        stop=findViewById(R.id.stop);

        videoView=findViewById(R.id.videoViewId);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.cricket);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mediaController);
        videoView.setMediaController(mediaController);

        videoView.start();

        myAudio();



    }


    public void myAudio(){

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });
    }


}
