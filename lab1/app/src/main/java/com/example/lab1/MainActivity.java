package com.example.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Spinner mValues;

    public void onClickOk (View view)
    {
        mValues = findViewById(R.id.spinner);

        TextView textView1 = findViewById(R.id.textViewValue);
        textView1.setText(mValues.getSelectedItem().toString());
    }

    public void onClickCancel (View view)
    {
        System.exit(0);
    }

}
