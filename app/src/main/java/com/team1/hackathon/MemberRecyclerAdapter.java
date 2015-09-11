package com.team1.hackathon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songmho on 15. 9. 11.
 */
public class MemberRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<TeamMember_item> items;
    public MemberRecyclerAdapter(Context context, ArrayList<TeamMember_item> items) {
        this.context=context;
        this.items=items;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_member,parent,false);
        return new member(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final TeamMember_item item= items.get(position);
        ((member)holder).name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class member extends RecyclerView.ViewHolder {
        TextView name;
        public member(View v) {
            super(v);
            name=(TextView)itemView.findViewById(R.id.member);
        }
    }
}
