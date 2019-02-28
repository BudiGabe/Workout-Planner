package com.example.razok.percents;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ResourceBundle;

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
    TextView createNewTextView(String string, int color ){
        TextView text = new TextView(getActivity());
        text.setText(string);
        text.setTextColor(getResources().getColor(color));
        text.setTextSize(15);
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
        row.addView(createNewTextView("Set " + (rowNum + 1) + ": ", R.color.colorAccent));
        row.addView(createNewTextView(percentString + "% of ", R.color.white));
        row.addView(createNewTextView(weightString + " is ", R.color.white));
        row.addView(createNewTextView(finalString, R.color.white));
        tableLayout.addView(row,rowNum);

    }

    void createLine(int rowNum){
        final TableRow row = new TableRow(getActivity());
        View line = new View(getActivity());
        line.setLayoutParams(new LinearLayout.LayoutParams(30, 1));
        line.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        row.addView(line);
        tableLayout.addView(row,rowNum);
    }
}
