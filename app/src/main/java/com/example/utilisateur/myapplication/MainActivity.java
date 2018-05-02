package com.example.utilisateur.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;

    private LinearLayout mRootLayout;
    private Button mButtonPlay;

    MediaPlayer mPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        mContext = getApplicationContext();
        mActivity = MainActivity.this;

        // Get the widget reference from xml layout
        mRootLayout = findViewById(R.id.root_layout);
        mButtonPlay = findViewById(R.id.btn_play);

        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Disable the play button
                mButtonPlay.setEnabled(false);
                String audioUrl = "http://www.youtube.com";
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try{
                    mPlayer.setDataSource(audioUrl);
                    mPlayer.prepare();
                    mPlayer.start();
                    Toast.makeText(mContext,"Playing",Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    e.printStackTrace();
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                }catch (SecurityException e){
                    e.printStackTrace();
                }catch (IllegalStateException e){
                    e.printStackTrace();
                }

                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(mContext,"End",Toast.LENGTH_SHORT).show();
                        mButtonPlay.setEnabled(true);
                    }
                });
            }
        });
    }
}
