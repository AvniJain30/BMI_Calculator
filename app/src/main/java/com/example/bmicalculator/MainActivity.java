package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculator;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.editweight);
        edtHeightFt = findViewById(R.id.editheightft);
        edtHeightIn = findViewById(R.id.editheightin);
        btnCalculator = findViewById(R.id.btnCalculator);
        txtResult = findViewById(R.id.text);
        llMain = findViewById(R.id.llMain);

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;
                double bmi = wt / (totalM * totalM);

                if(bmi > 25){
                    txtResult.setText("You're overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.overWt));
                }
                else if(bmi < 18){
                    txtResult.setText("You're underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.underWt));
                }
                else{
                    txtResult.setText("You're Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Healthy));
                }
            }
        });
    }
}