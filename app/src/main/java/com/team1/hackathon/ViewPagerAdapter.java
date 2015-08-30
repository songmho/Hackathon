package com.team1.hackathon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by songmho on 15. 8. 22.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    Fragment[] fragments=new Fragment[3];

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]=new Team_fragment();

        fragments[1]=new MentorFragment();

        fragments[2]=new MentoringFragment();
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
                return "팀 승인";
            case 1:
                return "멘토 추가";
            case 2:
                return "멘토링 추가";
        }
        return null;
    }
}
