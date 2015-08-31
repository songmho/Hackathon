package com.team1.hackathon;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    LinearLayout time;
    LinearLayout team;
    LinearLayout member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("모아_관리자");
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        navigationView=(NavigationView)findViewById(R.id.navigationView);
        time=(LinearLayout)findViewById(R.id.time);
        team=(LinearLayout)findViewById(R.id.team);
        member=(LinearLayout)findViewById(R.id.member);

        toolbar.setNavigationIcon(R.drawable.drawericon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                return selectDrawerItem(menuItem);
            }
        });

        time.setOnClickListener(this);
        team.setOnClickListener(this);
        member.setOnClickListener(this);
    }

    private boolean selectDrawerItem(MenuItem menuItem) {
        if(menuItem.getGroupId()== R.id.group_valueup){
            navigationView.getMenu().setGroupCheckable(R.id.group_mentoring,false,true);
            navigationView.getMenu().setGroupCheckable(R.id.group_valueup,true,true);
            navigationView.getMenu().setGroupCheckable(R.id.group_setting,false,true);
        }
        else if(menuItem.getGroupId()==R.id.group_mentoring){
            navigationView.getMenu().setGroupCheckable(R.id.group_mentoring,true,true);
            navigationView.getMenu().setGroupCheckable(R.id.group_valueup,false,true);
            navigationView.getMenu().setGroupCheckable(R.id.group_setting,false,true);
        }
        else{
            navigationView.getMenu().setGroupCheckable(R.id.group_mentoring,false,true);
            navigationView.getMenu().setGroupCheckable(R.id.group_valueup,false,true);
            navigationView.getMenu().setGroupCheckable(R.id.group_setting,true,true);
        }
        menuItem.setChecked(true);
        switch (menuItem.getItemId()){
            case R.id.time:
                drawerLayout.closeDrawers();
                startActivity(new Intent(MainActivity.this, TimeActivity.class));
                return  true;
            case R.id.team:
                drawerLayout.closeDrawers();
                startActivity(new Intent(MainActivity.this, TeamActivity.class));
                return true;
            case R.id.member:
                drawerLayout.closeDrawers();
                startActivity(new Intent(MainActivity.this, MemberActivity.class));
                return true;
            case R.id.mentoring:
                drawerLayout.closeDrawers();
                startActivity(new Intent(MainActivity.this, MentoringActivity.class));
                return true;
            case R.id.setting:
                drawerLayout.closeDrawers();
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                return true;
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (drawerLayout.isDrawerOpen(navigationView))
                    drawerLayout.closeDrawers();
                else {
                    moveTaskToBack(true);
                    finish();
                }
                break;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.time:
                startActivity(new Intent(MainActivity.this, TimeActivity.class));
                break;
            case R.id.team:
                startActivity(new Intent(MainActivity.this, TeamActivity.class));
                break;
            case R.id.member:
                startActivity(new Intent(MainActivity.this, MemberActivity.class));
                break;
        }
    }
}
