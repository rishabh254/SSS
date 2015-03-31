package com.sss.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.sss.FragmentEbook.FragmentCategory;
import com.sss.FragmentEbook.FragmentEbookAll;
import com.sss.FragmentEbook.FragmentEbookRecent;
import com.sss.FragmentEbook.FragmentEbookStatistics;
import com.sss.NavigationDrawerFragment;
import com.sss.R;
import com.sss.SortListener;

import Tabs.SlidingTabLayout;


public class Ebook extends ActionBarActivity implements View.OnClickListener {

    private static final String TAG_SORT_NAME = "sortName";
    private static final String TAG_SORT_DATE = "sortDate";
    private static final String TAG_SORT_RATINGS = "sortRatings";
    private Toolbar toolbar;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    private CharSequence mTitle;
    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mTitle = getTitle();
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);


        mPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
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


        buildFAB();
    }

    private void buildFAB() {
        //define the icon for the main floating action button
        ImageView iconActionButton = new ImageView(this);
        iconActionButton.setImageResource(R.drawable.ic_action_new);

        //set the appropriate background for the main floating action button along with its icon
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(iconActionButton)
                .setBackgroundDrawable(R.drawable.selector_button_red)
                .build();

        //define the icons for the sub action buttons
        ImageView iconSortName = new ImageView(this);
        iconSortName.setImageResource(R.drawable.ic_action_alphabets);
        ImageView iconSortDate = new ImageView(this);
        iconSortDate.setImageResource(R.drawable.ic_action_calendar);
        ImageView iconSortRatings = new ImageView(this);
        iconSortRatings.setImageResource(R.drawable.ic_action_important);

        //set the background for all the sub buttons
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        itemBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_sub_button_gray));

        //build the sub buttons
        SubActionButton buttonSortName = itemBuilder.setContentView(iconSortName).build();
        SubActionButton buttonSortDate = itemBuilder.setContentView(iconSortDate).build();
        SubActionButton buttonSortRatings = itemBuilder.setContentView(iconSortRatings).build();

        buttonSortName.setTag(TAG_SORT_NAME);
        buttonSortDate.setTag(TAG_SORT_DATE);
        buttonSortRatings.setTag(TAG_SORT_RATINGS);

        //add the sub buttons to the main floating action button
        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttonSortName)
                .addSubActionView(buttonSortDate)
                .addSubActionView(buttonSortRatings)
                .attachTo(actionButton)
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ebook, menu);
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

        if (id == R.id.upload_ebook) {
            Intent subActivity = new Intent(Ebook.this, EBookDetails.class);
            //translating in and out
            Bundle translatedBundle = ActivityOptions.makeCustomAnimation(Ebook.this, R.anim.slide_in_left, R.anim.slide_out_left).toBundle();
            startActivity(subActivity, translatedBundle);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = (Fragment) mAdapter.instantiateItem(mPager, mPager.getCurrentItem());
        if (fragment instanceof SortListener) {
            if (v.getTag().equals(TAG_SORT_NAME)) {
                //call the sort by name method on any Fragment that implements sortlistener
                ((SortListener) fragment).onSortByName();
            }
            if (v.getTag().equals(TAG_SORT_DATE)) {
                //call the sort by date method on any Fragment that implements sortlistener
                ((SortListener) fragment).onSortByDate();
            }
            if (v.getTag().equals(TAG_SORT_RATINGS)) {
                //call the sort by ratings method on any Fragment that implements sortlistener
                ((SortListener) fragment).onSortByRating();
            }
        }
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        String[] tabs;
        FragmentManager fragmentManager;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            fragmentManager = fm;
            tabs = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = FragmentEbookStatistics.newInstance("", "");
                    break;
                case 1:
                    fragment = FragmentCategory.newInstance("", "");
                    break;
                case 2:
                    fragment = FragmentEbookAll.newInstance("", "");
                    break;
                case 3:
                    fragment = FragmentEbookRecent.newInstance("", "");
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
