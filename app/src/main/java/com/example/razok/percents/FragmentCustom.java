package com.example.razok.percents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentCustom extends FragmentCommon {
    EditText percent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_custom, container, false);
        instantiate();
        percent = (EditText) rootView.findViewById(R.id.percent);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetRows();
                if(!(weight.getText().toString().equals("") || percent.getText().toString().equals(""))) {
                weightValue = Integer.parseInt(weight.getText().toString());
                percentValue = Integer.parseInt(percent.getText().toString());
                createRow(rowNum, percentValue, weightValue, finalValue);
                rowNum++;
            } else {
                    Toast.makeText(getContext(), "Value is null", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }

    public static FragmentCustom newInstance() {
        FragmentCustom fCustom = new FragmentCustom();
        return fCustom;
    }

}
