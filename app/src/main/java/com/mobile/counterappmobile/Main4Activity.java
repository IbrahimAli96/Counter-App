package com.mobile.counterappmobile;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Main4Activity extends AppCompatActivity {

    NumberPicker noPicker = null;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //initializes ads
        MobileAds.initialize(this, MainActivity.adUnitInit);

        //gets ads ready to load
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(MainActivity.adUnitID);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        noPicker = (NumberPicker)findViewById(R.id.pickNumSingle);
        //sets minimum value to 1
        noPicker.setMinValue(1);
        //sets maximum value to 100000
        noPicker.setMaxValue(100000);

        noPicker.setValue(DataPersistSingle.getIncInt(Main4Activity.this));

        noPicker.setWrapSelectorWheel(false);

        noPicker.setOnValueChangedListener( new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int
                    oldVal, int newVal) {

                DataPersistSingle.SaveIncSing = noPicker.getValue();
                DataPersistSingle.saveIncInt(Main4Activity.this);

            }
        });

        //sets counter value to saved value
        TextView c = (TextView) findViewById(R.id.counter11);
        c.setText(DataPersistSingle.getCountSing1(Main4Activity.this)+"");

        DataPersistSingle.SaveIncSing = DataPersistSingle.getIncInt(Main4Activity.this);

        //--------------------------------------------------------------------------
        // change activity

        Button btnMan = (Button)findViewById(R.id.button8);

        btnMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //changes to new activity
                startActivity(new Intent(Main4Activity.this, MainActivity.class));
                //finishes activity
                finish();
                // depending on the value of ActivityCount
                // the increment and time will be set to that specific activity
                MainActivity.ActivityCount = 0;

                if(MainActivity.getAdShowCount(Main4Activity.this) < MainActivity.adShowNum) {
                    MainActivity.AdShowCount++;
                    MainActivity.saveAdShowCount(Main4Activity.this);
                }


                if (mInterstitialAd.isLoaded() && MainActivity.getAdShowCount(Main4Activity.this) == MainActivity.adShowNum) {
                    mInterstitialAd.show();
                    MainActivity.AdShowCount = 0;
                    MainActivity.saveAdShowCount(Main4Activity.this);
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {

                }

            }
        });

        Button btnSec = (Button)findViewById(R.id.button10);

        btnSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Main4Activity.this, Main2Activity.class));
                finish();
                MainActivity.ActivityCount = 1;

                if(MainActivity.getAdShowCount(Main4Activity.this) < MainActivity.adShowNum) {
                    MainActivity.AdShowCount++;
                    MainActivity.saveAdShowCount(Main4Activity.this);
                }


                if (mInterstitialAd.isLoaded() && MainActivity.getAdShowCount(Main4Activity.this) == MainActivity.adShowNum) {
                    mInterstitialAd.show();
                    MainActivity.AdShowCount = 0;
                    MainActivity.saveAdShowCount(Main4Activity.this);
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {

                }

            }
        });

        Button btnDay = (Button)findViewById(R.id.button11);

        btnDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main4Activity.this, Main3Activity.class));
                finish();
                MainActivity.ActivityCount = 2;

                if(MainActivity.getAdShowCount(Main4Activity.this) < MainActivity.adShowNum) {
                    MainActivity.AdShowCount++;
                    MainActivity.saveAdShowCount(Main4Activity.this);
                }


                if (mInterstitialAd.isLoaded() && MainActivity.getAdShowCount(Main4Activity.this) == MainActivity.adShowNum) {
                    mInterstitialAd.show();
                    MainActivity.AdShowCount = 0;
                    MainActivity.saveAdShowCount(Main4Activity.this);
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {

                }

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
        Uri uri = Uri.parse("market://details?id=" + Main4Activity.this.getPackageName());
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
                    Uri.parse("http://play.google.com/store/apps/details?id=" + Main4Activity.this.getPackageName())));
        }
    }

    //----------------------------------------------------------------------------------------------
    //Row 1

    //on button click

    //calls method from DataPersistSingle class and updates textView
    public void addInc1(View v){

        DataPersistSingle.addSaveCounter1(Main4Activity.this);
        TextView c = (TextView) findViewById(R.id.counter11);
        c.setText(DataPersistSingle.getCountSing1(Main4Activity.this)+"");

        //Preferences.saveCounter(MainActivity.this);
    }

    //calls method from DataPersistSingle class and updates textView
    public void subtractInc1(View v){

        DataPersistSingle.subtractSaveCounter1(Main4Activity.this);
        TextView c = (TextView) findViewById(R.id.counter11);
        c.setText(DataPersistSingle.getCountSing1(Main4Activity.this)+"");

    }


    //calls method from DataPersistMan class and updates textView
    public void resetInt1(View v){

        DataPersistSingle.resetSaveCounter1(Main4Activity.this);
        TextView c = (TextView) findViewById(R.id.counter11);
        c.setText(DataPersistSingle.getCountSing1(Main4Activity.this)+"");

    }

}
