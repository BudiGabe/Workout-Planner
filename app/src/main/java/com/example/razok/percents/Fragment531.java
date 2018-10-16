package com.example.razok.percents;

import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;


public class Fragment531 extends FragmentCommon {
    private static final int STARTING_PERCENT= 65;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_531, container, false); {
                instr = (TextView) rootView.findViewById((R.id.instr));
                weight = (EditText) rootView.findViewById(R.id.weight);
                calculateButton = (FloatingActionButton) rootView.findViewById(R.id.calculateButton);
                tableLayout = (TableLayout) rootView.findViewById(R.id.tableLayout);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentValue = STARTING_PERCENT;
                tableLayout.removeAllViews();
                weightValue = Integer.parseInt(weight.getText().toString());
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

