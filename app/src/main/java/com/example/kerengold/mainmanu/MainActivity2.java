package com.example.kerengold.mainmanu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView tvSOl;
    Button btnCompute;
    EditText num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        tvSOl = (TextView)findViewById(R.id.tvSol);
        btnCompute = (Button)findViewById(R.id.btnCompute);
        num1 = (EditText)findViewById(R.id.etNum1);
        num2 = (EditText)findViewById(R.id.etNum2);

        btnCompute.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (num1.getText().toString().length()>0 && num2.getText().toString().length()>0){

            tvSOl.setText(String.valueOf(Integer.valueOf(num1.getText().toString()) +Integer.valueOf( num2.getText().toString())));
        }
    }
}
