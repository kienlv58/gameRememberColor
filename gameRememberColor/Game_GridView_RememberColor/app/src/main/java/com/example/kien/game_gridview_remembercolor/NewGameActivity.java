
package com.example.kien.game_gridview_remembercolor;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import AdapterCustom.AdapterPoint;
import Enity.ColorEnity;
import Enity.PointEnity;

public class NewGameActivity extends AppCompatActivity {
    ArrayList<PointEnity> Arr_data;
    ArrayList<PointEnity> Arr_changeColor;
    AdapterPoint adapter;
    int maxNumColum = 10;
    int numColum = 2;
    int choose = numColum;
    int score = 0;
    boolean finish = false;
    int lv = LevelActivity.level;
    CountDownTimer c;
    GridView grv_data;
    TextView txtv_score, txtv_timeplay, txtv_choose,txtv_see;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        initView();
        if (lv == 0) {
            createData(MainActivity.TIMEPLAY_EASY, MainActivity.TIMESEE_EASY);
            grv_data.setOnItemClickListener(new ClickItemDiffent11(MainActivity.TIMEPLAY_EASY, MainActivity.TIMESEE_EASY));
        } else if (lv == 1) {
            createData(MainActivity.TIMEPLAY_NORMAL, MainActivity.TIMESEE_NORMAL);
            grv_data.setOnItemClickListener(new ClickItemDiffent11(MainActivity.TIMEPLAY_NORMAL, MainActivity.TIMESEE_NORMAL));
        } else {
            createData(MainActivity.TIMEPLAY_HARD, MainActivity.TIMESEE_HARD);
            grv_data.setOnItemClickListener(new ClickItemDiffent11(MainActivity.TIMEPLAY_HARD, MainActivity.TIMESEE_HARD));
        }

        adapter = new AdapterPoint(Arr_data, NewGameActivity.this);
        grv_data.setAdapter(adapter);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (data != null)
//            if (resultCode == 100) {
//                lv = (int) data.getExtras().getInt("set level");
//            }
//    }
    private void initView() {
        grv_data = (GridView) findViewById(R.id.grv_data);
        txtv_score = (TextView) findViewById(R.id.txtv_score);
        txtv_choose = (TextView) findViewById(R.id.txtv_choose);
        txtv_timeplay = (TextView) findViewById(R.id.txtv_timeplay);
        txtv_see = (TextView)findViewById(R.id.txtv_see);
        txtv_score.setText(score+"");
        grv_data.setNumColumns(numColum);
    }

    private class ClickItemDiffent11 implements AdapterView.OnItemClickListener {
        private final int a;
        private final int b;

        public ClickItemDiffent11(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (finish == false) {

            } else {
                PointEnity pointClick = adapter.getItem(position);
                if (pointClick.isRight() == false) {
                    c.cancel();
                    Intent intent_gameover = new Intent(NewGameActivity.this,GamveOverActivity.class);
                    intent_gameover.putExtra("score",score);
                    startActivity(intent_gameover);
//                    Intent intent = new Intent(NewGameActivity.this, MainActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // this will clear all the stack
//                    intent.putExtra("Exit me", true);
//                    startActivity(intent);
                    finish();

                } else {
                    //Toast.makeText(NewGameActivity.this, pointClick.isRight() + "", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < Arr_changeColor.size(); i++) {
                        if (pointClick.getId() == Arr_changeColor.get(i).getId()) {
                            pointClick.setColor_last(Arr_changeColor.get(i).getColor_last());
                            Arr_changeColor.remove(i);
                            txtv_choose.setText(--choose + "");
                            score = score + 10;
                            txtv_score.setText(""+ score);

                            adapter.notifyDataSetChanged();
                        }
                    }
                }
                if (Arr_changeColor.size() == 0) {
                    c.cancel();
                    if (numColum < maxNumColum)
                        numColum++;
                    choose = numColum;
                    txtv_choose.setText("" + choose);
                    grv_data.setNumColumns(numColum);
                    createData(a, b);
                    adapter.setArr_listData(Arr_data);
                    adapter.notifyDataSetChanged();
                }
            }
        }

    }

    public void createData(final int time, final int timeseee) {
        Arr_data = new ArrayList<PointEnity>();
        ColorEnity randomCL = randomColor();
        for (int i = 0; i < numColum * numColum; i++)
            Arr_data.add(new PointEnity(i, randomCL, randomCL, false,""));
        Random rd = new Random();
        Arr_changeColor = new ArrayList<PointEnity>();
        int maxrandom = numColum*numColum;
        for (int i = 0; i < numColum; i++) {
            ColorEnity colochange;
            do {
                colochange = randomColor();
            }
            while (randomCL.equals(colochange));
            int pos = rd.nextInt(maxrandom);
            for (int j = 0;j <Arr_changeColor.size();j++){
                if (pos == Arr_changeColor.get(j).getId())
                    pos = rd.nextInt(maxrandom);
            }
            Arr_data.get(pos).setColor_last(colochange);
            Arr_data.get(pos).setIsRight(true);
            Arr_data.get(pos).setText("*");
            Arr_changeColor.add(new PointEnity(pos, randomCL, colochange, true,"*"));
        }
        txtv_timeplay.setText("" + time);
        CountDownTimer see = coutnSEEcolor(timeseee, time);
        see.start();

    }

    public ColorEnity randomColor() {
        ColorEnity cl = new ColorEnity();
        Random rd = new Random();
        cl.setAnpha(255);
        cl.setRed(rd.nextInt(200));
        cl.setGreen(rd.nextInt(255));
        cl.setBlue(rd.nextInt(255));
        return cl;
    }

    public CountDownTimer count_play(final int time1) {
        CountDownTimer countplay = new CountDownTimer(time1 * 1000 , 980) {
            int t = time1;

            @Override
            public void onTick(long millisUntilFinished) {
                t--;
                txtv_timeplay.setText(t+"");

            }

            @Override
            public void onFinish() {
                if (Arr_changeColor.size() != 0) {
                    Intent intent_gameover = new Intent(NewGameActivity.this,GamveOverActivity.class);
                    intent_gameover.putExtra("score",score);
                    startActivity(intent_gameover);
                    finish();
                }
            }
        };
        return countplay;
    }

    public CountDownTimer coutnSEEcolor(final int see, final int time_play) {
        CountDownTimer countSeen = new CountDownTimer(see * 1000+900, 900) {
            int s = see;
            @Override
            public void onTick(long millisUntilFinished) {
                finish = false;
                txtv_see.setText(s+"");
                s--;
            }

            @Override
            public void onFinish() {
                finish = true;
                for (int i = 0; i < Arr_changeColor.size(); i++) {
                    int id = Arr_changeColor.get(i).getId();
                    ColorEnity colorbefor = Arr_changeColor.get(i).getColor_first();
                    Arr_data.get(id).setColor_last(colorbefor);
                    Arr_data.get(id).setText("");
                }
                adapter.notifyDataSetChanged();
                c = count_play(time_play);
                c.start();
            }
        };
        return countSeen;
    }

}
