package com.mobile.counterappmobile;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ibrahim on 04/04/2018.
 */

public class DataPersistSingle {

    //declare variable
    private static SharedPreferences prefs;

    // declares variable as int with a value
    public static int SaveCounterSing1 = 0;
    // decales variable as string
    public static String saveCounterSing1 = "SaveCounterSing1";

    public static int SaveIncSing = 1;
    public static String saveIncSing = "SaveIncSing";

    //----------------------------------------------------------------------------------------------
    //Row 1

    // Saves counter when called
    public static void SaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterSing1, SaveCounterSing1).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSing1 = prefs.getInt(saveCounterSing1, 0);
        SaveCounterSing1 = SaveCounterSing1 + SaveIncSing;
        prefs.edit().putInt(saveCounterSing1, SaveCounterSing1).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSing1 = prefs.getInt(saveCounterSing1, 0);
        SaveCounterSing1 = SaveCounterSing1 - SaveIncSing;
        prefs.edit().putInt(saveCounterSing1, SaveCounterSing1).commit();

    }

    //resets value to 0
    public static void resetSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSing1 = prefs.getInt(saveCounterSing1, 0);
        SaveCounterSing1=0;
        prefs.edit().putInt(saveCounterSing1, SaveCounterSing1).commit();

    }

    //method used to get the value
    public static int getCountSing1(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c1= prefs.getInt(saveCounterSing1, SaveCounterSing1);

        return c1;
    }

    //----------------------------------------------------------------------------------------------
    //incement

    // saves increment amount when called
    public static void saveIncInt(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveIncSing, SaveIncSing).commit();

    }

    // gets increment amount when called
    public static int getIncInt(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int cInc= prefs.getInt(saveIncSing, SaveIncSing);

        return cInc;
    }



}
