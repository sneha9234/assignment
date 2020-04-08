package com.sneha.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {

    private Button btn_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        getSupportActionBar().setTitle("Homepage");

        final int min = getIntent().getIntExtra("min", 0);
        final int max = getIntent().getIntExtra("max", 0);

        String res = "Rating " + min + "-" + max;

        btn_rating = (Button) findViewById(R.id.btn_rating);

        btn_rating.setText(res);

        btn_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homepage.this, slider_activity.class);
                intent.putExtra("min", min);
                intent.putExtra("max", max);
                startActivity(intent);

            }
        });
    }
}
