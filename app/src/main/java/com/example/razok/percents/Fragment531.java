package com.example.razok.percents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class Fragment531 extends FragmentCommon {
    MeinView weekSelect;
    private int currentWeek;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_531, container, false); {
        instantiate();
        weekSelect = (MeinView) rootView.findViewById(R.id.weekSelect);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!weight.getText().toString().equals("")){
                currentWeek = weekSelect.getValue();
                switch(currentWeek){                 //starting percent changes based on current training week
                    case 1:
                        percentValue = 65;
                        break;
                    case 2:
                        percentValue = 70;
                        break;
                    case 3:
                        percentValue = 75;
                        break;
                    case 4:
                        percentValue = 40;
                        break;
                }
                weightValue = Integer.parseInt(weight.getText().toString());
                tableLayout.removeAllViews();
                for(rowNum = INIT_ROW_NUM; rowNum <= 2; rowNum++){
                    createRow(rowNum, percentValue, weightValue, finalValue);
                    percentValue += 10;
                }
                }
                else {
                    Toast.makeText(getContext(), "Value is null", Toast.LENGTH_SHORT).show();
                }
            }
        });
            return rootView;

        }}
    public static Fragment531 newInstance() {
        Fragment531 f531 = new Fragment531();
        return f531;
    }

}

