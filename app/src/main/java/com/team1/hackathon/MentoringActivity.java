package com.team1.hackathon;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

import java.util.Calendar;

/**
 * Created by songmho on 15. 8. 22.
 */
public class MentoringActivity extends AppCompatActivity {
    int cur_year;
    int cur_mon;
    int cur_day;


    EditText mentor;
    EditText title;
    EditText job;
    EditText venue;
    EditText detail;
    TextView text_date;

    Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metoring);


        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("멘토링 추가");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mentor = (EditText)findViewById(R.id.mentor);
        title = (EditText)findViewById(R.id.title);
        job= (EditText)findViewById(R.id.job);
        venue=(EditText)findViewById(R.id.venue);
        detail=(EditText)findViewById(R.id.detail);
        text_date=(TextView)findViewById(R.id.text_date);
        Button pickdate=(Button)findViewById(R.id.bt_date);
        pickdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur_year = Calendar.getInstance().get(Calendar.YEAR);
                cur_mon = Calendar.getInstance().get(Calendar.MONTH);
                cur_day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);


                Dialog date_picker = new DatePickerDialog(MentoringActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        text_date.setText("" + cur_year + "." + cur_mon + "." + cur_day);
                    }
                }, cur_year, cur_mon, cur_day);
                date_picker.show();
            }
        });
        Button add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject parseObject = new ParseObject("ValueUp_mentor");
                parseObject.put("mentor", String.valueOf(mentor.getText()));
                parseObject.put("title", String.valueOf(title.getText()));
                parseObject.put("job", String.valueOf(job.getText()));
                parseObject.put("detail", String.valueOf(venue.getText()));
                parseObject.put("detail", String.valueOf(detail.getText()));
                parseObject.put("year", cur_year);
                parseObject.put("month", cur_mon);
                parseObject.put("day", cur_day);

                parseObject.saveInBackground();
                Toast.makeText(getApplicationContext(), "추가완료", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
