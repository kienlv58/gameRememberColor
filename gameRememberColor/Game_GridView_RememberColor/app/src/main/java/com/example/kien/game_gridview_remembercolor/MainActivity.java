package com.example.kien.game_gridview_remembercolor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Enity.InforHightScore;

public class MainActivity extends AppCompatActivity {
    Button btn_newgame, btn_level, btn_hightscore, btn_exit;
    public final static int TIMESEE_EASY = 3;
    public static final int TIMEPLAY_EASY = 20;
    public static final int TIMESEE_NORMAL = 2;
    public static final int TIMEPLAY_NORMAL = 15;
    public static final int TIMESEE_HARD = 1;
    public static final int TIMEPLAY_HARD = 10;
    ArrayList<InforHightScore> listHightScore = new ArrayList<InforHightScore>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(MainActivity.this, listHightScore.size()+ "", Toast.LENGTH_SHORT).show();
        initView();

    }

    private void initView() {
        btn_newgame = (Button) findViewById(R.id.btn_newgame);
        btn_level = (Button) findViewById(R.id.btn_level);
        btn_hightscore = (Button) findViewById(R.id.btn_hightscore);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        btn_newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, NewGameActivity.class);
                startActivity(intent1);
            }
        });
        btn_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, LevelActivity.class);
                startActivity(intent2);
            }
        });
        btn_hightscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, HightScoreActivity.class);
                intent3.putExtra("list",listHightScore);
                startActivity(intent3);
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (GamveOverActivity.sendDone == true) {
            Intent dataFromHight = getIntent();
            InforHightScore infor = (InforHightScore) dataFromHight.getSerializableExtra("infor");
            if (listHightScore.size() < 5) {
                listHightScore.add(infor);
                sortHightScore();
            } else {
                sortHightScore();
                for (int i = 0; i < listHightScore.size(); i++) {
                    if (infor.getScore() > listHightScore.get(i).getScore()) {
                        listHightScore.remove(i);
                        listHightScore.add(infor);
                        sortHightScore();
                    }
                }
            }
        }

    }

    public void sortHightScore() {
        if (listHightScore.size() > 2) {
            Collections.sort(listHightScore, new Comparator<InforHightScore>() {
                @Override
                public int compare(InforHightScore h1, InforHightScore h2) {
                    if (h1.getScore() < h2.getScore())
                        return 1;
                    else if (h1.getScore() == h2.getScore())
                        return 0;
                    else return -1;
                }
            });
        }
    }
}
