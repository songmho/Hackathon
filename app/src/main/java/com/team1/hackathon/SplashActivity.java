package com.team1.hackathon;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by eugene on 2015-08-11.
 */
public class SplashActivity extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

            Handler handler= new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    finish();
                }
            };
            handler.sendEmptyMessageDelayed(0,2000);
        }
    }