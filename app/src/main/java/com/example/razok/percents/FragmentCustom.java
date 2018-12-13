package com.example.razok.percents;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class FragmentCustom extends FragmentCommon {
    EditText percent;
    Spinner exercise;
    Button add;
    String exSelected;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager rLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_custom, container, false);
        {
            instantiate();
            percent = (EditText) rootView.findViewById(R.id.percent);
            add = (Button) rootView.findViewById(R.id.add);
            //instantiate the spinner
            exercise = (Spinner) rootView.findViewById(R.id.exercise);
            //create the adapter for the spinner/drop-down menu from string resource
            //and set a menu visual
            ArrayAdapter<CharSequence> sAdapter = ArrayAdapter.createFromResource(getContext(), R.array.exercise, R.layout.support_simple_spinner_dropdown_item);
            sAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            //set the adapter of Spinner
            exercise.setAdapter(sAdapter);
            exercise.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    exSelected = parent.getItemAtPosition(position).toString();
                    dataList.add(new SimpleViewModel(exSelected));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            //instantiate a RecycleView to store CardViews
            recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
            //instantiate a LayoutManager to handle the RecycleView
            rLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(rLayoutManager);
            //instantiate an Adapter to feed data to the View
            final SimpleAdapter rAdapter = new SimpleAdapter(dataList);
            recyclerView.setAdapter(rAdapter);
            //get the current selected exercise and save it in the dataset on selection
            //calculate needed values on button click
            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //reset all the current rows
                    resetRows();
                    //parse all integers to string
                    weightValue = Integer.parseInt(weight.getText().toString());
                    percentValue = Integer.parseInt(percent.getText().toString());
                    //create the table's rows
                    createRow(rowNum, percentValue, weightValue, finalValue);
                    rowNum++;
                    rAdapter.notifyDataSetChanged();
                }
            });

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            return rootView;
        }

    }

    public static FragmentCustom newInstance() {
        FragmentCustom fCustom = new FragmentCustom();
        return fCustom;
    }

}
