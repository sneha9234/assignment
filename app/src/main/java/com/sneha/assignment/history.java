package com.sneha.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class history extends AppCompatActivity {

    RecyclerView rc;
    adapter_hist ac;
    TextView tv_noContent;

    ArrayList<POJO> histList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        getSupportActionBar().setTitle("History");

        rc = (RecyclerView) findViewById(R.id.rc);
        tv_noContent = (TextView) findViewById(R.id.tv_noContent);

        histList = new ArrayList<>();

        Fetchdata();

        ac = new adapter_hist(histList);
        rc.setLayoutManager(new LinearLayoutManager(history.this, RecyclerView.VERTICAL, false));
        if (histList.isEmpty()) {
            rc.setVisibility(View.GONE);
            tv_noContent.setVisibility(View.VISIBLE);
            tv_noContent.setText("No history");

        } else {
            tv_noContent.setVisibility(View.GONE);
            rc.setVisibility(View.VISIBLE);
            rc.setAdapter(ac);
        }

    }

    private void Fetchdata() {
        dbmanager db = new dbmanager(history.this);

        Cursor cursor = db.fetch_data();

        if (cursor != null) {

            while (cursor.moveToNext()) {

                POJO pj = new POJO();
                pj.setRating(cursor.getString(0));
                pj.setDnt(cursor.getString(1));
                histList.add(pj);
            }
        }
    }
}
