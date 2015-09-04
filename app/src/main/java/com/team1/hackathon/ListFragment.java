package com.team1.hackathon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by songmho on 15. 9. 1.
 */
public class ListFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Member_item> member_items=new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout cur_container=(LinearLayout)inflater.inflate(R.layout.fragment_list,container,false);

        recyclerView=(RecyclerView)cur_container.findViewById(R.id.recyclerview);
        Bundle bundle=this.getArguments();
        switch (bundle.getInt("activity")){
            case 0:
                Member_item member_item=new Member_item("","");
                member_items.add(member_item);
                recyclerView.setAdapter(new RecyclerAdapter(getActivity(),member_items,R.layout.item_member));
                break;
            case 1:
                break;
        }
     //   recyclerView.setAdapter();
        layoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        return cur_container;
    }
}
