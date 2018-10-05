package com.mobile.counterappmobile;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class BroadcastService extends Service {

    private final static String TAG = "BroadcastService";

    @Override
    public void onCreate() {
        super.onCreate();

        // logs that it started in logcat
        Log.i(TAG, "Starting timer...");

        // handler starts
                new Handler().postDelayed(new Runnable() {

                    @Override

                    public void run() {

                        //sets Seconds amount
                        DataPersistSec.SaveSec = DataPersistSec.getSecInt(BroadcastService.this);

                        //sets increment amount
                        DataPersistSec.SaveIncSec = DataPersistSec.getIncInt(BroadcastService.this);

                        // creates a new handler every X seconds based on users input
                        new Handler().postDelayed(this, DataPersistSec.SaveSec * 1000);

                        SharedPreferences prefs = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE);

                        // declare values so it can be used later
                        Boolean switch1 = prefs.getBoolean("SwitchOnOffSec1", false);
                        Boolean switch2 = prefs.getBoolean("SwitchOnOffSec2", false);
                        Boolean switch3 = prefs.getBoolean("SwitchOnOffSec3", false);
                        Boolean switch4 = prefs.getBoolean("SwitchOnOffSec4", false);
                        Boolean switch5 = prefs.getBoolean("SwitchOnOffSec5", false);

                        // each if statement checks if switch is on
                        // if it is on it will call the addSaveCounter1 from another class
                        // to add the incremented amount
                        if(switch1 == true){
                            DataPersistSec.addSaveCounter1(BroadcastService.this);
                        } else {}

                        if(switch2 == true){
                            DataPersistSec.addSaveCounter2(BroadcastService.this);
                        } else {}

                        if(switch3 == true){
                            DataPersistSec.addSaveCounter3(BroadcastService.this);
                        } else {}

                        if(switch4 == true){
                            DataPersistSec.addSaveCounter4(BroadcastService.this);
                        } else {}
                        if(switch5 == true){
                            DataPersistSec.addSaveCounter5(BroadcastService.this);
                        } else {}

                        // changes bool so boolchange method is called in other class
                        // this will update the value shown in the activity class
                        BoolChange.setMyBoolean(true);

                    }

                }, 1);


    }


    @Override
    public void onDestroy() {

        Log.i(TAG, "Timer cancelled");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}