package com.example.andre.hungrysiaapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
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
    public ViewHolder onCreateViewHolder(ViewGroup vgroup, int position) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_menu_item,vgroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder vholder, int position) {
        final MenuItem item = mData.get(position);
        vholder.item_thumbnail.setImageResource(item.getThumbnail());
        vholder.item_name.setText(item.getName());
        vholder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPopup = new Intent(mContext,PopupActivity.class);
                toPopup.putExtra("NAME",item.getName());
                toPopup.putExtra("THUMBNAIL",item.getThumbnail());
                toPopup.putExtra("PRICE",item.getPrice());
                mContext.startActivity(toPopup);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_thumbnail;
        TextView item_name;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            item_thumbnail = (ImageView) itemView.findViewById(R.id.menu_item_thumbnail);
            item_name = (TextView) itemView.findViewById(R.id.menu_item_name);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
