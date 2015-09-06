package com.team1.hackathon;

import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by songmho on 2015-09-01.
 */
public class MemberActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("참가자 관리");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);


        ParseQuery<ParseUser> user=ParseUser.getQuery();
        user.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> list, ParseException e) {
                ArrayList<Member_item> member_items = new ArrayList<>();
                for (ParseUser u : list) {
                    Member_item member_item = null;
                    switch (u.getString("job")){
                        case "plan":
                            member_item = new Member_item(u.getString("name"),"기획자" , u.getString("phone"));
                            break;
                        case "dev":
                            member_item = new Member_item(u.getString("name"),"개발자" , u.getString("phone"));
                            break;
                        case "dis":
                            member_item = new Member_item(u.getString("name"), "디자이너", u.getString("phone"));
                            break;
                    }
                    member_items.add(member_item);
                }
                recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(), member_items, R.layout.item_member));
            }
        });


        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem searchItem=menu.findItem(R.id.action_search);
        SearchManager searchManager=(SearchManager)MemberActivity.this.getSystemService(SEARCH_SERVICE);
        SearchView searchView=null;
        if(searchItem !=null){
            searchView=(SearchView)searchItem.getActionView();
        }
        if(searchView!=null){
            searchView.clearFocus();
            searchView.setQueryHint("이름 검색");
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
            searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                @Override
                public boolean onClose() {
                    return false;
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_search)
            return true;
        return super.onOptionsItemSelected(item);
    }
}
