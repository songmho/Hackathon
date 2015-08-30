package com.team1.hackathon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.parse.ParseObject;

/**
 * Created by songmho on 15. 8. 22.
 */
public class MentorFragment extends Fragment implements View.OnClickListener {
    EditText mentor;
    EditText feild;
    EditText company;
    EditText email;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout cur_container=(FrameLayout)inflater.inflate(R.layout.fragment_mentor,container,false);

        mentor = (EditText)cur_container.findViewById(R.id.mentor);
        feild = (EditText)cur_container.findViewById(R.id.feild);
        company= (EditText)cur_container.findViewById(R.id.company);
        email=(EditText)cur_container.findViewById(R.id.email);
        Button add=(Button)cur_container.findViewById(R.id.add);
        add.setOnClickListener(this);

        return cur_container;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.add){
            ParseObject parseObject=new ParseObject("ValueUp_mentor");
            parseObject.put("mentor_name",String.valueOf(mentor.getText()));
            parseObject.put("mentor_feild",String.valueOf(feild.getText()));
            parseObject.put("company",String.valueOf(company.getText()));
            parseObject.put("email",String.valueOf(email.getText()));
            parseObject.saveInBackground();
           Toast.makeText(getActivity().getApplicationContext(),"추가완료",Toast.LENGTH_SHORT).show();
    }
    }
}
