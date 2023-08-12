package com.seven.finappfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AverageSharePrice extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_share_price);






        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText previousSharePriceEditText = findViewById(R.id.editText1);
                EditText previousQuantityEditText = findViewById(R.id.editTextquantity);
                EditText newSharePriceEditText = findViewById(R.id.editTextnewshareprice);
                EditText newQuantityEditText = findViewById(R.id.editTextnewquantity);

                double previousSharePrice = 0;
                double previousQuantity = 0;
                double newSharePrice = 0;
                double newQuantity = 0;
                if (previousSharePriceEditText.getText().toString().isEmpty() ||
                        previousQuantityEditText.getText().toString().isEmpty() ||
                        newSharePriceEditText.getText().toString().isEmpty() ||
                        newQuantityEditText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter all values", Toast.LENGTH_SHORT).show();
                } else {
                    previousSharePrice = Double.parseDouble(previousSharePriceEditText.getText().toString());
                    previousQuantity = Double.parseDouble(previousQuantityEditText.getText().toString());
                    newSharePrice = Double.parseDouble(newSharePriceEditText.getText().toString());
                    newQuantity = Double.parseDouble(newQuantityEditText.getText().toString());
                }

                calculateAveragePriceAndTotalQuantity(previousSharePrice, previousQuantity, newSharePrice, newQuantity);

                final CardView newCardView = findViewById(R.id.new_card_view);
                newCardView.setVisibility(View.VISIBLE);
            }
            public void calculateAveragePriceAndTotalQuantity(double previousSharePrice, double previousQuantity,double newSharePrice, double newQuantity) {
                double averagePrice = (previousSharePrice * previousQuantity + newSharePrice * newQuantity) / (previousQuantity + newQuantity);
                double totalQuantity = previousQuantity + newQuantity;
                String formattedAveragePrice = String.format("%.2f", averagePrice);
                String message = "Average Price: " + formattedAveragePrice + "\nTotal Quantity: " + totalQuantity;
                Toast.makeText(AverageSharePrice.this, message, Toast.LENGTH_SHORT).show();
                TextView tv_toastt =findViewById(R.id.tv_toast);
                tv_toastt.setText(message);
            }

        });

    }
};

