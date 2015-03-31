package com.sss.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.sss.NavigationDrawerFragment;
import com.sss.R;
import com.sss.Util.PrefUtils;


public class MainActivity extends ActionBarActivity {
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //unmark for final release
        PrefUtils.markLogInDone(MainActivity.this);
        PrefUtils.markWelcomeDone(MainActivity.this);
        if (!PrefUtils.isLoginDone(MainActivity.this)) {
            startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            finish();
        } else {
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
            mTitle = getTitle();
            drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
            drawerFragment.setUp(R.id.fragment_navigation_drawer, drawerLayout, toolbar);
            if(!PrefUtils.isWelcomeDone(MainActivity.this)){
                PrefUtils.markWelcomeDone(MainActivity.this);
                drawerLayout.openDrawer(Gravity.START);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id==R.id.menu_search){
            startActivity(new Intent(this,SearchActivity.class));
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_signOut){
            PrefUtils.signOut(MainActivity.this);
            startActivity(new Intent(MainActivity.this,WelcomeActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public void startNewActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


    public void startSellActivity(View view) {
        final ImageView thumbnail = (ImageView) findViewById(R.id.sell);
        BitmapDrawable drawable = (BitmapDrawable) thumbnail.getDrawable();
        Bitmap bm = drawable.getBitmap();
        Intent intent = new Intent(this, Sell.class);
        Bundle scaleBundle = ActivityOptions.makeThumbnailScaleUpAnimation(thumbnail, bm, 0, 0).toBundle();
        startActivity(intent, scaleBundle);
    }

    public void startLibraryActivity(View view) {
        final ImageView thumbnail = (ImageView) findViewById(R.id.library);
        BitmapDrawable drawable = (BitmapDrawable) thumbnail.getDrawable();
        Bitmap bm = drawable.getBitmap();
        Intent intent = new Intent(this, Library.class);
        Bundle scaleBundle = ActivityOptions.makeThumbnailScaleUpAnimation(thumbnail, bm, 0, 0).toBundle();
        startActivity(intent, scaleBundle);
    }

    public void startEbookActivity(View view) {
        final ImageView thumbnail = (ImageView) findViewById(R.id.ebook);
        BitmapDrawable drawable = (BitmapDrawable) thumbnail.getDrawable();
        Bitmap bm = drawable.getBitmap();
        Intent intent = new Intent(this, Ebook.class);
        Bundle scaleBundle = ActivityOptions.makeThumbnailScaleUpAnimation(thumbnail, bm, 0, 0).toBundle();
        startActivity(intent, scaleBundle);
    }
}
