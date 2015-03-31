package com.sss.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.sss.R;
import com.sss.Util.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import network.VolleySingleton;

public class AdapterIssuedBooks extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    List<Book> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    ImageLoader imageLoader;
    VolleySingleton volleySingleton;


    public AdapterIssuedBooks(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        volleySingleton = VolleySingleton.getInstance();
        imageLoader = volleySingleton.getImageLoader();

    }

    public void setBooksList(ArrayList<Book> listBooks){
        this.data=listBooks;
        notifyItemRangeChanged(0,data.size());
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
       // loadImages(current.getImageUrl(),itemHolder);
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
        //}
    }

    @Override
    public int getItemCount() {
        return data.size();
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
