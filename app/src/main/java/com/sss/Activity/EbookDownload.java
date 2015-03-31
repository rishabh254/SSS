package com.sss.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.sss.NavigationDrawerFragment;
import com.sss.R;
import com.sss.Util.Book;

import network.VolleySingleton;


public class EbookDownload extends ActionBarActivity {

    TextView bookName;
    TextView authorName;
    TextView description;
    ImageView downloadImg;
    RatingBar rating;
    ImageLoader imageLoader;
    VolleySingleton volleySingleton;
    Toolbar toolbar;
    CharSequence mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook_download);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mTitle = getTitle();
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        volleySingleton = VolleySingleton.getInstance();
        imageLoader = volleySingleton.getImageLoader();
        Intent intent = getIntent();
        Book book = (Book) intent.getSerializableExtra("book");
        bookName = (TextView) findViewById(R.id.book_name);
        authorName = (TextView) findViewById(R.id.author_name);
        description = (TextView) findViewById(R.id.description);
        downloadImg = (ImageView) findViewById(R.id.downloadImg);
        rating = (RatingBar) findViewById(R.id.rating);
        bookName.setText(book.getBookName());
        authorName.setText(book.getAuthors());
        description.setText(book.getDescription());
//        downloadImg.setImageResource(R.drawable.ic_launcher);
        loadImages(book.getImageUrl());
        rating.setRating(book.getRatings() / 20.0F);
    }


    private void loadImages(String urlThumbnail) {
        // if (!urlThumbnail.equals(Constants.NA)) {
        imageLoader.get(urlThumbnail, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                downloadImg.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ebook_download, menu);
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
        return super.onOptionsItemSelected(item);
    }
}
