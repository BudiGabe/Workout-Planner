package com.example.razok.percents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragment531 extends FragmentCommon {
    private static final int STARTING_PERCENT= 65;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_531, container, false); {
        instantiate();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentValue = STARTING_PERCENT;
                weightValue = Integer.parseInt(weight.getText().toString());
                tableLayout.removeAllViews();
                for(rowNum = INIT_ROW_NUM; rowNum <= 6; rowNum++){
                    finalValue[rowNum] = (percentValue/100)*weightValue;
                    createRows(rowNum, percentValue, weightValue, finalValue);
                    percentValue += 5;
                }
            }
        });
        return rootView;
    }}

}

