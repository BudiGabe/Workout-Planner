package com.example.razok.percents;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;



public class MeinView extends ConstraintLayout {
    TextView cycleNum;
    TextView cycle;
    View minusButton;
    View plusButton;
    View rootView;
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 4;

    public MeinView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        rootView = inflate(context, R.layout.mein_view, this);
        cycle = (TextView) rootView.findViewById(R.id.cycle);
        cycleNum = (TextView) rootView.findViewById(R.id.cycleNum);
        minusButton = rootView.findViewById(R.id.minusButton);
        plusButton = rootView.findViewById(R.id.plusButton);

        minusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                decrementValue();
            }
        }); //decrease value on click

        plusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                incrementValue();
            }
        }); //increase value on click
    }
    public int getValue(){
        return Integer.valueOf(cycleNum.getText().toString());
    } //get current value

    public void decrementValue(){
        int currentVal = getValue();
        if(currentVal > MIN_VAL){
            cycleNum.setText(String.valueOf(currentVal - 1));
        }
    }

    public void incrementValue(){
        int currentVal = getValue();
        if(currentVal < MAX_VAL){
            cycleNum.setText(String.valueOf(currentVal + 1));
        }
    }

}
