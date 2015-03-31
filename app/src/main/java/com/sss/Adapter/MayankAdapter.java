package com.sss.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sss.Util.Information;
import com.sss.R;

import java.util.Collections;
import java.util.List;

public class MayankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    List<Information> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public MayankAdapter(Context context, List<Information> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
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
        Information current = data.get(position);
        itemHolder.title.setText(current.title);
        itemHolder.icon.setImageResource(current.iconId);
        Log.d("Category", current.title + "added");
    }


    @Override
    public int getItemCount() {
        Log.d("Category Size",""+data.size());
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
