package com.example.wind.filepersistence;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit);
        String inputText = load();
        if(!TextUtils.isEmpty(inputText)){
            editText.setText(inputText);
            editText.setSelection(inputText.length());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String data = editText.getText().toString();
        sava(data);
    }

    public void sava(String data){
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            fos = openFileOutput("data", Context.MODE_PRIVATE);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(data);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(bw != null){
                    bw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public String load(){
        FileInputStream fis = null;
        BufferedReader br = null;
        StringBuilder stringBuilder = new StringBuilder();
        try{
            fis = openFileInput("data");
            br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while((line = br.readLine()) != null){
                stringBuilder.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}
