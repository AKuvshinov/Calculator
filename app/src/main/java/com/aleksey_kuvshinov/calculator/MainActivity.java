package com.aleksey_kuvshinov.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText calculation, result;
    private String curr, res;
    private boolean dot_inserted, operator_inserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button0 = (Button) findViewById(R.id.button0);
        Button buttonPt = (Button) findViewById(R.id.buttonPt);
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        Button buttonShare = (Button) findViewById(R.id.buttonShare);
        Button buttonMinus = (Button) findViewById(R.id.buttonMinus);
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        Button buttonEqual = (Button) findViewById(R.id.buttonEqual);
        Button buttonC = (Button) findViewById(R.id.buttonC);
        Button buttonDel = (Button) findViewById(R.id.buttonDel);

        View.OnClickListener onClickListener = v -> {
            switch (v.getId()) {
                case R.id.button0:
                    curr = curr + "0";
                    displayOne();
                    break;
                case R.id.button1:
                    curr = curr + "1";
                    displayOne();
                    break;
                case R.id.button2:
                    curr = curr + "2";
                    displayOne();
                    break;
                case R.id.button3:
                    curr = curr + "3";
                    displayOne();
                    break;
                case R.id.button4:
                    curr = curr + "4";
                    displayOne();
                    break;
                case R.id.button5:
                    curr = curr + "5";
                    displayOne();
                    break;
                case R.id.button6:
                    curr = curr + "6";
                    displayOne();
                    break;
                case R.id.button7:
                    curr = curr + "7";
                    displayOne();
                    break;
                case R.id.button8:
                    curr = curr + "8";
                    displayOne();
                    break;
                case R.id.button9:
                    curr = curr + "9";
                    displayOne();
                    break;
                case R.id.buttonPt:
                    if (curr.isEmpty()) {
                        curr = "0.";
                        dot_inserted = true;
                    }
                    if (!dot_inserted) {
                        curr = curr + ".";
                        dot_inserted = true;
                    }
                    displayOne();
                    break;
                case R.id.buttonC:
                    clear();
                    displayOne();
                    displayTwo();
                    break;
                case R.id.buttonDel:
                    backspace();
                    displayOne();
                    break;
                case R.id.buttonShare:
                    dot_inserted = false;
                    if (!curr.isEmpty()) {
                        if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                            backspace();
                        }
                        if (!operator_inserted) {
                            curr = curr + " / ";
                            operator_inserted = true;
                        }
                    }
                    displayOne();
                    break;
                case R.id.buttonMultiply:
                    dot_inserted = false;
                    if (!curr.isEmpty()) {
                        if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                            backspace();
                        }
                        if (!operator_inserted) {
                            curr = curr + " * ";
                            operator_inserted = true;
                        }
                    }
                    displayOne();
                    break;
                case R.id.buttonMinus:
                    dot_inserted = false;
                    if (!curr.isEmpty()) {
                        if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                            backspace();
                        }
                        if (!operator_inserted) {
                            curr = curr + " - ";
                            operator_inserted = true;
                        }
                    }
                    displayOne();
                    break;
                case R.id.buttonPlus:
                    dot_inserted = false;
                    if (!curr.isEmpty()) {
                        if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                            backspace();
                        }
                        if (!operator_inserted) {
                            curr = curr + " + ";
                            operator_inserted = true;
                        }
                    }
                    displayOne();
                    break;
                case R.id.buttonEqual:
                    if (operator_inserted && !curr.substring(curr.length() - 1, curr.length()).equals(" ")) {
                        String[] tokens = curr.split(" ");
                        switch (tokens[1].charAt(0)) {
                            case '+':
                                res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                                break;
                            case '-':
                                res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                                break;
                            case '*':
                                res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                                break;
                            case '/':
                                res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                                break;
                        }
                        displayTwo();
                        break;
                    }
            }

        };
        button0.setOnClickListener(onClickListener);
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);
        button8.setOnClickListener(onClickListener);
        button9.setOnClickListener(onClickListener);
        buttonPt.setOnClickListener(onClickListener);
        buttonC.setOnClickListener(onClickListener);
        buttonDel.setOnClickListener(onClickListener);
        buttonShare.setOnClickListener(onClickListener);
        buttonMultiply.setOnClickListener(onClickListener);
        buttonMinus.setOnClickListener(onClickListener);
        buttonPlus.setOnClickListener(onClickListener);
        buttonEqual.setOnClickListener(onClickListener);
    }
    public void displayOne() {
        calculation.setText(curr);
    }

    public void displayTwo() {
        result.setText(res);
    }

    public void clear() {
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
    }
    public void backspace() {
        if (!curr.isEmpty()) {
            if (curr.substring(curr.length()-1, curr.length()).equals(".")) {
                dot_inserted = false;
            }
            if (curr.substring(curr.length()-1, curr.length()).equals(" ")) {
                curr = curr.substring(0, curr.length()-3);
                operator_inserted = false;
            } else {
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }
}