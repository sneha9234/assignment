package com.sneha.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText min;
    private EditText max;
    private Button btn1;
    private TextView history;
    int range[]; //just 1 variable somewhere in the app that can change rating range

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history = (TextView) findViewById(R.id.history);
        min = (EditText) findViewById(R.id.min_value);
        max = (EditText) findViewById(R.id.max_value);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setEnabled(false);

        min.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (min.getText().toString().trim().equals("") || max.getText().toString().trim().equals("")) {
                    btn1.setEnabled(false);
                } else {
                    btn1.setEnabled(true);
                }

                if (min.getText().toString().length() == 1) {
                    max.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });

        max.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if (min.getText().toString().trim().equals("") || max.getText().toString().trim().equals("")) {
                    btn1.setEnabled(false);
                } else {
                    btn1.setEnabled(true);
                }

                if (min.getText().toString().length() == 1) {
                    btn1.requestFocus();
                }

            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                range = new int[2]; //just 1 variable somewhere in the app that can change rating range
                //  range={min,max};

                range[0] = Integer.parseInt(min.getText().toString());
                range[1] = Integer.parseInt(max.getText().toString());

                if (range[1] <= range[0]) {
                    Toast.makeText(MainActivity.this, "upper limit cannot be less than or equal to lower limit", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(MainActivity.this, homepage.class);
                    intent.putExtra("min", range[0]);
                    intent.putExtra("max", range[1]);
                    startActivity(intent);

                }
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, history.class);
                startActivity(intent);
            }
        });


    }
}