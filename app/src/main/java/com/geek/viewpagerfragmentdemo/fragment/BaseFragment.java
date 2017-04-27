package com.geek.viewpagerfragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment 基类
 */
public abstract class BaseFragment extends Fragment{
    protected boolean isInit = false;//视图是否已经初初始化
    protected boolean isLoad = false;//是否加载
    protected final String TAG = "BaseFragment";
    private View view;//视图

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(setContentView(), container, false);
        isInit = true;
        initData();
        /**初始化的时候去加载数据**/
        isCanLoadData();
        return view;
    }

    /**
     * 视图是否可见
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    /**
     * 是否可以加载数据
     */
    private void isCanLoadData() {
        if (!isInit) {
            return;
        }
        if (getUserVisibleHint()) {
            startLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }

    protected View getContentView() {
        return view;
    }

    /**
     * findViewById
     */
    protected <T extends View> T findViewById(int id) {
        return (T) getContentView().findViewById(id);
    }

    protected abstract int setContentView();//显示的布局

    protected abstract void startLoad();//加载数据

    protected abstract void initData();//初始化数据

    /**
     * 当视图不可见并且加载过数据,调用此方法
     */
    protected void stopLoad() {}

}
