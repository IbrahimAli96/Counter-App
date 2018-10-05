package com.mobile.counterappmobile;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ibrahim on 04/04/2018.
 */

public class DataPersistSec {

    //declare variable
    private static SharedPreferences prefs;

    // declares variable as int with a value
    public static int SaveAlm1 = 0;
    // decales variable as string
    public static String saveAlm1 = "SaveAlm1";

    // declares variable as int with a value
    public static int SaveCounterSec1 = 0;
    // decales variable as string
    public static String saveCounterSec1 = "SaveCounterSec1";

    public static int SaveCounterSec2 = 0;
    public static String saveCounterSec2 = "SaveCounterSec2";

    public static int SaveCounterSec3 = 0;
    public static String saveCounterSec3 = "SaveCounterSec3";

    public static int SaveCounterSec4 = 0;
    public static String saveCounterSec4 = "SaveCounterSec4";

    public static int SaveCounterSec5 = 0;
    public static String saveCounterSec5 = "SaveCounterSec5";

    public static int SaveIncSec = 1;
    public static String saveIncSec = "SaveIncSec";

    public static int SaveSec = 1;
    public static String saveSec = "SaveSec";

    //----------------------------------------------------------------------------------------------
    // alarm

    // saves this value with the value of SaveAlm
    public static void saveAlm(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveAlm1, SaveAlm1).commit();

    }

    // used to get the vlaue of SaveAlm
    public static int getAlm(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int a1= prefs.getInt(saveAlm1, SaveAlm1);

        return a1;
    }

    //----------------------------------------------------------------------------------------------
    //Row 1

    // Saves counter when called
    public static void SaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterSec1, SaveCounterSec1).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec1 = prefs.getInt(saveCounterSec1, 0);
        SaveCounterSec1 = SaveCounterSec1 + SaveIncSec;
        prefs.edit().putInt(saveCounterSec1, SaveCounterSec1).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec1 = prefs.getInt(saveCounterSec1, 0);
        SaveCounterSec1 = SaveCounterSec1 - SaveIncSec;
        prefs.edit().putInt(saveCounterSec1, SaveCounterSec1).commit();

    }

    //resets value to 0
    public static void resetSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec1 = prefs.getInt(saveCounterSec1, 0);
        SaveCounterSec1=0;
        prefs.edit().putInt(saveCounterSec1, SaveCounterSec1).commit();

    }

    //method used to get the value
    public static int getCount1(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c1= prefs.getInt(saveCounterSec1, SaveCounterSec1);

        return c1;
    }

    // saves input string when called
    public static void setTaskName1(Context context, String taskNameSec) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskNameSec", taskNameSec);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName1(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskNameSec", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //Row 2

    // Saves counter when called
    public static void SaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterSec2, SaveCounterSec2).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec2 = prefs.getInt(saveCounterSec2, 0);
        SaveCounterSec2 = SaveCounterSec2 + SaveIncSec;
        prefs.edit().putInt(saveCounterSec2, SaveCounterSec2).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec2 = prefs.getInt(saveCounterSec2, 0);
        SaveCounterSec2 = SaveCounterSec2 - SaveIncSec;
        prefs.edit().putInt(saveCounterSec2, SaveCounterSec2).commit();

    }

    //resets value to 0
    public static void resetSaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec2 = prefs.getInt(saveCounterSec2, 0);
        SaveCounterSec2=0;
        prefs.edit().putInt(saveCounterSec2, SaveCounterSec2).commit();

    }

    //method used to get the value
    public static int getCount2(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c2= prefs.getInt(saveCounterSec2, SaveCounterSec2);

        return c2;
    }

    // saves input string when called
    public static void setTaskName2(Context context, String taskNameSec2) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskNameSec2", taskNameSec2);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName2(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskNameSec2", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //Row 3

    // Saves counter when called
    public static void SaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterSec3, SaveCounterSec3).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec3 = prefs.getInt(saveCounterSec3, 0);
        SaveCounterSec3 = SaveCounterSec3 + SaveIncSec;
        prefs.edit().putInt(saveCounterSec3, SaveCounterSec3).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec3 = prefs.getInt(saveCounterSec3, 0);
        SaveCounterSec3 = SaveCounterSec3 - SaveIncSec;
        prefs.edit().putInt(saveCounterSec3, SaveCounterSec3).commit();

    }

    //resets value to 0
    public static void resetSaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec3 = prefs.getInt(saveCounterSec3, 0);
        SaveCounterSec3=0;
        prefs.edit().putInt(saveCounterSec3, SaveCounterSec3).commit();

    }

    //method used to get the value
    public static int getCount3(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c3= prefs.getInt(saveCounterSec3, SaveCounterSec3);

        return c3;
    }

    // saves input string when called
    public static void setTaskName3(Context context, String taskNameSec3) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskNameSec3", taskNameSec3);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName3(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskNameSec3", "click to edit");
    }


    //----------------------------------------------------------------------------------------------
    //Row 4

    // Saves counter when called
    public static void SaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterSec4, SaveCounterSec4).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec4 = prefs.getInt(saveCounterSec4, 0);
        SaveCounterSec4 = SaveCounterSec4 + SaveIncSec;
        prefs.edit().putInt(saveCounterSec4, SaveCounterSec4).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec4 = prefs.getInt(saveCounterSec4, 0);
        SaveCounterSec4 = SaveCounterSec4 - SaveIncSec;
        prefs.edit().putInt(saveCounterSec4, SaveCounterSec4).commit();

    }

    //resets value to 0
    public static void resetSaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec4 = prefs.getInt(saveCounterSec4, 0);
        SaveCounterSec4=0;
        prefs.edit().putInt(saveCounterSec4, SaveCounterSec4).commit();

    }

    //method used to get the value
    public static int getCount4(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c4= prefs.getInt(saveCounterSec4, SaveCounterSec4);

        return c4;
    }

    // saves input string when called
    public static void setTaskName4(Context context, String taskNameSec4) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskNameSec4", taskNameSec4);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName4(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskNameSec4", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //Row 5

    // Saves counter when called
    public static void SaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterSec5, SaveCounterSec5).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec5 = prefs.getInt(saveCounterSec5, 0);
        SaveCounterSec5 = SaveCounterSec5 + SaveIncSec;
        prefs.edit().putInt(saveCounterSec5, SaveCounterSec5).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec5 = prefs.getInt(saveCounterSec5, 0);
        SaveCounterSec5 = SaveCounterSec5 - SaveIncSec;
        prefs.edit().putInt(saveCounterSec5, SaveCounterSec5).commit();

    }

    //resets value to 0
    public static void resetSaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterSec5 = prefs.getInt(saveCounterSec5, 0);
        SaveCounterSec5=0;
        prefs.edit().putInt(saveCounterSec5, SaveCounterSec5).commit();

    }

    //method used to get the value
    public static int getCount5(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c5= prefs.getInt(saveCounterSec5, SaveCounterSec5);

        return c5;
    }

    // saves input string when called
    public static void setTaskName5(Context context, String taskNameSec5) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskNameSec5", taskNameSec5);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName5(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskNameSec5", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //incement

    // saves increment amount when called
    public static void saveIncInt(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveIncSec, SaveIncSec).commit();

    }

    // gets increment amount when called
    public static int getIncInt(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int cInc= prefs.getInt(saveIncSec, SaveIncSec);

        return cInc;
    }


    //----------------------------------------------------------------------------------------------
    //Seconds

    // saves time value amount when called
    public static void saveSecInt(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveSec, SaveSec).commit();

    }

    // gets time value amount when called
    public static int getSecInt(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int cInc= prefs.getInt(saveSec, SaveSec);

        return cInc;
    }

}
