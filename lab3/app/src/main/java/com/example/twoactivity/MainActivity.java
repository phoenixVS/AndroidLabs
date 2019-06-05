package com.example.twoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Spinner mValues;
    private TextView textView1;

    public void onClickRead (View view)
    {
        try{
            File file = new File("lab3.txt");
            file = new File(file.getAbsolutePath());
            String dir = file.getParent();
            FileInputStream fileInput = openFileInput("lab3.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuffer strBuffer = new StringBuffer();
            String readValue;
            while ((readValue = buffer.readLine()) != null) {
                strBuffer.append(readValue + '\n');
            }
            textView1.setText(strBuffer.toString());
            file.delete();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "File not found", Toast.LENGTH_LONG).show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void onClickWrite (View view)
    {
        mValues = findViewById(R.id.spinner);
        textView1 = findViewById(R.id.textViewValue);
        String str = (mValues.getSelectedItem().toString()+'\n');
        try {
            FileOutputStream fileOutput;
            fileOutput = openFileOutput("lab3.txt", MODE_APPEND);
            fileOutput.write(str.getBytes());
            fileOutput.close();
            Toast.makeText(MainActivity.this, "Text saved", Toast.LENGTH_LONG).show();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void onClickOpenFile (View view)
    {
        Intent i = new Intent(this, SndActivity.class);
        i.putExtra("fileName", "lab3.txt");
        startActivity(i);
    }

    public void onClickCancel (View view)
    {
        System.exit(0);
    }
}
