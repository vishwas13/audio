package com.example.utilisateur.myapplication;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.util.Log;

public class MyServices extends Service implements BroadcastReceiver {
    public static final String TAG = MyServices.class.getName();
    public static final int SCREEN_OFF_RECEIVER_DELAY = 500;
    private AudioManager mAM = null;

    public BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "onReceive(" + intent + ")");

            if (!intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                return;
            }

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Log.i(TAG, "Runnable executing.");
                    unRegisterListener();
                    registerListener();
                }

                private void registerListener() {

                }

                private void unRegisterListener() {
                }
            };

            new Handler().postDelayed(runnable, SCREEN_OFF_RECEIVER_DELAY);
        }
}
