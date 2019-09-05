package com.kamurapi.hitungluasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText panjang, lebar,hasil;
    private Button hitung;
    private TextView luas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panjang = (EditText) findViewById(R.id.panjang);
        lebar = (EditText) findViewById(R.id.lebar);
        hitung  = (Button) findViewById(R.id.hitung);
        luas = (TextView) findViewById(R.id.luas);

        addListenerButton();
    }

    private void addListenerButton() {

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkDataEntered()) {
                    String p,l;

                    p = panjang.getText().toString();
                    l = lebar.getText().toString();

                    double output,inputp,inputl;

                    inputp = Double.parseDouble(p);
                    inputl = Double.parseDouble(l);
                    output = inputl * inputp;

                    luas.setText("Hasil: " + output);

                }
            }
        });

    }


    private boolean checkDataEntered() {

        if (isEmpty(panjang) && isEmpty(lebar)){
            panjang.setError("isi nilai panjang");
            lebar.setError("isi nilai lebar");
            return false;
        }

        else if (isEmpty(panjang)){
            panjang.setError("isi nilai panjang");
            return false;
        }

        else if (isEmpty(lebar)){
            lebar.setError("isi nilai lebar");
            return false;
        }
        return true;
    }

    private boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


}
