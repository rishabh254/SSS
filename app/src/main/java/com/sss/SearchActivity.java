package com.sss;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class SearchActivity extends ActionBarActivity {

    private Toolbar toolbar;
    SearchView mSearchView = null;
    String mQuery ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
//        toolbar.setTitle(R.string.title_activity_search);
//        toolbar.setNavigationIcon(R.drawable.ic_up);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                navigateUpToFromChild(SearchActivity.this,
//                        IntentCompat.makeMainActivity(new ComponentName(SearchActivity.this, MainActivity.class)));
//            }
//        });

        FragmentManager fm = getFragmentManager();
        Fragment fragment = (Fragment)fm.findFragmentById(R.id.fragment_container);

        String query = getIntent().getStringExtra(SearchManager.QUERY);
        query = query == null? "":query;
        mQuery = query;
        if(fragment == null){
            fragment = new Fragment();
            Bundle args =null;
            fragment.setArguments(args);
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
        if(mSearchView !=null){
            mSearchView.setQuery(query,false);
        }
        overridePendingTransition(0,0);
    }

    /**
     * Converts an intent into a {@link Bundle} suitable for use as fragment arguments.
     */
    public static Bundle intentToFragmentArguments(Intent intent) {
        Bundle arguments = new Bundle();
        if (intent == null) {
            return arguments;
        }

        final Uri data = intent.getData();
        if (data != null) {
            arguments.putParcelable("_uri", data);
        }

        final Bundle extras = intent.getExtras();
        if (extras != null) {
            arguments.putAll(intent.getExtras());
        }

        return arguments;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem searchItem = menu.findItem(R.id.menu_search);
        if(searchItem!=null){
            SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
            final SearchView view = (SearchView)searchItem.getActionView();
            mSearchView = view;
            if(view == null){
                Log.e("Search Activity","Could not set up search view,view is null.");
            }
            else{
                view.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
                view.setIconified(false);
                view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        view.clearFocus();
                        if("zzznotif".equals(s)){
                            //something decided to be later
                        }
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String s) {
                        //update query
                        return true;
                    }
                });

                view.setOnCloseListener(new SearchView.OnCloseListener() {
                    @Override
                    public boolean onClose() {
                        finish();
                        return false;
                    }
                });
                 //check if query is not empty
            }

        }
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

        if(id == R.id.voice_search){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(0, 0);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
