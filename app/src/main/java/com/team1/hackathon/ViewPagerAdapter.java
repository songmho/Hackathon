package com.team1.hackathon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by songmho on 15. 8. 22.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    Fragment[] fragments=new Fragment[3];
    Bundle[] bundles=new Bundle[3];

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]=new ListFragment();
        bundles[0]=new Bundle();
        bundles[0].putInt("activity",0);
        bundles[0].putString("job", "기획자");
        fragments[0].setArguments(bundles[0]);

        fragments[1]=new ListFragment();
        bundles[1]=new Bundle();
        bundles[1].putInt("activity", 0);
        bundles[1].putString("job", "개발자");
        fragments[1].setArguments(bundles[1]);

        fragments[2]=new ListFragment();
        bundles[2]=new Bundle();
        bundles[2].putInt("activity",0);
        bundles[2].putString("job", "디자이너");
        fragments[2].setArguments(bundles[2]);

    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "기획자";
            case 1:
                return "개발자";
            case 2:
                return "디자이너";
        }
        return null;
    }
}
