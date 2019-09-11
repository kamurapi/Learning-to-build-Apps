package com.kamurapi.calculatorapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Context;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    Button btnNum1,btnNum2,btnNum3,btnNum4,btnNum5,btnNum6,btnNum7,btnNum8,btnNum9,btnNum0;
    Button btnClear,btnBackspace,btnOpenBracket,btnCloseBracket,btnPoint,btnEqual,btnAdd,btnDiv,btnMul,btnSubs;
    TextView tvCalculation,tvResult;
    String calculation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }

    public void initControl() {

        /** access text varible **/
        tvCalculation = (TextView) findViewById(R.id.tv_calculation);
        tvResult = (TextView) findViewById(R.id.tv_result);

        tvCalculation.setText("");
        tvResult.setText("");


        /**Access button variable**/
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


        /**Set on click listner to all button**/
        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);

        btnAdd.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnSubs.setOnClickListener(this);

        btnClear.setOnClickListener(this);
        btnBackspace.setOnClickListener(this);
        btnOpenBracket.setOnClickListener(this);
        btnCloseBracket.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnEqual.setOnClickListener(this);

    }

    public boolean isEmpty(TextView text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_num0:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("0");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"0");
                break;
            case R.id.btn_num1:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("1");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"1");
                break;
            case R.id.btn_num2:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("2");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"2");
                break;
            case R.id.btn_num3:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("3");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"3");
                break;
            case R.id.btn_num4:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("4");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"4");
                break;
            case R.id.btn_num5:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("5");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"5");
                break;
            case R.id.btn_num6:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("6");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"6");
                break;
            case R.id.btn_num7:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("7");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"7");
                break;
            case R.id.btn_num8:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("8");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"8");
                break;
            case R.id.btn_num9:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("9");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"9");
                break;

            case R.id.btn_add:
                if (!isEmpty(tvResult)) {
                    tvCalculation.setText(tvResult.getText().toString() + "+");
                    tvResult.setText("");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"+");
                break;
            case R.id.btn_substrack:
                if (!isEmpty(tvResult)) {
                    tvCalculation.setText(tvResult.getText().toString() + "-");
                    tvResult.setText("");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"-");
                break;
            case R.id.btn_division:
                if (!isEmpty(tvResult)) {
                    tvCalculation.setText(tvResult.getText().toString() + "/");
                    tvResult.setText("");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"/");
                break;
            case R.id.btn_multiply:
                if (!isEmpty(tvResult)) {
                    tvCalculation.setText(tvResult.getText().toString() + "x");
                    tvResult.setText("");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"x");
                break;

            case R.id.btn_delete:
                tvCalculation.setText("");
                tvResult.setText("");
                break;

            case R.id.btn_backspace:
                calculation = tvCalculation.getText().toString();
                if (calculation.length() > 0) {
                    calculation = calculation.substring(0, calculation.length() - 1);
                    tvCalculation.setText(calculation);
                }
                ;
                break;
            case R.id.btn_point:
                if (isEmpty(tvCalculation)) {
                    if (!isEmpty(tvResult)) {
                        tvResult.setText("");
                        tvCalculation.setText("0.");
                    }
                    else tvCalculation.setText(tvCalculation.getText().toString()+"0.");
                    break;
                }
                else {
                    tvCalculation.setText(tvCalculation.getText().toString()+".");
                }
                break;
            case R.id.btn_openbracket:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText("(");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+"(");
                break;
            case R.id.btn_closebracket:
                if (!isEmpty(tvResult)) {
                    tvResult.setText("");
                    tvCalculation.setText(")");
                }
                else tvCalculation.setText(tvCalculation.getText().toString()+")");
                break;
            case R.id.btn_equal:
                calculation = tvCalculation.getText().toString();
                calculation = calculation.replaceAll("x", "*");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String result = "";


                try {
                    Scriptable scope = rhino.initStandardObjects();
                    result = rhino.evaluateString(scope, calculation, "JavaScript", 1, null).toString();
                    String temp =  result.substring(result.indexOf("."));
                    if (temp.equals(".0"))
                        result = result.substring(0,result.length()-2);
                } catch (Exception e) {
                    result = "Error";
                }
                tvResult.setText(result);

                break;
        }
    }

}
