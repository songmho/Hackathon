package com.team1.hackathon;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songmho on 15. 9. 2.
 */
public class RecyclerAdapter extends RecyclerView.Adapter {
    Context context;
    List<Member_item> member_items;
    List<Team_item> team_items;
    int layout;

    public RecyclerAdapter(Context context, ArrayList<Member_item> member_items,int layout) {
        this.context=context;
        this.member_items=member_items;
        this.layout=layout;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(layout==R.layout.item_member)
          return member_items.size();
        return 0;
    }
}
