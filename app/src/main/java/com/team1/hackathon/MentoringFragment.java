package com.team1.hackathon;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

import java.util.Calendar;

/**
 * Created by songmho on 15. 8. 22.
 */
public class MentoringFragment extends Fragment {
    int cur_year;
    int cur_mon;
    int cur_day;


    EditText mentor;
    EditText title;
    EditText job;
    EditText venue;
    EditText detail;
    TextView text_date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout cur_container=(FrameLayout)inflater.inflate(R.layout.fragment_metoring, container, false);

        mentor = (EditText)cur_container.findViewById(R.id.mentor);
        title = (EditText)cur_container.findViewById(R.id.title);
        job= (EditText)cur_container.findViewById(R.id.job);
        venue=(EditText)cur_container.findViewById(R.id.venue);
        detail=(EditText)cur_container.findViewById(R.id.detail);
        text_date=(TextView)cur_container.findViewById(R.id.text_date);
        Button pickdate=(Button)cur_container.findViewById(R.id.bt_date);
        pickdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur_year= Calendar.getInstance().get(Calendar.YEAR);
                cur_mon=Calendar.getInstance().get(Calendar.MONTH);
                cur_day=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

                Dialog date_picker=new DatePickerDialog(getActivity(),new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        text_date.setText(""+cur_year+"."+cur_mon+"."+ cur_day);
                    }
                },cur_year,cur_mon,cur_day);
                date_picker.show();
            }
        });
        Button add=(Button)cur_container.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject parseObject=new ParseObject("ValueUp_mentor");
                parseObject.put("mentor",String.valueOf(mentor.getText()));
                parseObject.put("title",String.valueOf(title.getText()));
                parseObject.put("job",String.valueOf(job.getText()));
                parseObject.put("detail",String.valueOf(venue.getText()));
                parseObject.put("detail",String.valueOf(detail.getText()));
                parseObject.put("year",cur_year);
                parseObject.put("month",cur_mon);
                parseObject.put("day",cur_day);

                parseObject.saveInBackground();
                Toast.makeText(getActivity().getApplicationContext(), "추가완료", Toast.LENGTH_SHORT).show();
            }
        });

        return cur_container;
    }
}
