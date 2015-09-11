package com.team1.hackathon;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.parse.GetCallback;
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
    SwipeRefreshLayout swipelayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("팀 관리");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        swipelayout=(SwipeRefreshLayout)findViewById(R.id.swipelayout);
        swipelayout.setRefreshing(true);
        makinglist();
        swipelayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                makinglist();
            }
        });

    }

    private void makinglist() {
        items.clear();
        ParseQuery<ParseObject> query=ParseQuery.getQuery("Team");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                for (final ParseObject p : list) {
                    boolean ismade=p.getBoolean("ismade");
                    ParseUser parseUser=p.getParseUser("admin_member");
                    try {
                        Log.d("teet", p.getObjectId());
                        parseUser.fetchIfNeeded();
                        Team_item item = new Team_item(parseUser.getUsername(),p.getObjectId(),ismade);
                        items.add(item);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                }
                recyclerview.setAdapter(new RecyclerAdapter(getApplicationContext(), items, R.layout.item_team, 0));
            }
        });
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
        swipelayout.setRefreshing(false);
    }
}
