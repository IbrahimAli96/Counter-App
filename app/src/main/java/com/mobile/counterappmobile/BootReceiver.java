package com.mobile.counterappmobile;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Calendar;

public class BootReceiver extends BroadcastReceiver {

    private PendingIntent pendingIntent;

    public static Calendar calendar = Calendar.getInstance();

    public void onReceive(Context context, Intent intent)
    {
        //  execute when Boot Completed
        /**Schedule your Alarm Here**/
        Toast.makeText(context, "Booting Completed", Toast.LENGTH_LONG).show();

        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

        _scheduleNextUpdate(context);
    }

    public static AlarmManager alarmMgr;

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
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);

// setRepeating() lets you specify a precise custom interval--in this case,
// 1 day
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);
    }
}
