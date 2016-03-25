package com.example.kien.game_gridview_remembercolor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import AdapterCustom.AdapterHighScore;
import Enity.InforHightScore;

public class HightScoreActivity extends AppCompatActivity {
    ListView listdata;
    ArrayList<InforHightScore> listhight;
    AdapterHighScore adapter;
    ImageView imgback;
    TextView txtv_null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hight_score);
        imgback = (ImageView) findViewById(R.id.img_back);
        txtv_null = (TextView)findViewById(R.id.txtv_null);
        Intent it = getIntent();
        listhight = (ArrayList<InforHightScore>) it.getSerializableExtra("list");
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (listhight.size() == 0) {
            txtv_null.setText("Not Score");
        } else {
            listdata = (ListView) findViewById(R.id.list_hightscore);
            adapter = new AdapterHighScore(listhight, HightScoreActivity.this);
            listdata.setAdapter(adapter);
        }
    }
}
