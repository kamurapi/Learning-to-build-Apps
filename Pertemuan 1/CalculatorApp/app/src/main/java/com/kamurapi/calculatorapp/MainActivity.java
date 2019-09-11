package com.kamurapi.calculatorapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Context;

public class MainActivity extends AppCompatActivity {


    Button btnNum1,btnNum2,btnNum3,btnNum4,btnNum5,btnNum6,btnNum7,btnNum8,btnNum9,btnNum0;
    Button btnClear,btnBackspace,btnOpenBracket,btnCloseBracket,btnPoint,btnEqual,btnAdd,btnDiv,btnMul,btnSubs;
    TextView tvCalculation,tvResult;
    String calculation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** access variable **/
        tvCalculation = (TextView) findViewById(R.id.tv_calculation);
        tvResult = (TextView) findViewById(R.id.tv_result);

        tvCalculation.setText("");
        tvResult.setText("");
        btnClear = (Button) findViewById(R.id.btn_delete);
        btnBackspace = (Button) findViewById(R.id.btn_backspace);
        btnOpenBracket = (Button) findViewById(R.id.btn_openbracket);
        btnCloseBracket = (Button) findViewById(R.id.btn_closebracket);
        btnPoint = (Button) findViewById(R.id.btn_point);
        btnEqual = (Button) findViewById(R.id.btn_equal);

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnDiv = (Button) findViewById(R.id.btn_division);
        btnMul = (Button) findViewById(R.id.btn_multiply);
        btnSubs = (Button) findViewById(R.id.btn_substrack);

        btnNum0 = (Button) findViewById(R.id.btn_num0);
        btnNum1 = (Button) findViewById(R.id.btn_num1);
        btnNum2 = (Button) findViewById(R.id.btn_num2);
        btnNum3 = (Button) findViewById(R.id.btn_num3);
        btnNum4 = (Button) findViewById(R.id.btn_num4);
        btnNum5 = (Button) findViewById(R.id.btn_num5);
        btnNum6 = (Button) findViewById(R.id.btn_num6);
        btnNum7 = (Button) findViewById(R.id.btn_num7);
        btnNum8 = (Button) findViewById(R.id.btn_num8);
        btnNum9 = (Button) findViewById(R.id.btn_num9);




        /** Set Function in button**/

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCalculation.setText("");
                tvResult.setText("");
            }
        });





        btnNum0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+"0");
            }
        });
        btnNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+"1");
            }
        });
        btnNum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+"2");
            }
        });
        btnNum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+"3");
            }
        });
        btnNum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+"4");
            }
        });
        btnNum5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+"5");
            }
        });
        btnNum6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+"6");
            }
        });
        btnNum7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+"7");
            }
        });
        btnNum8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+"8");
            }
        });
        btnNum9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+"9");
            }
        });



        /**Button for calculation**/
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+ "+");
            }
        });

        btnSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+ "-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+ "X");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+ "/");
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                tvCalculation.setText(calculation+ ".");
            }
        });
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = tvCalculation.getText().toString();
                if(calculation.length()>0) {
                    calculation = calculation.substring(0, calculation.length() - 1);
                    tvCalculation.setText(calculation);
                };
            }
        });

        /**btn result**/
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculation = tvCalculation.getText().toString();
                calculation = calculation.replaceAll("X", "*");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String result = "";



                Toast t = Toast.makeText(getApplicationContext(),calculation,Toast.LENGTH_SHORT);
                t.show();
                try{
                    Scriptable scope = rhino.initStandardObjects();
                    result = rhino.evaluateString(scope, calculation, "JavaScript", 1, null).toString();
                }catch (Exception e){
                    result = "Error";
                }
                tvResult.setText(result);

            }
        });
    }
}
