package com.example.razok.percents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class FragmentBBB extends FragmentCommon {
    EditText percent;
    Spinner setType;
    String typeSelected;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_bbb, container, false);{
                    instantiate();
                    setType = (Spinner) rootView.findViewById(R.id.setType);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.type_array, R.layout.support_simple_spinner_dropdown_item); //create an adapter for spinner from string resource
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item); //set how the menu looks
            setType.setAdapter(adapter);
            setType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    typeSelected = parent.getItemAtPosition(position).toString();  //gets the type selected
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetRows();
                    weightValue = Integer.parseInt(weight.getText().toString());
                    switch(typeSelected){
                        case "Ascending":
                            createAscending();
                            break;
                        case "Up/Down":
                            createPyramid();
                            break;
                        case "Descending":
                            createDescending();
                            break;
                    }
                }
            });
            return rootView;
        }

    }
    public void createAscending(){
        percentValue = 30;
        for(rowNum = 0; rowNum <= 4; rowNum++) {
            createRow(rowNum, percentValue, weightValue, finalValue);
            incrementPercent();
        }
    }
    public void createPyramid(){
        percentValue = 40;
        for(rowNum = INIT_ROW_NUM; rowNum <= 2; rowNum++) {
            incrementPercent();
            createRow(rowNum, percentValue, weightValue, finalValue);
        }
        for(rowNum = 3; rowNum <= 4; rowNum++) {
            decrementPercent();
            createRow(rowNum, percentValue, weightValue, finalValue);
        }
    }
    public void createDescending(){
        percentValue = 70;
        for(rowNum = INIT_ROW_NUM; rowNum <= 4; rowNum++) {
            createRow(rowNum, percentValue, weightValue, finalValue);
            decrementPercent();
        }
    }
    public static FragmentBBB newInstance() {
        FragmentBBB fBBB = new FragmentBBB();
        return fBBB;
    }
}


