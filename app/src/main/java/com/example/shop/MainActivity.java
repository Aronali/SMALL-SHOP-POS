package com.example.shop;

import static android.widget.Toast.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button, button2, button3, button4, button5, button6, button7;
    EditText editTextText, editTextText2, editTextText3, editTextText4, editTextText5, editTextText6, editTextText7, editTextText8, editTextText9;
    EditText editTextText10, editTextText11, editTextText12, editTextText13, editTextText14, editTextText15;

    private static final int BREAD_PRICE = 60;
    private static final int MILK_PRICE = 80;
    private static final int FLOUR_PRICE = 210;
    private static final int SUGAR_PRICE = 200;

    private static final int MAX_QUANTITY = 4;
    private static final int DISCOUNT_THRESHOLD = 10000;
    private static final double DISCOUNT_PERCENTAGE = 0.15;

    private int milkQuantity = 0;
    private int sugarQuantity = 0;
    private int flourQuantity = 0;
    private int breadQuantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);

        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);
        editTextText4 = findViewById(R.id.editTextText4);
        editTextText5 = findViewById(R.id.editTextText5);
        editTextText6 = findViewById(R.id.editTextText6);
        editTextText7 = findViewById(R.id.editTextText7);
        editTextText8 = findViewById(R.id.editTextText8);
        editTextText9 = findViewById(R.id.editTextText9);
        editTextText10 = findViewById(R.id.editTextText10);
        editTextText11 = findViewById(R.id.editTextText11);
        editTextText12 = findViewById(R.id.editTextText12);
        editTextText13 = findViewById(R.id.editTextText13);
        editTextText14 = findViewById(R.id.editTextText14);
        editTextText15 = findViewById(R.id.editTextText15);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity("Milk");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity("Sugar");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity("Flour");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity("Bread");
            }
        });

    }

    private void incrementQuantity(String itemName) {
        switch (itemName) {
            case "Milk":
                if (milkQuantity < MAX_QUANTITY) {
                    milkQuantity++;
                    updateUI();
                }
                break;
            case "Sugar":
                if (sugarQuantity < MAX_QUANTITY) {
                    sugarQuantity++;
                    updateUI();
                }
                break;
            case "Flour":
                if (flourQuantity < MAX_QUANTITY) {
                    flourQuantity++;
                    updateUI();
                }
                break;
            case "Bread":
                if (breadQuantity < MAX_QUANTITY) {
                    breadQuantity++;
                    updateUI();
                }
                break;
        }
    }

    // Method to update the UI with current quantities and total
    private void updateUI() {
        editTextText.setText(String.valueOf(editTextText));
        editTextText2.setText(String.valueOf(editTextText2));
        editTextText3.setText(String.valueOf(editTextText3));
        editTextText4.setText(String.valueOf(editTextText4));
        editTextText5.setText(String.valueOf(editTextText5));
        editTextText6.setText(String.valueOf(editTextText6));
        editTextText7.setText(String.valueOf(editTextText7));
        editTextText8.setText(String.valueOf(editTextText8));
        editTextText9.setText(String.valueOf(editTextText9));
        editTextText10.setText(String.valueOf(editTextText10));
        editTextText11.setText(String.valueOf(editTextText11));
        editTextText12.setText(String.valueOf(editTextText12));

        int total = (breadQuantity * BREAD_PRICE) + (milkQuantity * MILK_PRICE) + (flourQuantity * FLOUR_PRICE) + (sugarQuantity * SUGAR_PRICE);
        editTextText13.setText(String.format("Total: %d", total));
    }

    // Method to handle the checkout process and apply discounts
    private void checkout() {
        int total = (breadQuantity * BREAD_PRICE) + (milkQuantity * MILK_PRICE) + (flourQuantity * FLOUR_PRICE) + (sugarQuantity * SUGAR_PRICE);

        if (total > DISCOUNT_THRESHOLD) {
            // Apply discount if the total exceeds the threshold
            double discountedTotal = total - (total * DISCOUNT_PERCENTAGE);
            showCheckoutMessage("Discount Applied! Total amount: " + discountedTotal);
        } else {
            // Display a message indicating no discount
            showCheckoutMessage("No Discount. Total amount: " + total);
        }
    }

    // Method to display a Toast message for checkout
    private void showCheckoutMessage(String message) {
        Toast.makeText(this, message, LENGTH_SHORT).show();
    }
}




