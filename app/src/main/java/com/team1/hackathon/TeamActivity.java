package com.team1.hackathon;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songmho on 15. 8. 30.
 */
public class TeamActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerview;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Team_item> items=new ArrayList<>();
    String name=new String();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("팀 관리");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);


        ParseQuery<ParseObject> query=ParseQuery.getQuery("Team");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                for (ParseObject p : list) {
                    final String[] n = {"\n"};
                    ParseRelation<ParseUser> relation = p.getRelation("member");
                    ParseQuery<ParseUser> q = relation.getQuery();
                    q.findInBackground(new FindCallback<ParseUser>() {
                        @Override
                        public void done(List<ParseUser> list, ParseException e) {
                            for (ParseUser p1 : list)
                                n[0] = n[0] +p1.getString("name")+"\n";
                            name=new String(n[0]);
                        }
                    });

                    Team_item item = new Team_item(name);
                    items.add(item);
                }
                Log.d("ddddddd",items.get(0).getName());
                recyclerview.setAdapter(new RecyclerAdapter(getApplicationContext(), items, R.layout.item_team, 0));
            }
        });
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
    }
}
