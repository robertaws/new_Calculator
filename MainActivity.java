package com.exp.calculator;

import android.app.Activity;

import android.os.Bundle;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.Button;

import android.widget.EditText;

import android.widget.ImageView;

import android.widget.Spinner;

import android.widget.TextView;

import android.widget.AdapterView.OnItemSelectedListener;

public class Calc extends Activity implements OnItemSelectedListener{


    EditText num1, num2;

    Button button01;

    TextView tv1;

    ImageView iv1;

    Spinner spinOps;

    String[] ops={"Choose operation","+","-","*","/"};

    String opselected;

    double a, b, c;

    private OnClickListener myClickListener = new OnClickListener()

    {

        public void onClick(View v) {

            a=Double.parseDouble(num1.getText().toString());

            b=Double.parseDouble(num2.getText().toString());

            if (opselected=="+"){c=a+b; tv1.setText(Double.toString(c));}

            else if (opselected=="-"){c=a-b; tv1.setText(Double.toString(c));}

            else if (opselected=="*"){c=a*b; tv1.setText(Double.toString(c));}

            else if (opselected=="/"){c=a/b; tv1.setText(Double.toString(c));}

            else {tv1.setText("Please select the operation");}

            //tv1 = (TextView)findViewById(R.id.TextView01);

        }

    };

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        tv1 = (TextView)findViewById(R.id.TextView01);

        //iv1= (ImageView)findViewById(R.id.);//try imageview

        button01 = (Button)findViewById(R.id.Button01);

        button01.setText("Display result");

        button01.setOnClickListener(myClickListener);

        num1 = (EditText)findViewById(R.id.EditText01);

        num1.setText("");

        num2 = (EditText)findViewById(R.id.EditText02);

        num2.setText("");

        //list of operations

        spinOps = (Spinner)findViewById(R.id.Spinner01);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(

                this, android.R.layout.simple_spinner_item, ops);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinOps.setAdapter(adapter);

        spinOps.setOnItemSelectedListener(this);
    }

    public void onItemSelected (AdapterView<?> p,View v,int position,long id) {
        opselected=ops[position];
        tv1.setText("You have selected " + opselected);
    }

    public void onNothingSelected(AdapterView<?> p) {
        tv1.setText("Please select ops");
    }

}
