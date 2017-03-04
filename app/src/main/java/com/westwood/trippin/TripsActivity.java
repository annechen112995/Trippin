package com.westwood.trippin;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

public class TripsActivity extends AppCompatActivity {

    SmartFragmentStatePagerAdapter adapterViewPager;
    ViewPager vpPager;
    PagerSlidingTabStrip tabsStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        vpPager = (ViewPager) findViewById(R.id.vpPager);

        adapterViewPager = new TripsPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        // Give the PagerSlidingTabStrip the ViewPager
        tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);

        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(vpPager);

        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(TripsActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });
    }

    //Returns the order of the fragments in the pager adapter
    public class TripsPagerAdapter extends SmartFragmentStatePagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
        //private String tabTitles[] = {"Map", "Gallery", "Packing", "Expense"};
        final int PAGE_COUNT = 4;
        private int tabIcons[] = {R.drawable.ic_tab_map, R.drawable.ic_tab_gallery,
                R.drawable.ic_tab_packing, R.drawable.ic_tab_expense};

        //Adapter gets the manager, insert or remove fragments from the activity
        public TripsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //The order and creation of fragments within the pager
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new MapFragment();
            } else if (position == 1) {
                return new GalleryFragment();
            } else if (position == 2) {
                return new PackingFragment();
            } else if (position == 3) {
                return new ExpenseFragment();
            } else {
                return null;
            }
        }

        //Number of fragments to swipe between
        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public int getPageIconResId(int position) {
            return tabIcons[position];
        }
    }

}
