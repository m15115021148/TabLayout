package com.geek.viewpagerfragmentdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.geek.viewpagerfragmentdemo.fragment.BaseFragment;
import com.geek.viewpagerfragmentdemo.fragment.Fragment1;
import com.geek.viewpagerfragmentdemo.fragment.Fragment2;
import com.geek.viewpagerfragmentdemo.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private MainActivity mContext;
    private ViewPager mVp;
    private TabLayout mTabLayout;
    private List<BaseFragment> mFragment = new ArrayList<>();
    private MyFragmentAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mVp = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        initTabLayout();
    }

    private void initTabLayout(){
        mFragment.clear();
        mTabLayout.removeAllTabs();
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式

        mFragment.add(new Fragment1());
        mFragment.add(new Fragment2());
        mFragment.add(new Fragment3());
        mAdapter = new MyFragmentAdapter(getSupportFragmentManager(),mFragment,mContext);
        mVp.setAdapter(mAdapter);
        mVp.setOffscreenPageLimit(2);
        //绑定ViewPager
        mTabLayout.setupWithViewPager(mVp);
        mVp.setCurrentItem(0);

        for (int i=0;i<mTabLayout.getTabCount();i++){
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab!=null){
                View v = mAdapter.getView(i);
                if (i==0){//默认第一个选中
                    v.setSelected(true);
                }
                tab.setCustomView(v);
            }
        }
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
