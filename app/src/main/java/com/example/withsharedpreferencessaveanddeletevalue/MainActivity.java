package com.example.withsharedpreferencessaveanddeletevalue;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button,delete;
    SharedPreferences sharedPreferences;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.save);
        delete = findViewById(R.id.delete);

        sharedPreferences = this.getSharedPreferences("com.example.repeatalltopics", MODE_PRIVATE);
        int value = sharedPreferences.getInt("tale", 0);

        if (value == 0) {
            textView.setText("Your age:");

        } else {

            textView.setText("Your age: " + value);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ageS = editText.getText().toString();
                int age = Integer.parseInt(ageS);

                if (!ageS.matches("")) {
                    textView.setText("Your age: " + age);
                    sharedPreferences.edit().putInt("tale", age).apply();

                } else {
                    textView.setText("Enter your age: ");
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int storedAge = sharedPreferences.getInt("tale", 0);

                if(storedAge!=0){

                    sharedPreferences.edit().remove("tale").apply();
                    textView.setText("Your age: ");
                }
            }
        });
    }
}