package com.example.controlaudio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer audioClip;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioClip = MediaPlayer.create(this,R.raw.alien);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        SeekBar volumeControl = findViewById(R.id.volume);

        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        final SeekBar audioLocation = findViewById(R.id.location);
        audioLocation.setMax(audioClip.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                audioLocation.setProgress(audioClip.getCurrentPosition());
            }
        },0,100);

        audioLocation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioClip.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void play(View view) {

        audioClip.start();
    }

    public void pause(View view) {
        audioClip.pause();
    }



}
