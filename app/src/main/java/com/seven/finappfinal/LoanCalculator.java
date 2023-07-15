package com.seven.finappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoanCalculator extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);


        Button myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoanCalculator.this, LoanCalculator.class);
                startActivity(intent);
            }
        });

        Button submitButton = (Button) findViewById(R.id.myButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText loanAmountEditText = (EditText) findViewById(R.id.editText1_enter_loan);
                String loanAmountString = loanAmountEditText.getText().toString();

                EditText annualInterestRateEditText = (EditText) findViewById(R.id.editText1_annual_intrest_rate);
                String annualInterestRateString = annualInterestRateEditText.getText().toString();

                EditText loanTenureEditText = (EditText) findViewById(R.id.editText1_loan_term);
                String loanTenureString = loanTenureEditText.getText().toString();

                if (loanAmountString.isEmpty() || annualInterestRateString.isEmpty() || loanTenureString.isEmpty()) {
                    // Display error message
                    TextView resultTextView = (TextView) findViewById(R.id.tv_toast);
                    resultTextView.setText("Please enter all values");
                } else {
                    double loanAmount = Double.parseDouble(loanAmountString);
                    double annualInterestRate = Double.parseDouble(annualInterestRateString);
                    int loanTenure = Integer.parseInt(loanTenureString);

                    double monthlyInterestRate = annualInterestRate / 1200;
                    int numberOfMonths = loanTenure * 12;

                    double emi = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfMonths));

                    TextView resultTextView = (TextView) findViewById(R.id.tv_toast);
                    resultTextView.setText("Monthly EMI: " + String.format("%.2f", emi) + " Rs");
                }
            }
        });






    }



}
