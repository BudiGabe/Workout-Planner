package com.example.razok.percents;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class FragmentCommon extends Fragment {
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

    }

    TextView createNewTextView(String string ){
        TextView text = new TextView(getActivity());
        text.setText(string);
        return text;
    }
    void createRows (int rowNum, double percentValue, int weightValue, double finalValue[]){
        final TableRow row = new TableRow(getActivity());
        String finalString = String.format("%.2f", finalValue[rowNum]);
        String weightString = Integer.toString(weightValue);
        String percentString = String.format("%.0f", percentValue);
        row.setGravity(Gravity.CENTER_HORIZONTAL);
        row.addView(createNewTextView(percentString + "% of "));
        row.addView(createNewTextView(weightString + " is: "));
        row.addView(createNewTextView(finalString));
        tableLayout.addView(row,rowNum);
    }
}
