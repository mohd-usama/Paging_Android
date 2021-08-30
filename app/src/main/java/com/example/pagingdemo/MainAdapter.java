package com.example.pagingdemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainData.ViewHolder> {

    private ArrayList<MainData> dataArrayList;
    private Activity activity;

    public MainAdapter(Activity activity , ArrayList<MainData> dataArrayList)
    {
        this.activity = activity;
        this.dataArrayList = dataArrayList;


    }
    @NonNull
    @Override
    public MainData.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_main,parent,false);

        return new MainData.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainData.ViewHolder holder, int position) {
            MainData data= dataArrayList.get(position);

        Glide.with(activity).load(data.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);

        holder.textView.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

}
