package com.sss.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.sss.R;
import com.sss.Util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import anim.AnimationUtils;
import network.VolleySingleton;

public class AdapterBookAll extends RecyclerView.Adapter<AdapterBookAll.MyViewHolder> {
    List<Book> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;
    int mPreviousPosition;

    public AdapterBookAll(Context context,List<Book> data){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        volleySingleton = VolleySingleton.getInstance();
        imageLoader = volleySingleton.getImageLoader();
        Log.d("Adapter called","Size of the list data "+data.size());
    }


    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.customize_ebook_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        Log.d("View Holder","ONN CREATE VIEW HOLDER");
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Book current = data.get(position);
        holder.title.setText(current.getBookName());
        //holder.date.setText(current.getDate());
        holder.ratingBar.setRating(current.getRatings());
        Log.d("","adding to screen"+current.getBookName());
        Log.d("View Holder","ON BIND VIEW HOLDER");
        if(position > mPreviousPosition){
            AnimationUtils.animateSunblind(holder,true);
        }else{
            AnimationUtils.animateSunblind(holder,false);
        }
        mPreviousPosition=position;
        loadImages(current.getImageUrl(),holder);
    }

    private void loadImages(String urlThumbnail, final MyViewHolder holder) {
       // if (!urlThumbnail.equals(Constants.NA)) {
            imageLoader.get(urlThumbnail, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.icon.setImageBitmap(response.getBitmap());
                }
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        //}
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setListBooks(List<Book> listBooks) {
        data.clear();
        this.data = listBooks;
        notifyItemRangeChanged(0,listBooks.size());
        Log.d("Test", "starting Parsing");
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;
        ImageView icon;
        RatingBar ratingBar;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.bookTitle);
            icon = (ImageView) itemView.findViewById(R.id.bookThumbnail);
            date= (TextView) itemView.findViewById(R.id.bookUploadDate);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        }
    }

    public static class AdapterIssuedBooks extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        List<Book> data = Collections.emptyList();
        private LayoutInflater inflater;
        private Context context;
        private ImageLoader imageLoader;

        public AdapterIssuedBooks(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.custom_row, parent, false);
            ItemHolder holder = new ItemHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ItemHolder itemHolder = (ItemHolder) holder;
            Book current = data.get(position);
            itemHolder.title.setText(current.getBookName());
            loadImages(current.getImageUrl(),itemHolder);
        }

        private void loadImages(String urlThumbnail, final ItemHolder holder) {
            // if (!urlThumbnail.equals(Constants.NA)) {
            imageLoader.get(urlThumbnail, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.icon.setImageBitmap(response.getBitmap());
                }
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public void setData(ArrayList<Book> list) {
            this.data = list;
            notifyItemRangeChanged(0, data.size());
        }

        class ItemHolder extends RecyclerView.ViewHolder {
            TextView title;
            ImageView icon;

            public ItemHolder(View itemView) {
                super(itemView);
                title = (TextView) itemView.findViewById(R.id.listText);
                icon = (ImageView) itemView.findViewById(R.id.listIcon);
            }
        }
    }
}