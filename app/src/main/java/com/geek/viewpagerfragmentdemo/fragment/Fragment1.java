package com.geek.viewpagerfragmentdemo.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.geek.viewpagerfragmentdemo.R;

/**
 * Created by Administrator on 2017/4/27.
 */

public class Fragment1 extends BaseFragment {
    private View view;
    private TextView name;
    private String TAG = Fragment1.class.getName();

    @Override
    protected int setContentView() {
        return R.layout.fragment_item_1;
    }

    @Override
    protected void initData() {
        if (view == null){
            view = getContentView();
        }
        name = (TextView) view.findViewById(R.id.name);
    }

    @Override
    protected void startLoad() {
        name.setText("TAG:"+TAG);
        Log.e("result","start:"+TAG);
    }

    @Override
    protected void stopLoad() {
        Log.i("result","stop:"+TAG);
    }


}
