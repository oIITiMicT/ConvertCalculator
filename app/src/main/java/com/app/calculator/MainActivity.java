package com.app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConversionCalculator calculator = new ConversionCalculator();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text = findViewById(R.id.valueLabel);
                String parentValue = text.getText().toString();
                text = findViewById(R.id.parentNotationLabel);
                int parentNotation = Integer.parseInt(text.getText().toString());
                text = findViewById(R.id.reauestNotationLabel);
                int requestNotation = Integer.parseInt(text.getText().toString());
                String result = calculator.convert(parentValue, parentNotation, requestNotation);
                TextView print = findViewById(R.id.resultLabel);
                print.setText(result);
            }
        });
    }
}