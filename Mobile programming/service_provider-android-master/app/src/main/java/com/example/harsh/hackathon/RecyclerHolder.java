package com.example.harsh.hackathon;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by KOUSHIK on 07-03-2017.
 */


    public class RecyclerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView name,jobProfile,rating;
    ImageView profilePic;
    View container;
    ItemClickCallback itemClickCallback;



    public RecyclerHolder(View itemView, ItemClickCallback itemClickCallback) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.tv_name);
        jobProfile = (TextView)itemView.findViewById(R.id.tv_jobProfile);
        rating = (TextView)itemView.findViewById(R.id.tv_rating);
        profilePic = (ImageView)itemView.findViewById(R.id.iv_profilepic);
        container = itemView.findViewById(R.id.container);
        container.setOnClickListener(this);
        this.itemClickCallback=itemClickCallback;
    }

    @Override
    public void onClick(View view) {
            itemClickCallback.OnItemClick(getAdapterPosition());
    }
}
