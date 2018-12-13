package com.example.razok.percents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class FragmentDeload extends FragmentCommon {
    EditText percent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_deload, container, false);{
                    instantiate();
            percent = (EditText) rootView.findViewById(R.id.percent);
            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetRows();
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


