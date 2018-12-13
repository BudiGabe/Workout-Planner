package com.example.razok.percents;

import android.service.autofill.Dataset;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentCommon extends Fragment {
    ViewGroup rootView;
    TextView instr;
    FloatingActionButton calculateButton;
    EditText weight;
    TableLayout tableLayout;
    String[] data;
    int weightValue;
    double percentValue;
    int rowNum;
    double finalValue[] = new double[7];
    static final int INIT_ROW_NUM = 0;
    final List<SimpleViewModel> dataList = new ArrayList<>();
    void instantiate() {
        instr = (TextView) rootView.findViewById((R.id.instr));
        weight = (EditText) rootView.findViewById(R.id.weight);
        calculateButton = (FloatingActionButton) rootView.findViewById(R.id.calculateButton);
        tableLayout = (TableLayout) rootView.findViewById(R.id.tableLayout);
    }
    void resetRows(){
        if(rowNum >= 5){
            rowNum = INIT_ROW_NUM;
            tableLayout.removeAllViews();
        }
    }
    TextView createNewTextView(String string ){
        TextView rowText = new TextView(getActivity());
        rowText.setText(string);
        return rowText;
    }
    void incrementPercent(){ percentValue += 10;}
    void decrementPercent(){ percentValue -= 10;}

    void createRow(int rowNum, double percentValue, int weightValue, double finalValue[]){
        final TableRow row = new TableRow(getActivity());
        //a variable to store the string attached to current row
        String rowString;
        //calculate the final weight and convert everything to string
        finalValue[rowNum] = (percentValue/100)*weightValue;
        String finalString = String.format("%.2f", finalValue[rowNum]);
        String weightString = Integer.toString(weightValue);
        String percentString = String.format("%.0f", percentValue);
        //set the rows to be in the center
        row.setGravity(Gravity.CENTER_HORIZONTAL);
        //add the final textview to the row, while saving the string, in order to be added
        //to the dataset for the RecycleView Adapter
        rowString = "Set " + (rowNum + 1) + ": " + percentString + "% of " + weightString + " is: " + finalString;
        row.addView(createNewTextView(rowString));
        dataList.add(new SimpleViewModel(rowString));
        tableLayout.addView(row,rowNum);
    }
}
