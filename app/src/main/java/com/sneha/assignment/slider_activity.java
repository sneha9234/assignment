package com.sneha.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class slider_activity extends AppCompatActivity {

    private SeekBar sb;
    private TextView tV;
    private TextView min_value1;
    private TextView max_value1;
    private Button sbmt;
    public int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_activity);

        final int min = getIntent().getIntExtra("min", 0);
        final int max = getIntent().getIntExtra("max", 0);

        int up = (max - min);

        sb = findViewById(R.id.seekBar);
        tV = findViewById(R.id.tV);
        min_value1 = findViewById(R.id.min_value1);
        max_value1 = findViewById(R.id.max_value1);
        sbmt = findViewById(R.id.sbmt);

        tV.setText(String.valueOf(min));

        min_value1.setText(String.valueOf(min));
        max_value1.setText(String.valueOf(max));

        sb.setProgress(0);
        sb.setMax(up);

        num = min;

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int a = sb.getProgress();
                num = a + min;
                tV.setText(String.valueOf(num));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbmanager dm = new dbmanager(slider_activity.this);
                final SQLiteDatabase db = dm.getWritableDatabase();

                Date currentTime = Calendar.getInstance().getTime();

                ContentValues cv = new ContentValues();
                cv.put("rating", num);
                cv.put("dnt", String.valueOf(currentTime));

                long i = db.insert("hist", null, cv);
                if (i != -1) {
                    Toast.makeText(slider_activity.this, "data inserted successfully", Toast.LENGTH_SHORT).show();
                }

                sb.setProgress(0);
            }
        });

    }
}
