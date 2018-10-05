package com.mobile.counterappmobile;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;

public class AlarmReceiver extends BroadcastReceiver {

    private static final String PREF_TIMEZONE = "TimeZone";

    public static AlarmManager alarmMgr;

    public static Calendar calendar = Calendar.getInstance();


    @Override
    public void onReceive(Context context, Intent intent) {


        // At 12 midnight it will call the AddCounterIf method
        AddCounterIf(context);

    }

    // this method checks if the switch if on or off
    public void AddCounterIf(Context context) {

        //sets increment amount
        DataPersistDay.SaveIncDay = DataPersistDay.getIncInt(context);

        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE);

        // declare values so it can be used later
        Boolean switch1 = prefs.getBoolean("SwitchOnOffDay1", false);
        Boolean switch2 = prefs.getBoolean("SwitchOnOffDay2", false);
        Boolean switch3 = prefs.getBoolean("SwitchOnOffDay3", false);
        Boolean switch4 = prefs.getBoolean("SwitchOnOffDay4", false);
        Boolean switch5 = prefs.getBoolean("SwitchOnOffDay5", false);

        // each if statement checks if switch is on
        // if it is on it will call the addSaveCounter1 from another class
        // to add the incremented amount
        if(switch1 == true){
            DataPersistDay.addSaveCounter1(context);
        }
        if(switch2 == true){
            DataPersistDay.addSaveCounter2(context);
        }
        if(switch3 == true){
            DataPersistDay.addSaveCounter3(context);
        }
        if(switch4 == true){
            DataPersistDay.addSaveCounter4(context);
        }
        if(switch5 == true){
            DataPersistDay.addSaveCounter5(context);
        } else {}

        // changes bool so boolchange method is called in other class
        // this will update the value shown in the activity class
        BoolChange.setMyBoolean(true);
    }

    public void onUpdate(Context context) {
        // Do your updates...

        // call this method
        _scheduleNextUpdate(context);
    }

    private static void _scheduleNextUpdate(Context context) {

//        AlarmManager alarmManager =
//                (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(context, Main3Activity.class);
//        intent.setAction("com.mobile.counterappmobile");
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
//
//        // Get a calendar instance for midnight tomorrow.
//        Calendar midnight = Calendar.getInstance();
//        midnight.set(Calendar.HOUR_OF_DAY, 00);
//        midnight.set(Calendar.MINUTE, 00);
//        // Schedule one second after midnight, to be sure we are in the right day next time this
//        // method is called.  Otherwise, we risk calling onUpdate multiple times within a few
//        // milliseconds
//        midnight.set(Calendar.SECOND, 1);
//        midnight.set(Calendar.MILLISECOND, 0);
//        midnight.add(Calendar.DAY_OF_YEAR, 1);
//
//        // For API 19 and later, set may fire the intent a little later to save battery,
//        // setExact ensures the intent goes off exactly at midnight.
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//            alarmManager.set(AlarmManager.RTC_WAKEUP, midnight.getTimeInMillis(), pendingIntent);
//        } else {
//            alarmManager.setExact(AlarmManager.RTC_WAKEUP, midnight.getTimeInMillis(), pendingIntent);
//        }



        alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

// Set the alarm to start at 12:00 PM
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 47);

// setRepeating() lets you specify a precise custom interval--in this case,
// 1 day
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);
    }



}