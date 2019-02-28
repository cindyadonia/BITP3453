package com.example.bitp3453labs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Year;

public class FirstActivity extends AppCompatActivity {

    TextView txtvwAge;
    EditText edtName, edtYear;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        txtvwAge = findViewById(R.id.txtvwAge);
        edtName = findViewById(R.id.edtTextName);
        edtYear = findViewById(R.id.edtYear);
    }

    public void fnGreet(View vw)
    {
        int year = Year.now().getValue();
        int inputtedYear = Integer.parseInt(edtYear.getText().toString());
        int age = year-inputtedYear;
        String strName = edtName.getText().toString();
        txtvwAge.setText("Hello and welcome " + strName + ". Your age is " + age);
    }


    public void fnThreadActivity (View vw)
    {
        Intent intent = new Intent (this, ThreadedActivity.class);
        String strMsg = ((EditText) findViewById(R.id.edtTextName)).getText().toString();
        intent.putExtra("varStr1", strMsg);
        startActivity(intent);
    }
}
