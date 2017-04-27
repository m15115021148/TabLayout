package com.geek.viewpagerfragmentdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geek.viewpagerfragmentdemo.fragment.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<BaseFragment> mFragment;
    private String[] mName = {"首页","联系人","动态"};
    private int[] mRes = {R.drawable.home_bg,R.drawable.person_bg,R.drawable.userself_bg};

    public MyFragmentAdapter(FragmentManager fm,List<BaseFragment> fragment,Context context) {
        super(fm);
        this.mFragment = fragment;
        this.mContext = context;
    }

    public View getView(int pos){
        View view = LayoutInflater.from(mContext).inflate(R.layout.tablayout_layout_item,null);
        TextView name = (TextView) view.findViewById(R.id.name);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        name.setText(mName[pos]);
        img.setImageResource(mRes[pos]);
        return view;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mName.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mName[position];
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
