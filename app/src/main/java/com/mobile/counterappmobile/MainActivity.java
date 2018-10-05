package com.mobile.counterappmobile;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    private TextView textsave1;
    private TextView editTask1;

    private TextView textsave2;
    private TextView editTask2;

    private TextView textsave3;
    private TextView editTask3;

    private TextView textsave4;
    private TextView editTask4;

    private TextView textsave5;
    private TextView editTask5;

    private TextView textsave6;
    private TextView editTask6;

    public static int adShowNum = 4;

    // depending on the value of ActivityCount
    // the increment and time will be set to that specific activity
    // this value will track what activity the user is on
    public static int ActivityCount = 0;

    private int SaveInc2;

    // declares variable as int with a value
    public static int AdShow = 0;
    // decales variable as string
    public static String adShow = "AdShow";

    private AdView mAdView;

    NumberPicker noPicker = null;

    //real ad code
    //MobileAds.initialize(this, "ca-app-pub-5053096756111759~4626258539");
    //test ad
    // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713

    public static String adUnitInit = "ca-app-pub-3940256099942544~3347511713";

    //real ad code
    //mInterstitialAd.setAdUnitId("ca-app-pub-5053096756111759/7618542948");
    //test ad code
    //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/8691691433");

    public static String adUnitID = "ca-app-pub-3940256099942544/1033173712";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noPicker = (NumberPicker)findViewById(R.id.pickNumTime);
        //sets minimum value to 1
        noPicker.setMinValue(1);
        //sets maximum value to 100000
        noPicker.setMaxValue(100000);

        noPicker.setValue(DataPersistMan.getIncInt(MainActivity.this));

        noPicker.setWrapSelectorWheel(false);

        noPicker.setOnValueChangedListener( new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int
                    oldVal, int newVal) {

                DataPersistMan.SaveInc = noPicker.getValue();
                DataPersistMan.saveIncInt(MainActivity.this);
            }
        });

        //noPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        //initializes ads
        MobileAds.initialize(this, adUnitInit);

        //gets ads ready to load
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(adUnitID);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // sets the increment to saved increment
        DataPersistMan.SaveInc = DataPersistMan.getIncInt(MainActivity.this);

        //-------------------------------------------------
        //row 1
        editTask1 = (TextView) findViewById(R.id.editTask1);
        editTask1.setVisibility(View.INVISIBLE);
        textsave1 = (TextView) findViewById(R.id.task1);
        //sets name to saved name on startup
        textsave1.setText(DataPersistMan.getTaskName1(MainActivity.this) );
        editTask1.setText(DataPersistMan.getTaskName1(MainActivity.this) );

        //sets counter value to saved value
        TextView c = (TextView) findViewById(R.id.counter1);
        c.setText(DataPersistMan.getCount1(MainActivity.this)+"");

        // when keypad enter button is pressed
        ((EditText)findViewById(R.id.editTask1)).setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        // Identifier of the action. This will be either the identifier you supplied,
                        // or EditorInfo.IME_NULL if being called due to the enter key being pressed.
                        if (actionId == EditorInfo.IME_ACTION_SEARCH
                                || actionId == EditorInfo.IME_ACTION_DONE
                                || event.getAction() == KeyEvent.ACTION_DOWN
                                && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                            editTask1.setVisibility(View.INVISIBLE);
                            // saves new name
                            DataPersistMan.setTaskName1(MainActivity.this,editTask1.getText().toString());
                            //sets the text as the saved name
                            textsave1.setText(DataPersistMan.getTaskName1(MainActivity.this) );
                            textsave1.setVisibility(View.VISIBLE);

                            return true;
                        }
                        // Return true if you have consumed the action, else false.
                        return false;
                    }
                });

        //-------------------------------------------------
        //row 2
        editTask2 = (TextView) findViewById(R.id.editTask2);
        editTask2.setVisibility(View.INVISIBLE);
        textsave2 = (TextView) findViewById(R.id.task2);
        //sets name to saved name on startup
        textsave2.setText(DataPersistMan.getTaskName2(MainActivity.this) );
        editTask2.setText(DataPersistMan.getTaskName2(MainActivity.this) );

        //sets counter value to saved value
        TextView c2 = (TextView) findViewById(R.id.counter2);
        c2.setText(DataPersistMan.getCount2(MainActivity.this)+"");

        // when keypad enter button is pressed
        ((EditText)findViewById(R.id.editTask2)).setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        // Identifier of the action. This will be either the identifier you supplied,
                        // or EditorInfo.IME_NULL if being called due to the enter key being pressed.
                        if (actionId == EditorInfo.IME_ACTION_SEARCH
                                || actionId == EditorInfo.IME_ACTION_DONE
                                || event.getAction() == KeyEvent.ACTION_DOWN
                                && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                            editTask2.setVisibility(View.INVISIBLE);
                            // saves new name
                            DataPersistMan.setTaskName2(MainActivity.this,editTask2.getText().toString());
                            //sets the text as the saved name
                            textsave2.setText(DataPersistMan.getTaskName2(MainActivity.this) );
                            textsave2.setVisibility(View.VISIBLE);

                            return true;
                        }
                        // Return true if you have consumed the action, else false.
                        return false;
                    }
                });

        //-------------------------------------------------
        //row 3
        editTask3 = (TextView) findViewById(R.id.editTask3);
        editTask3.setVisibility(View.INVISIBLE);
        textsave3 = (TextView) findViewById(R.id.task3);
        //sets name to saved name on startup
        textsave3.setText(DataPersistMan.getTaskName3(MainActivity.this) );
        editTask3.setText(DataPersistMan.getTaskName3(MainActivity.this) );

        //sets counter value to saved value
        TextView c3 = (TextView) findViewById(R.id.counter3);
        c3.setText(DataPersistMan.getCount3(MainActivity.this)+"");

        // when keypad enter button is pressed
        ((EditText)findViewById(R.id.editTask3)).setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        // Identifier of the action. This will be either the identifier you supplied,
                        // or EditorInfo.IME_NULL if being called due to the enter key being pressed.
                        if (actionId == EditorInfo.IME_ACTION_SEARCH
                                || actionId == EditorInfo.IME_ACTION_DONE
                                || event.getAction() == KeyEvent.ACTION_DOWN
                                && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                            editTask3.setVisibility(View.INVISIBLE);
                            // saves new name
                            DataPersistMan.setTaskName3(MainActivity.this,editTask3.getText().toString());
                            //sets the text as the saved name
                            textsave3.setText(DataPersistMan.getTaskName3(MainActivity.this) );
                            textsave3.setVisibility(View.VISIBLE);

                            return true;
                        }
                        // Return true if you have consumed the action, else false.
                        return false;
                    }
                });

        //-------------------------------------------------
        //row 4
        editTask4 = (TextView) findViewById(R.id.editTask4);
        editTask4.setVisibility(View.INVISIBLE);
        textsave4 = (TextView) findViewById(R.id.task4);
        //sets name to saved name on startup
        textsave4.setText(DataPersistMan.getTaskName4(MainActivity.this) );
        editTask4.setText(DataPersistMan.getTaskName4(MainActivity.this) );

        //sets counter value to saved value
        TextView c4 = (TextView) findViewById(R.id.counter4);
        c4.setText(DataPersistMan.getCount4(MainActivity.this)+"");

        // when keypad enter button is pressed
        ((EditText)findViewById(R.id.editTask4)).setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        // Identifier of the action. This will be either the identifier you supplied,
                        // or EditorInfo.IME_NULL if being called due to the enter key being pressed.
                        if (actionId == EditorInfo.IME_ACTION_SEARCH
                                || actionId == EditorInfo.IME_ACTION_DONE
                                || event.getAction() == KeyEvent.ACTION_DOWN
                                && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                            editTask4.setVisibility(View.INVISIBLE);
                            // saves new name
                            DataPersistMan.setTaskName4(MainActivity.this,editTask4.getText().toString());
                            //sets the text as the saved name
                            textsave4.setText(DataPersistMan.getTaskName4(MainActivity.this) );
                            textsave4.setVisibility(View.VISIBLE);

                            return true;
                        }
                        // Return true if you have consumed the action, else false.
                        return false;
                    }
                });


        //-------------------------------------------------
        //row 5
        editTask5 = (TextView) findViewById(R.id.editTask5);
        editTask5.setVisibility(View.INVISIBLE);
        textsave5 = (TextView) findViewById(R.id.task5);
        //sets name to saved name on startup
        textsave5.setText(DataPersistMan.getTaskName5(MainActivity.this) );
        editTask5.setText(DataPersistMan.getTaskName5(MainActivity.this) );

        //sets counter value to saved value
        TextView c5 = (TextView) findViewById(R.id.counter5);
        c5.setText(DataPersistMan.getCount5(MainActivity.this)+"");

        // when keypad enter button is pressed
        ((EditText)findViewById(R.id.editTask5)).setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        // Identifier of the action. This will be either the identifier you supplied,
                        // or EditorInfo.IME_NULL if being called due to the enter key being pressed.
                        if (actionId == EditorInfo.IME_ACTION_SEARCH
                                || actionId == EditorInfo.IME_ACTION_DONE
                                || event.getAction() == KeyEvent.ACTION_DOWN
                                && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                            editTask5.setVisibility(View.INVISIBLE);
                            // saves new name
                            DataPersistMan.setTaskName5(MainActivity.this,editTask5.getText().toString());
                            //sets the text as the saved name
                            textsave5.setText(DataPersistMan.getTaskName5(MainActivity.this) );
                            textsave5.setVisibility(View.VISIBLE);

                            return true;
                        }
                        // Return true if you have consumed the action, else false.
                        return false;
                    }
                });

        //-------------------------------------------------
        //row 6
        editTask6 = (TextView) findViewById(R.id.editTask6);
        editTask6.setVisibility(View.INVISIBLE);
        textsave6 = (TextView) findViewById(R.id.task6);
        //sets name to saved name on startup
        textsave6.setText(DataPersistMan.getTaskName6(MainActivity.this) );
        editTask6.setText(DataPersistMan.getTaskName6(MainActivity.this) );

        //sets counter value to saved value
        TextView c6 = (TextView) findViewById(R.id.counter6);
        c6.setText(DataPersistMan.getCount6(MainActivity.this)+"");

        // when keypad enter button is pressed
        ((EditText)findViewById(R.id.editTask6)).setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        // Identifier of the action. This will be either the identifier you supplied,
                        // or EditorInfo.IME_NULL if being called due to the enter key being pressed.
                        if (actionId == EditorInfo.IME_ACTION_SEARCH
                                || actionId == EditorInfo.IME_ACTION_DONE
                                || event.getAction() == KeyEvent.ACTION_DOWN
                                && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                            editTask6.setVisibility(View.INVISIBLE);
                            // saves new name
                            DataPersistMan.setTaskName6(MainActivity.this,editTask6.getText().toString());
                            //sets the text as the saved name
                            textsave6.setText(DataPersistMan.getTaskName6(MainActivity.this) );
                            textsave6.setVisibility(View.VISIBLE);

                            return true;
                        }
                        // Return true if you have consumed the action, else false.
                        return false;
                    }
                });

        //--------------------------------------------------------------------------
        // change activity

        Button btnSec = (Button)findViewById(R.id.button10);

        btnSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //changes to new activity
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                //finishes activity
                finish();
                // depending on the value of ActivityCount
                // the increment and time will be set to that specific activity
                ActivityCount = 1;


                // loads ad if...
                if(getAdShowCount(MainActivity.this) < adShowNum) {
                    AdShowCount++;
                    saveAdShowCount(MainActivity.this);
                }

                if (mInterstitialAd.isLoaded() && getAdShowCount(MainActivity.this) == adShowNum) {
                    mInterstitialAd.show();
                    AdShowCount = 0;
                    saveAdShowCount(MainActivity.this);
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {

                }

            }
        });

        Button btnDay = (Button)findViewById(R.id.button11);

        btnDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Main3Activity.class));
                finish();
                ActivityCount = 2;


                // loads ad if...
                if(getAdShowCount(MainActivity.this) < adShowNum) {
                    AdShowCount++;
                    saveAdShowCount(MainActivity.this);
                }

                if (mInterstitialAd.isLoaded() && getAdShowCount(MainActivity.this) == adShowNum) {
                    mInterstitialAd.show();
                    AdShowCount = 0;
                    saveAdShowCount(MainActivity.this);
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {

                }

            }
        });

        Button btnLoc = (Button)findViewById(R.id.button9);

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Main4Activity.class));
                finish();

                MainActivity.ActivityCount = 3;

                // loads ad if...
                if(getAdShowCount(MainActivity.this) < adShowNum) {
                    AdShowCount++;
                    saveAdShowCount(MainActivity.this);
                }

                if (mInterstitialAd.isLoaded() && getAdShowCount(MainActivity.this) == adShowNum) {
                    mInterstitialAd.show();
                    AdShowCount = 0;
                    saveAdShowCount(MainActivity.this);
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {

                }


            }
        });

        //--------------------------------------------------------------------------
        //ad listener

        if(getRate(MainActivity.this) < 5) {
            Rate++;
            saveRate(MainActivity.this);
        }

        if(getRate(MainActivity.this) == 5) {
            startActivity(new Intent(MainActivity.this, RateApp.class));
        }

    }

    private static SharedPreferences prefs;

    // declares variable as int with a value
    public static int Rate = 0;
    // decales variable as string
    public static String rate = "Rate";

    // Saves counter when called
    public static void saveRate(Context context) {
        prefs = context.getSharedPreferences("com.kanonjitech.phoneUseTracker", context.MODE_PRIVATE);
        prefs.edit().putInt(rate, Rate).commit();

    }

    //method used to get the value
    public static int getRate(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.kanonjitech.phoneUseTracker", context.MODE_PRIVATE);
        int l1= prefs.getInt(rate, Rate);

        return l1;
    }

    // declares variable as int with a value
    public static int AdShowCount = 0;
    // decales variable as string
    public static String adShowCount = "AdShowCount";

    // Saves counter when called
    public static void saveAdShowCount(Context context) {
        prefs = context.getSharedPreferences("com.kanonjitech.phoneUseTracker", context.MODE_PRIVATE);
        prefs.edit().putInt(adShowCount, AdShowCount).commit();

    }

    //method used to get the value
    public static int getAdShowCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.kanonjitech.phoneUseTracker", context.MODE_PRIVATE);
        int l1= prefs.getInt(adShowCount, AdShowCount);

        return l1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //dropdown menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.increment) {
            rateApp();
        } else {
            return super.onContextItemSelected(item);
        }
        return true;
    }

    public void rateApp() {
        Uri uri = Uri.parse("market://details?id=" + MainActivity.this.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName())));
        }
    }


    //----------------------------------------------------------------------------------------------
    //Row 1

    //on button click

    //calls method from DataPersistMan class and updates textView
    public void addInc1(View v){

        DataPersistMan.addSaveCounter1(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter1);
        c.setText(DataPersistMan.getCount1(MainActivity.this)+"");

        //Preferences.saveCounter(MainActivity.this);
    }

    //calls method from DataPersistMan class and updates textView
    public void subtractInc1(View v){

        DataPersistMan.subtractSaveCounter1(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter1);
        c.setText(DataPersistMan.getCount1(MainActivity.this)+"");

    }

    //shares to local apps
    public void shareProgress1(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistMan.getTaskName1(MainActivity.this) + " " + DataPersistMan.getCount1(MainActivity.this) + " times");
        MainActivity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistMan class and updates textView
    public void resetInt1(View v){

        DataPersistMan.resetSaveCounter1(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter1);
        c.setText(DataPersistMan.getCount1(MainActivity.this)+"");

    }

    //calls method from DataPersistMan class and updates textView
    public void editText1(View v){

        editTask1 = (TextView) findViewById(R.id.editTask1);
        editTask1.setVisibility(View.VISIBLE);
        textsave1 = (TextView) findViewById(R.id.task1);
        textsave1.setVisibility(View.INVISIBLE);

    }

    //----------------------------------------------------------------------------------------------
    //Row 2

    //on button click

    //calls method from DataPersistMan class and updates textView
    public void addInc2(View v){

        DataPersistMan.addSaveCounter2(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter2);
        c.setText(DataPersistMan.getCount2(MainActivity.this)+"");

        //Preferences.saveCounter(MainActivity.this);
    }

    //calls method from DataPersistMan class and updates textView
    public void subtractInc2(View v){

        DataPersistMan.subtractSaveCounter2(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter2);
        c.setText(DataPersistMan.getCount2(MainActivity.this)+"");

    }

    //shares to local apps
    public void shareProgress2(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistMan.getTaskName2(MainActivity.this) + " " + DataPersistMan.getCount2(MainActivity.this) + " times");
        MainActivity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistMan class and updates textView
    public void resetInt2(View v){

        DataPersistMan.resetSaveCounter2(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter2);
        c.setText(DataPersistMan.getCount2(MainActivity.this)+"");

    }

    //calls method from DataPersistMan class and updates textView
    public void editText2(View v){

        editTask2 = (TextView) findViewById(R.id.editTask2);
        editTask2.setVisibility(View.VISIBLE);
        textsave2 = (TextView) findViewById(R.id.task2);
        textsave2.setVisibility(View.INVISIBLE);

    }

    //----------------------------------------------------------------------------------------------
    //Row 3

    //on button click

    //calls method from DataPersistMan class and updates textView
    public void addInc3(View v){

        DataPersistMan.addSaveCounter3(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter3);
        c.setText(DataPersistMan.getCount3(MainActivity.this)+"");

        //Preferences.saveCounter(MainActivity.this);
    }

    //calls method from DataPersistMan class and updates textView
    public void subtractInc3(View v){

        DataPersistMan.subtractSaveCounter3(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter3);
        c.setText(DataPersistMan.getCount3(MainActivity.this)+"");

    }

    //shares to local apps
    public void shareProgress3(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistMan.getTaskName3(MainActivity.this) + " " + DataPersistMan.getCount3(MainActivity.this) + " times");
        MainActivity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistMan class and updates textView
    public void resetInt3(View v){

        DataPersistMan.resetSaveCounter3(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter3);
        c.setText(DataPersistMan.getCount3(MainActivity.this)+"");

    }

    //calls method from DataPersistMan class and updates textView
    public void editText3(View v){

        editTask3 = (TextView) findViewById(R.id.editTask3);
        editTask3.setVisibility(View.VISIBLE);
        textsave3 = (TextView) findViewById(R.id.task3);
        textsave3.setVisibility(View.INVISIBLE);

    }

    //----------------------------------------------------------------------------------------------
    //Row 4

    //on button click

    //calls method from DataPersistMan class and updates textView
    public void addInc4(View v){

        DataPersistMan.addSaveCounter4(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter4);
        c.setText(DataPersistMan.getCount4(MainActivity.this)+"");

        //Preferences.saveCounter(MainActivity.this);
    }

    //calls method from DataPersistMan class and updates textView
    public void subtractInc4(View v){

        DataPersistMan.subtractSaveCounter4(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter4);
        c.setText(DataPersistMan.getCount4(MainActivity.this)+"");

    }

    //shares to local apps
    public void shareProgress4(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistMan.getTaskName4(MainActivity.this) + " " + DataPersistMan.getCount4(MainActivity.this) + " times");
        MainActivity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistMan class and updates textView
    public void resetInt4(View v){

        DataPersistMan.resetSaveCounter4(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter4);
        c.setText(DataPersistMan.getCount4(MainActivity.this)+"");

    }

    //calls method from DataPersistMan class and updates textView
    public void editText4(View v){

        editTask4 = (TextView) findViewById(R.id.editTask4);
        editTask4.setVisibility(View.VISIBLE);
        textsave4 = (TextView) findViewById(R.id.task4);
        textsave4.setVisibility(View.INVISIBLE);

    }

    //----------------------------------------------------------------------------------------------
    //Row 5

    //on button click

    //calls method from DataPersistMan class and updates textView
    public void addInc5(View v){

        DataPersistMan.addSaveCounter5(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter5);
        c.setText(DataPersistMan.getCount5(MainActivity.this)+"");

        //Preferences.saveCounter(MainActivity.this);
    }

    //calls method from DataPersistMan class and updates textView
    public void subtractInc5(View v){

        DataPersistMan.subtractSaveCounter5(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter5);
        c.setText(DataPersistMan.getCount5(MainActivity.this)+"");

    }

    //shares to local apps
    public void shareProgress5(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistMan.getTaskName5(MainActivity.this) + " " + DataPersistMan.getCount5(MainActivity.this) + " times");
        MainActivity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistMan class and updates textView
    public void resetInt5(View v){

        DataPersistMan.resetSaveCounter5(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter5);
        c.setText(DataPersistMan.getCount5(MainActivity.this)+"");

    }

    //calls method from DataPersistMan class and updates textView
    public void editText5(View v){

        editTask5 = (TextView) findViewById(R.id.editTask5);
        editTask5.setVisibility(View.VISIBLE);
        textsave5 = (TextView) findViewById(R.id.task5);
        textsave5.setVisibility(View.INVISIBLE);

    }

    //----------------------------------------------------------------------------------------------
    //Row 6

    //on button click

    //calls method from DataPersistMan class and updates textView
    public void addInc6(View v){

        DataPersistMan.addSaveCounter6(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter6);
        c.setText(DataPersistMan.getCount6(MainActivity.this)+"");

        //Preferences.saveCounter(MainActivity.this);
    }

    //calls method from DataPersistMan class and updates textView
    public void subtractInc6(View v){

        DataPersistMan.subtractSaveCounter6(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter6);
        c.setText(DataPersistMan.getCount6(MainActivity.this)+"");

    }

    //shares to local apps
    public void shareProgress6(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistMan.getTaskName6(MainActivity.this) + " " + DataPersistMan.getCount6(MainActivity.this) + " times");
        MainActivity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistMan class and updates textView
    public void resetInt6(View v){

        DataPersistMan.resetSaveCounter6(MainActivity.this);
        TextView c = (TextView) findViewById(R.id.counter6);
        c.setText(DataPersistMan.getCount6(MainActivity.this)+"");

    }

    //calls method from DataPersistMan class and updates textView
    public void editText6(View v){

        editTask6 = (TextView) findViewById(R.id.editTask6);
        editTask6.setVisibility(View.VISIBLE);
        textsave6 = (TextView) findViewById(R.id.task6);
        textsave6.setVisibility(View.INVISIBLE);

    }


}
