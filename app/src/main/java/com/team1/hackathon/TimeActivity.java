package com.team1.hackathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by songmho on 2015-09-01.
 */
public class TimeActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView title;
    Button button_ok;
    RadioGroup radio_group;
    RadioButton radio_1;
    RadioButton radio_2;
    RadioButton radio_3;
    RadioButton radio_4;
    RadioButton radio_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("시간설정");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title=(TextView)findViewById(R.id.title);
        button_ok=(Button)findViewById(R.id.button_ok);
        radio_group=(RadioGroup)findViewById(R.id.radio_group);
        radio_1=(RadioButton)findViewById(R.id.radio_1);
        radio_2=(RadioButton)findViewById(R.id.radio_2);
        radio_3=(RadioButton)findViewById(R.id.radio_3);
        radio_4=(RadioButton)findViewById(R.id.radio_4);
        radio_5=(RadioButton)findViewById(R.id.radio_5);


        switch (radio_group.getCheckedRadioButtonId()){
            case R.id.radio_1:
                title.setText(radio_1.getHint());
                break;
            case R.id.radio_2:
                title.setText(radio_2.getHint());
                break;
            case R.id.radio_3:
                title.setText(radio_3.getHint());
                break;
            case R.id.radio_4:
                title.setText(radio_4.getHint());
                break;
            case R.id.radio_5:
                title.setText(radio_5.getHint());
                break;
        }

        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_1:
                        title.setText(radio_1.getHint());
                        break;
                    case R.id.radio_2:
                        title.setText(radio_2.getHint());
                        break;
                    case R.id.radio_3:
                        title.setText(radio_3.getHint());
                        break;
                    case R.id.radio_4:
                        title.setText(radio_4.getHint());
                        break;
                    case R.id.radio_5:
                        title.setText(radio_5.getHint());
                        break;
                }
            }
        });
    }
}
