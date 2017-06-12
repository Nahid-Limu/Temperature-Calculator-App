package com.example.nahid.tc;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText value;
    RadioGroup radioGroup;
    RadioButton rbf, rbc;
    Button button;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value = (EditText) findViewById(R.id.value);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        button = (Button) findViewById(R.id.button);
        rbf = (RadioButton) findViewById(R.id.r1);
        rbc = (RadioButton) findViewById(R.id.r2);
        res = (TextView) findViewById(R.id.res);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                if (checkedId == R.id.r1){
                    Toast.makeText(getApplicationContext(),"Select FAHRENHEIT", Toast.LENGTH_LONG).show();
                }
                else if (checkedId == R.id.r2){
                    Toast.makeText(getApplicationContext(),"Select CELSIUS",Toast.LENGTH_LONG).show();
                }

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == rbf.getId()){

                    String data = value.getText().toString();
                    Double fv = Double.parseDouble(data);
                    Double r = (fv *(9/5))+32;

                    res.setText(Double.toString(r)+"°F");

                    value.getText().clear();

                }
                else if (selectedId == rbc.getId()){

                    String data = value.getText().toString();
                    Double cv = Double.parseDouble(data);
                    Double r = (cv-32)*(9/5);

                    res.setText(Double.toString(r)+"°C");

                    value.getText().clear();

                }
            }
        });


    }
}
