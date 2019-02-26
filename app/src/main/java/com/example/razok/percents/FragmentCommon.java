package com.example.razok.percents;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class FragmentCommon extends Fragment {
    ViewGroup rootView;
    TextView instr;
    FloatingActionButton calculateButton;
    EditText weight;
    TableLayout tableLayout;
    int weightValue;
    double percentValue;
    int rowNum;
    double finalValue[] = new double[7];
    static final int INIT_ROW_NUM = 0;
    void instantiate(){
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
        TextView text = new TextView(getActivity());
        text.setText(string);
        return text;
    }
    void incrementPercent(){ percentValue += 10;}
    void decrementPercent(){ percentValue -= 10;}

    void createRow(int rowNum, double percentValue, int weightValue, double finalValue[]){
        final TableRow row = new TableRow(getActivity());
        finalValue[rowNum] = (percentValue/100)*weightValue;
        String finalString = String.format("%.2f", finalValue[rowNum]);
        String weightString = Integer.toString(weightValue);
        String percentString = String.format("%.0f", percentValue);
        row.setGravity(Gravity.CENTER_HORIZONTAL);
        row.addView(createNewTextView("Set " + (rowNum + 1) + ": "));
        row.addView(createNewTextView(percentString + "% of "));
        row.addView(createNewTextView(weightString + " is: "));
        row.addView(createNewTextView(finalString));
        tableLayout.addView(row,rowNum);
    }
}
