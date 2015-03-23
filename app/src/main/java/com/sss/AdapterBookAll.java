package com.sss;

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
import com.sss.Util.Book;

import java.util.Collections;
import java.util.List;

import network.VolleySingleton;

public class AdapterBookAll extends RecyclerView.Adapter<AdapterBookAll.MyViewHolder> {
    List<Book> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;

    public AdapterBookAll(Context context, List<Book> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        volleySingleton = VolleySingleton.getInstance();
        imageLoader = volleySingleton.getImageLoader();
    }


    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.customize_ebook_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Book current = data.get(position);
        holder.title.setText(current.getBookName());
        holder.date.setText(current.getDate());
        holder.ratingBar.setRating(current.getRatings());
        loadImages(current.getImageUrl(),holder);
        Log.d("","adding to screen"+current.getBookName());
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
        this.data = listBooks;
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
}