package com.example.roulettegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    NumberPicker numberPicker;
    String[] places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinnerNumbers=findViewById(R.id.spinner_numbers);
        // array adapter: renders all array to screen
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // attach adapter to dropdown/spinner
        spinnerNumbers.setAdapter(adapter);


        // number picker
        textView= findViewById(R.id.textView);
        numberPicker = findViewById(R.id.numberPicker);
        places = getResources().getStringArray(R.array.numbers);
//        String[] data = new String[]{"Berlin", "Moscow", "Tokyo", "Paris"};
//        String[] data = new Number[]{this, R.array.numbers};
//        numberPicker.setMinValue(0); // starting at zero
//        numberPicker.setMaxValue(data.length-1);
//        numberPicker.setDisplayedValues(data);
        // does not like negative numbers??
        // second number picker for pos/neg to be to the left
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(places.length-1);
        numberPicker.setValue(0);//sets to first
        numberPicker.setDisplayedValues(places);
        textView.setText(String.format("User's Number: %s", places[numberPicker.getValue()])); // shows starting value
        // how to also receive the negative/positive sign from the second wheel??
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textView.setText(String.format("User's Number: %s", places[i1]));
            }
        });
    }


}