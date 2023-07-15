package com.seven.finappfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        CardView card_view = findViewById(R.id.card_view);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AverageSharePrice.class);
                startActivity(intent);
            }
        });

        CardView card_view_loan = findViewById(R.id.card_view_loan);
        card_view_loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoanCalculator.class);
                startActivity(intent);
            }
        });



        CardView card_view_fix_deposit = findViewById(R.id.card_view_fix_deposit);
        card_view_fix_deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FixDepositCal.class);
                startActivity(intent);
            }
        });

        CardView card_view_sip_calculator = findViewById(R.id.card_view_sip_calculator);
        card_view_sip_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SipCalculator.class);
                startActivity(intent);
            }
        });





    }


    ;
}


        /*Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText previousSharePriceEditText = findViewById(R.id.editText1);
                EditText previousQuantityEditText = findViewById(R.id.editTextquantity);
                EditText newSharePriceEditText = findViewById(R.id.editTextnewshareprice);
                EditText newQuantityEditText = findViewById(R.id.editTextnewquantity);



                double previousSharePrice = Double.parseDouble(previousSharePriceEditText.getText().toString());
                double previousQuantity = Double.parseDouble(previousQuantityEditText.getText().toString());
                double newSharePrice = Double.parseDouble(newSharePriceEditText.getText().toString());
                double newQuantity = Double.parseDouble(newQuantityEditText.getText().toString());

                calculateAveragePriceAndTotalQuantity(previousSharePrice, previousQuantity, newSharePrice, newQuantity);
            }


            public void calculateAveragePriceAndTotalQuantity(double previousSharePrice, double previousQuantity, double newSharePrice, double newQuantity) {
                double averagePrice = (previousSharePrice * previousQuantity + newSharePrice * newQuantity) / (previousQuantity + newQuantity);
                double totalQuantity = previousQuantity + newQuantity;
                String message = "Average Price: " + averagePrice + "\nTotal Quantity: " + totalQuantity;
                //Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                TextView tv_toastt =findViewById(R.id.tv_toast);
                tv_toastt.setText(message);
            }




        });*/



