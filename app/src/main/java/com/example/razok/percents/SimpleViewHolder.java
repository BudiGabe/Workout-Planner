package com.example.razok.percents;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;



public class SimpleViewHolder extends RecyclerView.ViewHolder {
    //this is the view
    private TextView setView;

    public SimpleViewHolder(@NonNull View itemView) {
        super(itemView);
        setView = (TextView) itemView.findViewById(R.id.set);

    }
    public void bindData(SimpleViewModel viewModel){
        setView.setText(viewModel.getExData());
    }
}
