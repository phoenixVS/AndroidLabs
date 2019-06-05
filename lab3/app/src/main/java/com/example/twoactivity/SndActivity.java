package com.example.twoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snd);
        Bundle arguments = getIntent().getExtras();
        String fileName = arguments.get("fileName").toString();
        TextView fName = findViewById(R.id.textView2);
        fName.setText(fileName);
        filePrint(fileName);
    }

    private TextView fileText;

    public void filePrint(String fileName) {
        try{
            File file = new File(fileName);
            file = new File(file.getAbsolutePath());
            String dir = file.getParent();
            FileInputStream fileInput = openFileInput(fileName);
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuffer strBuffer = new StringBuffer();
            String readValue;
            while ((readValue = buffer.readLine()) != null) {
                strBuffer.append(readValue + '\n');
            }
            fileText = findViewById(R.id.file_view);
            fileText.setText(strBuffer.toString());
            file.delete();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(SndActivity.this, "File not found", Toast.LENGTH_LONG).show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}