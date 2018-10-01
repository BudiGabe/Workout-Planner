package com.example.razok.percents;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView instr;
    FloatingActionButton calculateButton;
    EditText weight;
    int value;
    double finalValue[] = new double[7];
    TableLayout TableLayout;
    private static final int STARTING_PERCENT= 65;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instr = (TextView) findViewById(R.id.instr);
        calculateButton = (FloatingActionButton) findViewById(R.id.calculateButton);
        weight = (EditText) findViewById(R.id.weight);
        TableLayout = (TableLayout) findViewById(R.id.TableLayout);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double percent = STARTING_PERCENT;
                TableLayout.removeAllViews();
                value = Integer.parseInt(weight.getText().toString());
                for(int rowNum = 0; rowNum <= 6; rowNum++){
                    finalValue[rowNum] = (percent/100)*value;
                    createRows(rowNum, percent);
                    percent += 5;
                }
            }
        });
    }
    TextView createNewTextView(String string){
        TextView text = new TextView(MainActivity.this);
        text.setText(string);
        return text;
    }
    void createRows (int rowNum, double percent){
        final TableRow row = new TableRow(MainActivity.this);
        String percentString = String.format("%.0f", percent);
        String numsString = String.format("%.2f", finalValue[rowNum]);
        row.setGravity(Gravity.CENTER_HORIZONTAL);
        row.addView(createNewTextView(percentString + "% is: "));
        row.addView(createNewTextView(numsString));
        TableLayout.addView(row,rowNum);
    }
}
