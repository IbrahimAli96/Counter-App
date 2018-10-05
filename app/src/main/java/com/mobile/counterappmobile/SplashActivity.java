package com.mobile.counterappmobile;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private long ms=0;
    //set to 0.5 seconds
    private static long splashTime = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread mythread = new Thread() {
            public void run() {
                try {
                    while (ms < splashTime) {
                        ms = ms + 100;
                        sleep(100);
                    }
                } catch (Exception e) {
                } finally {
                    Intent intent = new Intent(getApplicationContext(),
                            MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        mythread.start();

        //android:theme="@style/AppTheme.NoActionBar"

    }
}
