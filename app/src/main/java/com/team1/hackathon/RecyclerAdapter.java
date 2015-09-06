package com.team1.hackathon;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songmho on 15. 9. 2.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Member_item> member_items;
    List<Team_item> team_items;
    int layout;
    int HOLDER=0;
    int FOOTER=1;

    public RecyclerAdapter(Context context, ArrayList<Member_item> member_items,int layout) {
        this.context=context;
        this.member_items=member_items;
        this.layout=layout;
    }

    public RecyclerAdapter(Context context, ArrayList<Team_item> team_items, int layout,int i) {
        this.context=context;
        this.team_items=team_items;
        this.layout=layout;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(layout==R.layout.item_member && viewType==HOLDER){
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member,parent,false);
            return new member(v);
        }
        else if(layout==R.layout.item_member && viewType==FOOTER){
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.footer,parent,false);
            return new footer(v);
        }
        else if(layout==R.layout.item_team && viewType==HOLDER){
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team,parent,false);
            return new team(v);
        }
        else if(layout==R.layout.item_team && viewType==FOOTER){
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_2,parent,false);
            return new footer(v);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(layout==R.layout.item_member && holder instanceof member){
            final Member_item item= member_items.get(position);
            ((member)holder).name.setText(item.getName());
            ((member)holder).job.setText(item.getJob());
            ((member)holder).phone.setText(item.getPhone());
            ((member)holder).cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,item.getName(),Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if(layout==R.layout.item_team && holder instanceof team){
            Team_item item=team_items.get(position);
            ((team) holder).member.setText(item.getName());
            Log.d("ddddddd",item.getName());
            ((team) holder).cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Toast.makeText(context,"dddddd",Toast.LENGTH_SHORT).show();
                }
            });
        }

        if(holder instanceof footer){

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(member_items!=null && position<member_items.size() && layout==R.layout.item_member)
            return HOLDER;

        else if(member_items!=null && position==member_items.size() && layout==R.layout.item_member)
            return FOOTER;

        else if(team_items!=null && position<team_items.size() && layout==R.layout.item_team)
            return HOLDER;

        else if(team_items!=null && position==team_items.size() && layout==R.layout.item_team)
            return FOOTER;
        return -1;
    }

    @Override
    public int getItemCount() {
        if(layout==R.layout.item_member)
          return member_items.size()+1;
        else if(layout==R.layout.item_team)
            return team_items.size()+1;
        return 0;
    }

    public class member extends RecyclerView.ViewHolder{
        TextView name;
        TextView job;
        TextView phone;
        CardView cardview;

        public member(View itemView) {
            super(itemView);
            cardview=(CardView)itemView.findViewById(R.id.cardview);
            name=(TextView)itemView.findViewById(R.id.name);
            job=(TextView)itemView.findViewById(R.id.job);
            phone=(TextView)itemView.findViewById(R.id.phone);
        }

    }
    public class team extends RecyclerView.ViewHolder{
        CardView cardview;
        TextView member;
        public team(View itemView) {
            super(itemView);
            member=(TextView)itemView.findViewById(R.id.member);
            cardview=(CardView)itemView.findViewById(R.id.cardview);
        }
    }

    public class footer extends RecyclerView.ViewHolder{

        public footer(View itemView) {
            super(itemView);
        }
    }
}
