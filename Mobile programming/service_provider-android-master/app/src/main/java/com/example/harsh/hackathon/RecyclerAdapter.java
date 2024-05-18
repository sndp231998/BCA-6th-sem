package com.example.harsh.hackathon;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

/**
 * Created by HARSH on 20-05-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {
    LayoutInflater inflater;
    List<Aide> list;
    Context context;
    ItemClickCallback itemClickCallback;
    int layout;
    boolean isGrid=false;

    public RecyclerAdapter(List<Aide> episodeList, Context context, int layout, boolean isGrid) {
        this.list =episodeList;
        inflater=LayoutInflater.from(context);
        this.context=context;
        this.itemClickCallback= (ItemClickCallback) context;
        this.layout=layout;
        this.isGrid=isGrid;
    }

    public void setItemClickCallback(ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(this.layout, parent, false);
        return new RecyclerHolder(view,itemClickCallback);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
            Aide item = list.get(position);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEE, dd, MMM yyyy");
            holder.name.setText(item.getFname()+" "+item.getLname());
            holder.jobProfile.setText("Job Profile: "+item.getJob_profile());
            holder.rating.setText("NA");
        if(item.getImage()!=null){
            Picasso.with(context).load(item.getImage()).into(holder.profilePic);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
