package com.example.razok.percents;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

public class FragmentDeload extends FragmentCommon {
    EditText percent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_deload, container, false);{
            instr = (TextView) rootView.findViewById((R.id.instr));
            weight = (EditText) rootView.findViewById(R.id.weight);
            calculateButton = (FloatingActionButton) rootView.findViewById(R.id.calculateButton);
            tableLayout = (TableLayout) rootView.findViewById(R.id.tableLayout);
            percent = (EditText) rootView.findViewById(R.id.percent);
            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(rowNum >= 7){
                        rowNum = INIT_ROW_NUM;
                        tableLayout.removeAllViews();
                    }
                    weightValue = Integer.parseInt(weight.getText().toString());
                    percentValue = Integer.parseInt(percent.getText().toString());
                    finalValue[rowNum] = weightValue - (percentValue/100)*weightValue;
                    createRows(rowNum, percentValue, weightValue, finalValue);
                    rowNum++;
                }
            });
            return rootView;
        }

    }
}


