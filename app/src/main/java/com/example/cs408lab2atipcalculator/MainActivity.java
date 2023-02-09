package com.example.cs408lab2atipcalculator;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.text.DecimalFormat;

import com.example.cs408lab2atipcalculator.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    EditText valueNumofPeople;
    EditText valueTotalBill;
    EditText valueTipPercentage;
    private float totalPerPerson;

    DecimalFormat df = new DecimalFormat(".00");


    private ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }

    public void onClick(View view) {
        Log.i(TAG, "Button clicked!");
        String tag = view.getTag().toString();

        if (tag.equals("calculate")){
            valueNumofPeople = findViewById(R.id.valueNumofPeople);
            valueTotalBill = findViewById(R.id.valueTotalBill);
            valueTipPercentage = findViewById(R.id.valueTipPercentage);


            String NumofPeople = valueNumofPeople.getText().toString();
            String TotalBill = valueTotalBill.getText().toString();
            String TipPercent = valueTipPercentage.getText().toString();

            int numofPeople = Integer.parseInt(NumofPeople);
            float totalBill = Float.parseFloat(TotalBill);
            float tipPercent = Integer.parseInt(TipPercent);
            tipPercent = tipPercent/100;


            totalPerPerson = ((totalBill * (tipPercent)) + totalBill) / numofPeople;


            binding.end.setText(String.valueOf("Total Per Person: $ " + df.format(totalPerPerson)));



        }


    }

}