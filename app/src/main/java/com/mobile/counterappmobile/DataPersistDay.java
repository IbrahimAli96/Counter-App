package com.mobile.counterappmobile;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ibrahim on 04/04/2018.
 */

public class DataPersistDay {

    //declare variable
    private static SharedPreferences prefs;

    // declares variable as int with a value
    public static int SaveAlm = 0;
    // decales variable as string
    public static String saveAlm = "SaveAlm";

    public static int SaveCounterDay1 = 0;
    public static String saveCounterDay1 = "SaveCounterDay1";

    public static int SaveCounterDay2 = 0;
    public static String saveCounterDay2 = "SaveCounterDay22";

    public static int SaveCounterDay3 = 0;
    public static String saveCounterDay3 = "SaveCounterDay3";

    public static int SaveCounterDay4 = 0;
    public static String saveCounterDay4 = "SaveCounterDay4";

    public static int SaveCounterDay5 = 0;
    public static String saveCounterDay5 = "SaveCounterDay5";

    public static int SaveIncDay = 1;
    public static String saveIncDay = "SaveIncDay";

    public static int SaveDay = 1;
    public static String saveDay = "SaveDay";

    //----------------------------------------------------------------------------------------------
    // alarm

    // saves this value with the value of SaveAlm
    public static void saveAlm(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveAlm, SaveAlm).commit();

    }

    // used to get the vlaue of SaveAlm
    public static int getAlm(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int a1= prefs.getInt(saveAlm, SaveAlm);

        return a1;
    }

    //----------------------------------------------------------------------------------------------
    //Row 1

    // Saves counter when called
    public static void SaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterDay1, SaveCounterDay1).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay1 = prefs.getInt(saveCounterDay1, 0);
        SaveCounterDay1 = SaveCounterDay1 + SaveIncDay;
        prefs.edit().putInt(saveCounterDay1, SaveCounterDay1).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay1 = prefs.getInt(saveCounterDay1, 0);
        SaveCounterDay1 = SaveCounterDay1 - SaveIncDay;
        prefs.edit().putInt(saveCounterDay1, SaveCounterDay1).commit();

    }

    //resets value to 0
    public static void resetSaveCounter1(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay1 = prefs.getInt(saveCounterDay1, 0);
        SaveCounterDay1=0;
        prefs.edit().putInt(saveCounterDay1, SaveCounterDay1).commit();

    }

    //method used to get the value
    public static int getCount1(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c1= prefs.getInt(saveCounterDay1, SaveCounterDay1);

        return c1;
    }

    // saves input string when called
    public static void setTaskName1(Context context, String taskNameDay) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskNameDay", taskNameDay);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName1(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskNameDay", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //Row 2

    // Saves counter when called
    public static void SaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterDay2, SaveCounterDay2).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay2 = prefs.getInt(saveCounterDay2, 0);
        SaveCounterDay2 = SaveCounterDay2 + SaveIncDay;
        prefs.edit().putInt(saveCounterDay2, SaveCounterDay2).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay2 = prefs.getInt(saveCounterDay2, 0);
        SaveCounterDay2 = SaveCounterDay2 - SaveIncDay;
        prefs.edit().putInt(saveCounterDay2, SaveCounterDay2).commit();

    }

    //resets value to 0
    public static void resetSaveCounter2(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay2 = prefs.getInt(saveCounterDay2, 0);
        SaveCounterDay2=0;
        prefs.edit().putInt(saveCounterDay2, SaveCounterDay2).commit();

    }

    //method used to get the value
    public static int getCount2(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c2= prefs.getInt(saveCounterDay2, SaveCounterDay2);

        return c2;
    }

    // saves input string when called
    public static void setTaskName2(Context context, String taskNameDay2) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskNameDay2", taskNameDay2);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName2(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskNameDay2", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //Row 3

    // Saves counter when called
    public static void SaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterDay3, SaveCounterDay3).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay3 = prefs.getInt(saveCounterDay3, 0);
        SaveCounterDay3 = SaveCounterDay3 + SaveIncDay;
        prefs.edit().putInt(saveCounterDay3, SaveCounterDay3).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay3 = prefs.getInt(saveCounterDay3, 0);
        SaveCounterDay3 = SaveCounterDay3 - SaveIncDay;
        prefs.edit().putInt(saveCounterDay3, SaveCounterDay3).commit();

    }

    //resets value to 0
    public static void resetSaveCounter3(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay3 = prefs.getInt(saveCounterDay3, 0);
        SaveCounterDay3=0;
        prefs.edit().putInt(saveCounterDay3, SaveCounterDay3).commit();

    }

    //method used to get the value
    public static int getCount3(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c3= prefs.getInt(saveCounterDay3, SaveCounterDay3);

        return c3;
    }

    // saves input string when called
    public static void setTaskName3(Context context, String taskNameDay3) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskNameDay3", taskNameDay3);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName3(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskNameDay3", "click to edit");
    }

    //----------------------------------------------------------------------------------------------
    //Row 4

    // Saves counter when called
    public static void SaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterDay4, SaveCounterDay4).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay4 = prefs.getInt(saveCounterDay4, 0);
        SaveCounterDay4 = SaveCounterDay4 + SaveIncDay;
        prefs.edit().putInt(saveCounterDay4, SaveCounterDay4).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay4 = prefs.getInt(saveCounterDay4, 0);
        SaveCounterDay4 = SaveCounterDay4 - SaveIncDay;
        prefs.edit().putInt(saveCounterDay4, SaveCounterDay4).commit();

    }

    //resets value to 0
    public static void resetSaveCounter4(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay4 = prefs.getInt(saveCounterDay4, 0);
        SaveCounterDay4=0;
        prefs.edit().putInt(saveCounterDay4, SaveCounterDay4).commit();

    }

    //method used to get the value
    public static int getCount4(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c4= prefs.getInt(saveCounterDay4, SaveCounterDay4);

        return c4;
    }

    // saves input string when called
    public static void setTaskName4(Context context, String taskNameDay4) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskNameDay4", taskNameDay4);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName4(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskNameDay4", "click to edit");
    }


    //----------------------------------------------------------------------------------------------
    //Row 5

    // Saves counter when called
    public static void SaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveCounterDay5, SaveCounterDay5).commit();

    }

    // saves and adds increment amount
    public static void addSaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay5 = prefs.getInt(saveCounterDay5, 0);
        SaveCounterDay5 = SaveCounterDay5 + SaveIncDay;
        prefs.edit().putInt(saveCounterDay5, SaveCounterDay5).commit();

    }

    //saves and takeaway increment amount
    public static void subtractSaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay5 = prefs.getInt(saveCounterDay5, 0);
        SaveCounterDay5 = SaveCounterDay5 - SaveIncDay;
        prefs.edit().putInt(saveCounterDay5, SaveCounterDay5).commit();

    }

    //resets value to 0
    public static void resetSaveCounter5(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        SaveCounterDay5 = prefs.getInt(saveCounterDay5, 0);
        SaveCounterDay5=0;
        prefs.edit().putInt(saveCounterDay5, SaveCounterDay5).commit();

    }

    //method used to get the value
    public static int getCount5(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int c5= prefs.getInt(saveCounterDay5, SaveCounterDay5);

        return c5;
    }

    // saves input string when called
    public static void setTaskName5(Context context, String taskNameDay5) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("taskNameDay5", taskNameDay5);
        editor.commit();
    }

    // gets input string when called
    public static String getTaskName5(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", 0);
        return prefs.getString("taskNameDay5", "click to edit");
    }


    //----------------------------------------------------------------------------------------------
    //incement

    // saves increment amount when called
    public static void saveIncInt(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveIncDay, SaveIncDay).commit();

    }

    // gets increment amount when called
    public static int getIncInt(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int cInc= prefs.getInt(saveIncDay, SaveIncDay);

        return cInc;
    }


    //----------------------------------------------------------------------------------------------
    //Days

    // saves time value amount when called
    public static void saveDayInt(Context context) {
        prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        prefs.edit().putInt(saveDay, SaveDay).commit();

    }

    // gets time value amount when called
    public static int getDayInt(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.mobile.counterappmobile", context.MODE_PRIVATE);
        int cInc= prefs.getInt(saveDay, SaveDay);

        return cInc;
    }

}
