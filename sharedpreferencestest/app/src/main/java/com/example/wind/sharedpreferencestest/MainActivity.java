package com.example.wind.sharedpreferencestest;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.save_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Tomas");
                editor.putInt("age", 20);
                editor.apply();
                Toast.makeText(MainActivity.this, "success",Toast.LENGTH_SHORT).show();
            }
        });

        Button button1 = (Button) findViewById(R.id.restore_data);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spf = getSharedPreferences("data", MODE_PRIVATE);
                String name = spf.getString("name", "");
                int age = spf.getInt("age", 0);
                Toast.makeText(MainActivity.this, "name is" + name, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "age is" + age, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

