package com.sss.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.sss.FragmentSell.FragmentCategory;
import com.sss.FragmentSell.FragmentSellAll;
import com.sss.FragmentSell.FragmentSellRecent;
import com.sss.FragmentSell.FragmentSellStatistics;
import com.sss.NavigationDrawerFragment;
import com.sss.R;

import Tabs.SlidingTabLayout;


public class Sell extends ActionBarActivity {

    Toolbar toolbar;
    private CharSequence mTitle;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;

    private static final String TAG_SORT_NAME = "sortName";
    private static final String TAG_SORT_DATE = "sortDate";
    private static final String TAG_SORT_RATINGS = "sortRatings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mTitle = getTitle();
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);


        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);
        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorAccent);
            }
        });
        mTabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mTabs.setDistributeEvenly(true);
        mTabs.setViewPager(mPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sell, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.add_post) {
            Intent intent = new Intent(this, SellerDetails.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        String[] tabs;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment= null;
            switch (position) {
                case 0:
                    fragment = FragmentSellStatistics.newInstance("", "");
                    break;
                case 1:
                    fragment = FragmentCategory.newInstance("", "");
                    break;
                case 2:
                    fragment = FragmentSellAll.newInstance("", "");
                    break;
                case 3:
                    fragment = FragmentSellRecent.newInstance("", "");
                    break;
            }
           return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            //can be stored in constant
            return 4;
        }
    }
}
