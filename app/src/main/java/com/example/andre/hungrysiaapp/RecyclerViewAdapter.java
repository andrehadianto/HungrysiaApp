package com.example.andre.hungrysiaapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private List<com.example.andre.hungrysiaapp.MenuItem> mData;

    public RecyclerViewAdapter(Context mContext, List<com.example.andre.hungrysiaapp.MenuItem> mData){
        this.mContext = mContext;
        this.mData = new ArrayList<>(mData);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_menu_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.menu_item_thumbnail.setImageResource(mData.get(position).getThumbnail());
        viewHolder.menu_item_name.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView menu_item_thumbnail;
        TextView menu_item_name;

        public ViewHolder(View itemView) {
            super(itemView);
            menu_item_thumbnail = (ImageView) itemView.findViewById(R.id.menu_item_thumbnail);
            menu_item_name = (TextView) itemView.findViewById(R.id.menu_item_name);
        }
    }
}
