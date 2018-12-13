package com.example.razok.percents;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter {
    List<SimpleViewModel> dataList;
    public SimpleAdapter (List<SimpleViewModel> dataList){
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.set_row,viewGroup,false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int pos) {
        ((SimpleViewHolder) viewHolder).bindData(dataList.get(pos));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
