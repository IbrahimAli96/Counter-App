package com.mobile.counterappmobile;

import android.content.ActivityNotFoundException;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Main2Activity extends AppCompatActivity {

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

    private AdView mAdView;

    NumberPicker noPicker = null;

    NumberPicker noPicker2 = null;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //initializes ads
        MobileAds.initialize(this, MainActivity.adUnitInit);

        //gets ads ready to load
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(MainActivity.adUnitID);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        noPicker = (NumberPicker)findViewById(R.id.pickNum);
        //sets minimum value to 1
        noPicker.setMinValue(1);
        //sets maximum value to 100000
        noPicker.setMaxValue(100000);

        noPicker.setValue(DataPersistSec.getIncInt(Main2Activity.this));

        noPicker.setWrapSelectorWheel(false);

        noPicker.setOnValueChangedListener( new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int
                    oldVal, int newVal) {

                DataPersistSec.SaveIncSec = noPicker.getValue();
                DataPersistSec.saveIncInt(Main2Activity.this);
            }
        });

        noPicker2 = (NumberPicker)findViewById(R.id.pickNumTime);
        //sets maximum value to 100000
        noPicker2.setMaxValue(100000);
        //sets minimum value to 1
        noPicker2.setMinValue(1);

        noPicker2.setValue(DataPersistSec.getSecInt(Main2Activity.this));

        noPicker2.setWrapSelectorWheel(false);

        noPicker2.setOnValueChangedListener( new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int
                    oldVal, int newVal) {

                    DataPersistSec.SaveSec = noPicker2.getValue();
                    DataPersistSec.saveSecInt(Main2Activity.this);

            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //----------------------------------------------------------------------------
        //starts alarm only when activity is first opened

        DataPersistSec.SaveAlm1 = DataPersistDay.getAlm(Main2Activity.this);

        // starts counter when activity starts
        // so the timer is continually checking every X seconds if switch is on
        startService(new Intent(this, BroadcastService.class));

        // sets the increment to saved increment
        DataPersistSec.SaveIncSec = DataPersistSec.getIncInt(Main2Activity.this);

        // sets the seconds to saved increment
        DataPersistSec.SaveSec = DataPersistSec.getSecInt(Main2Activity.this);

        //-------------------------------------------------
        //row 1

        editTask1 = (TextView) findViewById(R.id.editTask1);
        editTask1.setVisibility(View.INVISIBLE);
        textsave1 = (TextView) findViewById(R.id.task1);
        //sets name to saved name on startup
        textsave1.setText(DataPersistSec.getTaskName1(Main2Activity.this) );
        editTask1.setText(DataPersistSec.getTaskName1(Main2Activity.this) );

        //sets counter value to saved value
        TextView c = (TextView) findViewById(R.id.counter1);
        c.setText(DataPersistSec.getCount1(Main2Activity.this)+"");

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
                            DataPersistSec.setTaskName1(Main2Activity.this,editTask1.getText().toString());
                            //sets the text as the saved name
                            textsave1.setText(DataPersistSec.getTaskName1(Main2Activity.this) );
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
        textsave2.setText(DataPersistSec.getTaskName2(Main2Activity.this) );
        editTask2.setText(DataPersistSec.getTaskName2(Main2Activity.this) );

        //sets counter value to saved value
        TextView c2 = (TextView) findViewById(R.id.counter2);
        c2.setText(DataPersistSec.getCount2(Main2Activity.this)+"");

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
                            DataPersistSec.setTaskName2(Main2Activity.this,editTask2.getText().toString());
                            //sets the text as the saved name
                            textsave2.setText(DataPersistSec.getTaskName2(Main2Activity.this) );
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
        textsave3.setText(DataPersistSec.getTaskName3(Main2Activity.this) );
        editTask3.setText(DataPersistSec.getTaskName3(Main2Activity.this) );

        //sets counter value to saved value
        TextView c3 = (TextView) findViewById(R.id.counter3);
        c3.setText(DataPersistSec.getCount3(Main2Activity.this)+"");

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
                            DataPersistSec.setTaskName3(Main2Activity.this,editTask3.getText().toString());
                            //sets the text as the saved name
                            textsave3.setText(DataPersistSec.getTaskName3(Main2Activity.this) );
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
        textsave4.setText(DataPersistSec.getTaskName4(Main2Activity.this) );
        editTask4.setText(DataPersistSec.getTaskName4(Main2Activity.this) );

        //sets counter value to saved value
        TextView c4 = (TextView) findViewById(R.id.counter4);
        c4.setText(DataPersistSec.getCount4(Main2Activity.this)+"");

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
                            DataPersistSec.setTaskName4(Main2Activity.this,editTask4.getText().toString());
                            //sets the text as the saved name
                            textsave4.setText(DataPersistSec.getTaskName4(Main2Activity.this) );
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
        textsave5.setText(DataPersistSec.getTaskName5(Main2Activity.this) );
        editTask5.setText(DataPersistSec.getTaskName5(Main2Activity.this) );

        //sets counter value to saved value
        TextView c5 = (TextView) findViewById(R.id.counter5);
        c5.setText(DataPersistSec.getCount5(Main2Activity.this)+"");

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
                            DataPersistSec.setTaskName5(Main2Activity.this,editTask5.getText().toString());
                            //sets the text as the saved name
                            textsave5.setText(DataPersistSec.getTaskName5(Main2Activity.this) );
                            textsave5.setVisibility(View.VISIBLE);

                            return true;
                        }
                        // Return true if you have consumed the action, else false.
                        return false;
                    }
                });


        //--------------------------------------------------------------------------
        // change activity

        Button btnMan = (Button)findViewById(R.id.button8);

        btnMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //changes to new activity
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
                //finishes activity
                finish();
                // depending on the value of ActivityCount
                // the increment and time will be set to that specific activity
                MainActivity.ActivityCount = 0;

                if(MainActivity.getAdShowCount(Main2Activity.this) < MainActivity.adShowNum) {
                    MainActivity.AdShowCount++;
                    MainActivity.saveAdShowCount(Main2Activity.this);
                }

                if (mInterstitialAd.isLoaded() && MainActivity.getAdShowCount(Main2Activity.this) == MainActivity.adShowNum) {
                    mInterstitialAd.show();
                    MainActivity.AdShowCount = 0;
                    MainActivity.saveAdShowCount(Main2Activity.this);
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {

                }

            }
        });

        Button btnDay = (Button)findViewById(R.id.button11);

        btnDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
                finish();
                MainActivity.ActivityCount = 2;

                if(MainActivity.getAdShowCount(Main2Activity.this) < MainActivity.adShowNum) {
                    MainActivity.AdShowCount++;
                    MainActivity.saveAdShowCount(Main2Activity.this);
                }

                if (mInterstitialAd.isLoaded() && MainActivity.getAdShowCount(Main2Activity.this) == MainActivity.adShowNum) {
                    mInterstitialAd.show();
                    MainActivity.AdShowCount = 0;
                    MainActivity.saveAdShowCount(Main2Activity.this);
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {

                }

            }
        });

        Button btnLoc = (Button)findViewById(R.id.button9);

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this, Main4Activity.class));
                finish();

                MainActivity.ActivityCount = 3;

                if(MainActivity.getAdShowCount(Main2Activity.this) < MainActivity.adShowNum) {
                    MainActivity.AdShowCount++;
                    MainActivity.saveAdShowCount(Main2Activity.this);
                }

                if (mInterstitialAd.isLoaded() && MainActivity.getAdShowCount(Main2Activity.this) == MainActivity.adShowNum) {
                    mInterstitialAd.show();
                    MainActivity.AdShowCount = 0;
                    MainActivity.saveAdShowCount(Main2Activity.this);
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {

                }

            }
        });


        //switch on row 1
        //declaring switch from xml file
        final Switch switch1 = (Switch)findViewById(R.id.active1);

        //getting switch state onCreate
        SharedPreferences sharedPrefs = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE);
        switch1.setChecked(sharedPrefs.getBoolean("SwitchOnOffSec1", false));


        //checks for switch change
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (switch1.isChecked()) {
                    //Saves switches position to off
                    SharedPreferences.Editor editor = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE).edit();
                    editor.putBoolean("SwitchOnOffSec1", true);
                    editor.commit();
                }
                else {
                    //Saves switches position to on
                    SharedPreferences.Editor editor = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE).edit();
                    editor.putBoolean("SwitchOnOffSec1", false);
                    editor.commit();
                }
            }
        });



        //switch on row 2
        //declaring switch from xml file
        final Switch switch2 = (Switch)findViewById(R.id.active2);

        //getting switch state onCreate
        switch2.setChecked(sharedPrefs.getBoolean("SwitchOnOffSec2", false));

        //checks for switch change
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (switch2.isChecked()) {
                    //Saves switches position to off
                    SharedPreferences.Editor editor = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE).edit();
                    editor.putBoolean("SwitchOnOffSec2", true);
                    editor.commit();
                }
                else {
                    //Saves switches position to on
                    SharedPreferences.Editor editor = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE).edit();
                    editor.putBoolean("SwitchOnOffSec2", false);
                    editor.commit();
                }
            }
        });


        //switch on row 3
        //declaring switch from xml file
        final Switch switch3 = (Switch)findViewById(R.id.active3);

        //getting switch state onCreate
        switch3.setChecked(sharedPrefs.getBoolean("SwitchOnOffSec3", false));

        //checks for switch change
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (switch3.isChecked()) {
                    //Saves switches position to off
                    SharedPreferences.Editor editor = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE).edit();
                    editor.putBoolean("SwitchOnOffSec3", true);
                    editor.commit();
                }
                else {
                    //Saves switches position to on
                    SharedPreferences.Editor editor = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE).edit();
                    editor.putBoolean("SwitchOnOffSec3", false);
                    editor.commit();
                }
            }
        });

        //switch on row 4
        //declaring switch from xml file
        final Switch switch4 = (Switch)findViewById(R.id.active4);

        //getting switch state onCreate
        switch4.setChecked(sharedPrefs.getBoolean("SwitchOnOffSec4", false));

        //checks for switch change
        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (switch4.isChecked()) {
                    //Saves switches position to off
                    SharedPreferences.Editor editor = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE).edit();
                    editor.putBoolean("SwitchOnOffSec4", true);
                    editor.commit();
                }
                else {
                    //Saves switches position to on
                    SharedPreferences.Editor editor = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE).edit();
                    editor.putBoolean("SwitchOnOffSec4", false);
                    editor.commit();
                }
            }
        });

        //switch on row 5
        //declaring switch from xml file
        final Switch switch5 = (Switch)findViewById(R.id.active5);

        //getting switch state onCreate
        switch5.setChecked(sharedPrefs.getBoolean("SwitchOnOffSec5", false));

        //checks for switch change
        switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (switch5.isChecked()) {
                    //Saves switches position to off
                    SharedPreferences.Editor editor = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE).edit();
                    editor.putBoolean("SwitchOnOffSec5", true);
                    editor.commit();
                }
                else {
                    //Saves switches position to on
                    SharedPreferences.Editor editor = getSharedPreferences("com.mobile.counterappmobile", MODE_PRIVATE).edit();
                    editor.putBoolean("SwitchOnOffSec5", false);
                    editor.commit();
                }
            }
        });

        //when boolean change occurs the textview will update
        BoolChange.addMyBooleanListener(new ConnectionBooleanChangedListener() {
            @Override
            public void OnMyBooleanChanged() {

                TextView c1 = (TextView) findViewById(R.id.counter1);
                c1.setText(DataPersistSec.getCount1(Main2Activity.this)+"");

                TextView c2 = (TextView) findViewById(R.id.counter2);
                c2.setText(DataPersistSec.getCount2(Main2Activity.this)+"");

                TextView c3 = (TextView) findViewById(R.id.counter3);
                c3.setText(DataPersistSec.getCount3(Main2Activity.this)+"");

                TextView c4 = (TextView) findViewById(R.id.counter4);
                c4.setText(DataPersistSec.getCount4(Main2Activity.this)+"");

                TextView c5 = (TextView) findViewById(R.id.counter5);
                c5.setText(DataPersistSec.getCount5(Main2Activity.this)+"");

            }
        });

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
        }else {
            return super.onContextItemSelected(item);
        }
        return true;
    }

    public void rateApp() {
        Uri uri = Uri.parse("market://details?id=" + Main2Activity.this.getPackageName());
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
                    Uri.parse("http://play.google.com/store/apps/details?id=" + Main2Activity.this.getPackageName())));
        }
    }

    //----------------------------------------------------------------------------------------------
    //Row 1

    //on button click

    //calls method from DataPersistSec class and updates textView
    public void addInc1(View v){

        DataPersistSec.addSaveCounter1(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter1);
        c.setText(DataPersistSec.getCount1(Main2Activity.this)+"");

    }

    //calls method from DataPersistSec class and updates textView
    public void subtractInc1(View v){

        DataPersistSec.subtractSaveCounter1(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter1);
        c.setText(DataPersistSec.getCount1(Main2Activity.this)+"");

    }

    //shares to local apps
    public void shareProgress1(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistSec.getTaskName1(Main2Activity.this) + " " + DataPersistSec.getCount1(Main2Activity.this) + " times");
        Main2Activity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistSec class and updates textView
    public void resetInt1(View v){

        DataPersistSec.resetSaveCounter1(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter1);
        c.setText(DataPersistSec.getCount1(Main2Activity.this)+"");

    }

    // on click sets edit text visible so user can type name
    public void editText1(View v){

        editTask1 = (TextView) findViewById(R.id.editTask1);
        editTask1.setVisibility(View.VISIBLE);
        textsave1 = (TextView) findViewById(R.id.task1);
        textsave1.setVisibility(View.INVISIBLE);

    }


    //----------------------------------------------------------------------------------------------
    //Row 2

    //calls method from DataPersistSec class and updates textView
    public void addInc2(View v){

        DataPersistSec.addSaveCounter2(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter2);
        c.setText(DataPersistSec.getCount2(Main2Activity.this)+"");

    }

    //calls method from DataPersistSec class and updates textView
    public void subtractInc2(View v){

        DataPersistSec.subtractSaveCounter2(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter2);
        c.setText(DataPersistSec.getCount2(Main2Activity.this)+"");

    }

    //shares to local apps
    public void shareProgress2(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistSec.getTaskName2(Main2Activity.this) + " " + DataPersistSec.getCount2(Main2Activity.this) + " times");
        Main2Activity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistSec class and updates textView
    public void resetInt2(View v){

        DataPersistSec.resetSaveCounter2(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter2);
        c.setText(DataPersistSec.getCount2(Main2Activity.this)+"");

    }

    //calls method from DataPersistSec class and updates textView
    public void editText2(View v){

        editTask2 = (TextView) findViewById(R.id.editTask2);
        editTask2.setVisibility(View.VISIBLE);
        textsave2 = (TextView) findViewById(R.id.task2);
        textsave2.setVisibility(View.INVISIBLE);

    }

    //----------------------------------------------------------------------------------------------
    //Row 3

    //calls method from DataPersistSec class and updates textView
    public void addInc3(View v){

        DataPersistSec.addSaveCounter3(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter3);
        c.setText(DataPersistSec.getCount3(Main2Activity.this)+"");

    }

    //calls method from DataPersistSec class and updates textView
    public void subtractInc3(View v){

        DataPersistSec.subtractSaveCounter3(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter3);
        c.setText(DataPersistSec.getCount3(Main2Activity.this)+"");

    }

    //shares to local apps
    public void shareProgress3(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistSec.getTaskName3(Main2Activity.this) + " " + DataPersistSec.getCount3(Main2Activity.this) + " times");
        Main2Activity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistSec class and updates textView
    public void resetInt3(View v){

        DataPersistSec.resetSaveCounter3(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter3);
        c.setText(DataPersistSec.getCount3(Main2Activity.this)+"");

    }

    //calls method from DataPersistSec class and updates textView
    public void editText3(View v){

        editTask3 = (TextView) findViewById(R.id.editTask3);
        editTask3.setVisibility(View.VISIBLE);
        textsave3 = (TextView) findViewById(R.id.task3);
        textsave3.setVisibility(View.INVISIBLE);

    }


    //----------------------------------------------------------------------------------------------
    //Row 4

    //calls method from DataPersistSec class and updates textView
    public void addInc4(View v){

        DataPersistSec.addSaveCounter4(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter4);
        c.setText(DataPersistSec.getCount4(Main2Activity.this)+"");

    }

    //calls method from DataPersistSec class and updates textView
    public void subtractInc4(View v){

        DataPersistSec.subtractSaveCounter4(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter4);
        c.setText(DataPersistSec.getCount4(Main2Activity.this)+"");

    }

    //shares to local apps
    public void shareProgress4(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistSec.getTaskName4(Main2Activity.this) + " " + DataPersistSec.getCount4(Main2Activity.this) + " times");
        Main2Activity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistSec class and updates textView
    public void resetInt4(View v){

        DataPersistSec.resetSaveCounter4(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter4);
        c.setText(DataPersistSec.getCount4(Main2Activity.this)+"");

    }

    //calls method from DataPersistSec class and updates textView
    public void editText4(View v){

        editTask4 = (TextView) findViewById(R.id.editTask4);
        editTask4.setVisibility(View.VISIBLE);
        textsave4 = (TextView) findViewById(R.id.task4);
        textsave4.setVisibility(View.INVISIBLE);

    }


    //----------------------------------------------------------------------------------------------
    //Row 5

    //calls method from DataPersistSec class and updates textView
    public void addInc5(View v){

        DataPersistSec.addSaveCounter5(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter5);
        c.setText(DataPersistSec.getCount5(Main2Activity.this)+"");

    }

    //calls method from DataPersistSec class and updates textView
    public void subtractInc5(View v){

        DataPersistSec.subtractSaveCounter5(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter5);
        c.setText(DataPersistSec.getCount5(Main2Activity.this)+"");

    }

    //shares to local apps
    public void shareProgress5(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I just completed " + DataPersistSec.getTaskName5(Main2Activity.this) + " " + DataPersistSec.getCount5(Main2Activity.this) + " times");
        Main2Activity.this.startActivity(Intent.createChooser(intent, "Share"));

    }

    //calls method from DataPersistSec class and updates textView
    public void resetInt5(View v){

        DataPersistSec.resetSaveCounter5(Main2Activity.this);
        TextView c = (TextView) findViewById(R.id.counter5);
        c.setText(DataPersistSec.getCount5(Main2Activity.this)+"");

    }

    //calls method from DataPersistSec class and updates textView
    public void editText5(View v){

        editTask5 = (TextView) findViewById(R.id.editTask5);
        editTask5.setVisibility(View.VISIBLE);
        textsave5 = (TextView) findViewById(R.id.task5);
        textsave5.setVisibility(View.INVISIBLE);

    }


}
