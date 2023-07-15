package com.seven.finappfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SipCalculator extends AppCompatActivity {


    private EditText monthlyInvestmentEditText;
    private EditText investmentPeriodEditText;
    private EditText annualReturnEditText;
    private TextView resultTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sip_cal);

        monthlyInvestmentEditText = findViewById(R.id.editText1_enter_monthly);
        investmentPeriodEditText = findViewById(R.id.editText1_inv_period);
        annualReturnEditText = findViewById(R.id.editText1_anuual_return);
        resultTextView = findViewById(R.id.tv_toast4);

        Button submitButton = findViewById(R.id.myButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSIP();
            }
        });
    }

    private void calculateSIP() {
        String monthlyInvestmentString = monthlyInvestmentEditText.getText().toString();
        String investmentPeriodString = investmentPeriodEditText.getText().toString();
        String annualReturnString = annualReturnEditText.getText().toString();

        if (monthlyInvestmentString.isEmpty() || investmentPeriodString.isEmpty() || annualReturnString.isEmpty()) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return;
        }

        double monthlyInvestment = Double.parseDouble(monthlyInvestmentString);
        int investmentPeriod = Integer.parseInt(investmentPeriodString);
        double annualReturn = Double.parseDouble(annualReturnString);

        double futureValue = 0;
        for (int i = 0; i < investmentPeriod * 12; i++) {
            futureValue += monthlyInvestment * Math.pow(1 + annualReturn / 100 / 12, i + 1);
        }

        resultTextView.setText("Future value: " + futureValue);
    }
}
