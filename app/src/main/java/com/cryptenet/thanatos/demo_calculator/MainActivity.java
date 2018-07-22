package com.cryptenet.thanatos.demo_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private EditText etInput;
    private TextView tvResult;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSubtract,
            btnMultiply, btnDivide, btnEqual, btnAC;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        viewBinder();

        setSupportActionBar(toolbar);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnAC.setOnClickListener(this);
    }

    private void viewBinder() {
        toolbar = findViewById(R.id.toolbar);

        etInput = findViewById(R.id.et_input);

        tvResult = findViewById(R.id.tv_result);

        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnEqual = findViewById(R.id.btn_equal);
        btnAC = findViewById(R.id.btn_ac);
    }

    private void performOperation(int operator, double input) {
        if (operator == 1) {
            result += input;
        } else if (operator == 2) {
            result -= input;
        } else if (operator == 3) {
            result *= input;
        } else {
            result /= input;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                etInput.getText().append("0");
                break;
            case R.id.btn_1:
                etInput.getText().append("1");
                break;
            case R.id.btn_2:
                etInput.getText().append("2");
                break;
            case R.id.btn_3:
                etInput.getText().append("3");
                break;
            case R.id.btn_4:
                etInput.getText().append("4");
                break;
            case R.id.btn_5:
                etInput.getText().append("5");
                break;
            case R.id.btn_6:
                etInput.getText().append("6");
                break;
            case R.id.btn_7:
                etInput.getText().append("7");
                break;
            case R.id.btn_8:
                etInput.getText().append("8");
                break;
            case R.id.btn_9:
                etInput.getText().append("9");
                break;
            case R.id.btn_equal:
                if (etInput.getText().toString().length() > 0) {
                    performOperation(
                            1,
                            Double.parseDouble(etInput.getText().toString())
                    );
                }
                if (result > 0) {
                    tvResult.setText(String.valueOf(result));
                    result = 0;
                }
                break;
            case R.id.btn_ac:
                etInput.setText("");
                tvResult.setText(R.string.tv_result);
                result = 0;
                break;
            default:
                if (etInput.getText().toString().length() > 0) {
                    switch (v.getId()) {
                        case R.id.btn_add:
                            performOperation(
                                    1,
                                    Double.parseDouble(etInput.getText().toString())
                            );
                            break;
                        case R.id.btn_subtract:
                            performOperation(
                                    2,
                                    Double.parseDouble(etInput.getText().toString())
                            );
                            break;
                        case R.id.btn_multiply:
                            performOperation(
                                    3,
                                    Double.parseDouble(etInput.getText().toString())
                            );
                            break;
                        case R.id.btn_divide:
                            performOperation(
                                    4,
                                    Double.parseDouble(etInput.getText().toString())
                            );
                            break;
                    }

                    etInput.setText("");
                    tvResult.setText(String.valueOf(result));
                }
        }
    }


}
