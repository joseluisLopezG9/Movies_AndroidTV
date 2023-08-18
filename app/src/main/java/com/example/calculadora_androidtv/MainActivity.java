package com.example.calculadora_androidtv;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private StringBuilder input = new StringBuilder();
    private double operand1 = Double.NaN;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        input.append(button.getText());
        textViewResult.setText(input.toString());
    }

    public void onOperatorClick(View view) {
        if (input.length() > 0) {
            Button button = (Button) view;
            operator = button.getText().toString();
            operand1 = Double.parseDouble(input.toString());
            input.setLength(0);
        }
    }

    public void onEqualClick(View view) {
        if (!Double.isNaN(operand1) && !operator.isEmpty() && input.length() > 0) {
            double operand2 = Double.parseDouble(input.toString());
            double result = performOperation(operand1, operand2, operator);
            textViewResult.setText(String.valueOf(result));
            input.setLength(0);
            operand1 = Double.NaN;
            operator = "";
        }
    }

    public void onClearClick(View view) {
        input.setLength(0);
        textViewResult.setText("");
        operand1 = Double.NaN;
        operator = "";
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "×":
                return operand1 * operand2;
            case "÷":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    // Handle division by zero
                    return Double.NaN;
                }
            default:
                return Double.NaN;
        }
    }
}