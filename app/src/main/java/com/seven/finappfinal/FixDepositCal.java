package com.seven.finappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FixDepositCal extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_deposit);


        Button myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FixDepositCal.this, FixDepositCal.class);
                startActivity(intent);
            }
        });


        Button submitButton = (Button) findViewById(R.id.myButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText depositAmountEditText = (EditText) findViewById(R.id.editText1_enter_fd_amount);
                String depositAmountString = depositAmountEditText.getText().toString();

                EditText annualInterestRateEditText = (EditText) findViewById(R.id.editText1_enter_anuual_intrest_rate);
                String annualInterestRateString = annualInterestRateEditText.getText().toString();

                EditText termEditText = (EditText) findViewById(R.id.editText1_enter_anuual_term);
                String termInYearsString = termEditText.getText().toString();

                if (depositAmountString.isEmpty() || annualInterestRateString.isEmpty() || termInYearsString.isEmpty()) {
                    // Display error message
                    TextView resultTextView = (TextView) findViewById(R.id.tv_toast);
                    resultTextView.setText("Please enter all values");
                } else {
                    double depositAmount = Double.parseDouble(depositAmountString);
                    double annualInterestRate = Double.parseDouble(annualInterestRateString);
                    int termInYears = Integer.parseInt(termInYearsString);

                    double interestEarned = depositAmount * Math.pow(1 + annualInterestRate / 100, termInYears) - depositAmount;

                    double maturityAmount = depositAmount * Math.pow(1 + annualInterestRate / 100, termInYears);

                    TextView resultTextView = (TextView) findViewById(R.id.tv_toast);
                    resultTextView.setText("Interest earned: " + String.format("%.2f", interestEarned));

                    TextView resultTextView2 = (TextView) findViewById(R.id.tv_toast2);
                    resultTextView2.setText("Maturity Amount after  " + termInYears+ "Years : " + maturityAmount);
                }
            }
        });


    }

}
