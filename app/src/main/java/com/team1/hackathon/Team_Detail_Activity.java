package com.team1.hackathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songmho on 15. 9. 11.
 */
public class Team_Detail_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerview;
    RecyclerView.LayoutManager layoutManager;
    Button button;

    ArrayList<TeamMember_item> items=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("팀 수락");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        final ParseQuery<ParseObject> parseQuery=ParseQuery.getQuery("Team");
        parseQuery.whereEqualTo("objectId", getIntent().getStringExtra("objId"));
        parseQuery.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                ParseRelation<ParseUser> p = parseObject.getRelation("member");
                ParseQuery<ParseUser> query = p.getQuery();
                query.findInBackground(new FindCallback<ParseUser>() {
                    @Override
                    public void done(List<ParseUser> list, ParseException e) {
                        if (list.size() == 0 || list == null) {
                            Toast.makeText(getApplicationContext(),"명단이 잘못됬습니다.",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        for (ParseUser u : list) {
                            Log.d("dfdf", u.getUsername());
                            TeamMember_item item = new TeamMember_item(u.getUsername());
                            items.add(item);
                        }
                        Log.d("dfdf", items.get(0).getName());
                        recyclerview.setAdapter(new MemberRecyclerAdapter(getApplicationContext(), items));
                    }
                });
            }
        });

        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> parseQuery1 = ParseQuery.getQuery("Team");
                parseQuery1.whereEqualTo("objectId", getIntent().getStringExtra("objId"));
                parseQuery1.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> list, ParseException e) {
                        list.get(0).put("ismade", true);
                        list.get(0).saveInBackground();
                        Toast.makeText(getApplicationContext(), "팀빌딩이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
