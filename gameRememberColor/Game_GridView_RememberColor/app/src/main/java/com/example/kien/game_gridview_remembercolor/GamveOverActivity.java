package com.example.kien.game_gridview_remembercolor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Enity.InforHightScore;

public class GamveOverActivity extends AppCompatActivity {
    public static boolean sendDone = false;
    TextView txtv_score;
    EditText edt_name;
    Button btn_ok;
    String name;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamve_over);
        txtv_score = (TextView)findViewById(R.id.txtv_score);
        edt_name = (EditText)findViewById(R.id.edt_name);
        btn_ok = (Button)findViewById(R.id.btn_ok);

        Intent intentScore = getIntent();
        score = (int)intentScore.getExtras().getInt("score");
        txtv_score.setText(score+"");
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent FromHightScore = new Intent(GamveOverActivity.this,MainActivity.class);
                name = edt_name.getText().toString();
                InforHightScore info = new InforHightScore(name,score);
                FromHightScore.putExtra("infor", info);
                startActivity(FromHightScore);
                sendDone = true;
                finish();
            }
        });
    }
}
