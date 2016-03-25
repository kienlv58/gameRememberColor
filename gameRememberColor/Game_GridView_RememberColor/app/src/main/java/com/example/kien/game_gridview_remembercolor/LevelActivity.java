package com.example.kien.game_gridview_remembercolor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LevelActivity extends AppCompatActivity {
    RadioGroup group ;
    Button ok;
   // int lastcheck = R.id.radio_easy;
    public static int level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        ok = (Button)findViewById(R.id.btn_ok);

        group = (RadioGroup)findViewById(R.id.radio_group);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = group.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.radio_easy:
                        level = 0;
                        //lastcheck = R.id.radio_easy;
                        break;
                    case R.id.radio_normal:
                        level = 1;
                        //lastcheck = R.id.radio_normal;
                        break;

                    case R.id.radio_hard:
                        level = 2;
                        //lastcheck = R.id.radio_hard;
                        break;
                }
//                Intent intent = new Intent(LevelActivity.this, NewGameActivity.class);
//                intent.putExtra("set level",level);
//                Toast.makeText(LevelActivity.this,level+"",Toast.LENGTH_SHORT).show();
//                setResult(100, intent);
                Intent intentToMain = new Intent(LevelActivity.this, MainActivity.class);
                startActivity(intentToMain);
                finish();

            }
        });
        //((RadioButton)group.findViewById(lastcheck)).setChecked(true);
    }
}
