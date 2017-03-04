package com.westwood.trippin;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class TripsActivity extends AppCompatActivity {

    SmartFragmentStatePagerAdapter adapterViewPager;
    ViewPager vpPager;

    public TripsActivity(SmartFragmentStatePagerAdapter adapterViewPager) {
        this.adapterViewPager = adapterViewPager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vpPager = (ViewPager) findViewById(R.id.vpPager);

        //Set the viewpager adapter for the pager
        //adapterViewPager = new TripsPagerAdapter();
        //vpPager.setAdapter(adapterViewPager);

    }

}
