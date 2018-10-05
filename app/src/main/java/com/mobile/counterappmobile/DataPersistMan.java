package com.mobile.counterappmobile;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import java.lang.ref.WeakReference;

/**
 * Created by Ibrahim on 04/04/2018.
 */

public class DataPersistMan {

    //declare variable
    private static SharedPreferences prefs;

    // declares variable as int with a value
    public static int SaveCounter1 = 0;
    // decales variable as string
    public static String saveCounter1 = "SaveCounter1";

    public static int SaveCounter2 = 0;
    public static String saveCounter2 = "SaveCounter2";

    public static int SaveCounter3 = 0;
    public static String saveCounter3 = "SaveCounter3";

    public static int SaveCounter4 = 0;
    public static String saveCounter4 = "SaveCounter4";

    public static int SaveCounter5 = 0;
    public static String saveCounter5 = "SaveCounter5";

    public static int SaveCounter6 = 0;
    public static String saveCounter6 = "SaveCounter6";

    public static int SaveInc = 1;
    public static String saveInc = "SaveInc";

    //----------------------------------------------------------------------------------------------
    //Row 1

    // Saves counter when called
    public static void SaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounter1, SaveCounter1).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter1 = prefs.getInt(saveCounter1, 0);
        SaveCounter1 = SaveCounter1 + SaveInc;
        prefs.edit().putInt(saveCounter1, SaveCounter1).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter1 = prefs.getInt(saveCounter1, 0);
        SaveCounter1 = SaveCounter1 - SaveInc;
        prefs.edit().putInt(saveCounter1, SaveCounter1).commit();

    }

    //resets value to 0
    public static void resetSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter1 = prefs.getInt(saveCounter1, 0);
        SaveCounter1=0;
        prefs.edit().putInt(saveCounter1, SaveCounter1).commit();

    }

    //method used to get the value
    public static int getCount1(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c1= prefs.getInt(saveCounter1, SaveCounter1);

        return c1;
    }

    // saves input string when called
    public static void setTaskName1(Context context, String taskName) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskName", taskName);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName1(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskName", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //Row 2

    // Saves counter when called
    public static void SaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounter2, SaveCounter2).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter2 = prefs.getInt(saveCounter2, 0);
        SaveCounter2 = SaveCounter2 + SaveInc;
        prefs.edit().putInt(saveCounter2, SaveCounter2).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter2 = prefs.getInt(saveCounter2, 0);
        SaveCounter2 = SaveCounter2 - SaveInc;
        prefs.edit().putInt(saveCounter2, SaveCounter2).commit();

    }

    //resets value to 0
    public static void resetSaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter2 = prefs.getInt(saveCounter2, 0);
        SaveCounter2=0;
        prefs.edit().putInt(saveCounter2, SaveCounter2).commit();

    }

    //method used to get the value
    public static int getCount2(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c2= prefs.getInt(saveCounter2, SaveCounter2);

        return c2;
    }

    // saves input string when called
    public static void setTaskName2(Context context, String taskName2) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskName2", taskName2);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName2(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskName2", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //Row 3

    // Saves counter when called
    public static void SaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounter3, SaveCounter3).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter3 = prefs.getInt(saveCounter3, 0);
        SaveCounter3 = SaveCounter3 + SaveInc;
        prefs.edit().putInt(saveCounter3, SaveCounter3).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter3 = prefs.getInt(saveCounter3, 0);
        SaveCounter3 = SaveCounter3 - SaveInc;
        prefs.edit().putInt(saveCounter3, SaveCounter3).commit();

    }

    //resets value to 0
    public static void resetSaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter3 = prefs.getInt(saveCounter3, 0);
        SaveCounter3=0;
        prefs.edit().putInt(saveCounter3, SaveCounter3).commit();

    }

    //method used to get the value
    public static int getCount3(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c3= prefs.getInt(saveCounter3, SaveCounter3);

        return c3;
    }

    // saves input string when called
    public static void setTaskName3(Context context, String taskName3) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskName3", taskName3);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName3(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskName3", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //Row 4

    // Saves counter when called
    public static void SaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounter4, SaveCounter4).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter4 = prefs.getInt(saveCounter4, 0);
        SaveCounter4 = SaveCounter4 + SaveInc;
        prefs.edit().putInt(saveCounter4, SaveCounter4).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter4 = prefs.getInt(saveCounter4, 0);
        SaveCounter4 = SaveCounter4 - SaveInc;
        prefs.edit().putInt(saveCounter4, SaveCounter4).commit();

    }

    //resets value to 0
    public static void resetSaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter4 = prefs.getInt(saveCounter4, 0);
        SaveCounter4=0;
        prefs.edit().putInt(saveCounter4, SaveCounter4).commit();

    }

    //method used to get the value
    public static int getCount4(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c4= prefs.getInt(saveCounter4, SaveCounter4);

        return c4;
    }

    // saves input string when called
    public static void setTaskName4(Context context, String taskName4) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskName4", taskName4);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName4(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskName4", "click to edit");
    }


    //----------------------------------------------------------------------------------------------
    //Row 5

    // Saves counter when called
    public static void SaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounter5, SaveCounter5).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter5 = prefs.getInt(saveCounter5, 0);
        SaveCounter5 = SaveCounter5 + SaveInc;
        prefs.edit().putInt(saveCounter5, SaveCounter5).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter5 = prefs.getInt(saveCounter5, 0);
        SaveCounter5 = SaveCounter5 - SaveInc;
        prefs.edit().putInt(saveCounter5, SaveCounter5).commit();

    }

    //resets value to 0
    public static void resetSaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter5 = prefs.getInt(saveCounter5, 0);
        SaveCounter5=0;
        prefs.edit().putInt(saveCounter5, SaveCounter5).commit();

    }

    //method used to get the value
    public static int getCount5(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c5= prefs.getInt(saveCounter5, SaveCounter5);

        return c5;
    }

    // saves input string when called
    public static void setTaskName5(Context context, String taskName5) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskName5", taskName5);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName5(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskName5", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //Row 6

    // Saves counter when called
    public static void SaveCounter6(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounter6, SaveCounter6).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter6(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter6 = prefs.getInt(saveCounter6, 0);
        SaveCounter6 = SaveCounter6 + SaveInc;
        prefs.edit().putInt(saveCounter6, SaveCounter6).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter6(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter6 = prefs.getInt(saveCounter6, 0);
        SaveCounter6 = SaveCounter6 - SaveInc;
        prefs.edit().putInt(saveCounter6, SaveCounter6).commit();

    }

    //resets value to 0
    public static void resetSaveCounter6(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounter6 = prefs.getInt(saveCounter6, 0);
        SaveCounter6=0;
        prefs.edit().putInt(saveCounter6, SaveCounter6).commit();

    }

    //method used to get the value
    public static int getCount6(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c6= prefs.getInt(saveCounter6, SaveCounter6);

        return c6;
    }

    // saves input string when called
    public static void setTaskName6(Context context, String taskName6) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskName6", taskName6);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName6(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskName6", "click to edit");
    }


    //----------------------------------------------------------------------------------------------
    //incement

    // saves increment amount when called
    public static void saveIncInt(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveInc, SaveInc).commit();

    }

    // gets increment amount when called
    public static int getIncInt(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int cInc= prefs.getInt(saveInc, SaveInc);

        return cInc;
    }



}
