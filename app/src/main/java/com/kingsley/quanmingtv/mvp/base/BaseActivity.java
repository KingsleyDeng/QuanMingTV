package com.kingsley.quanmingtv.mvp.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

/**
 * Created by Stephen on 2018/4/3.
 */

public abstract class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getRootViewId());
        initUI();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    public <T> void  toSetList(List<T> list, List<T> newList, boolean isMore){

        if(list!=null && newList!=null){
            synchronized (BaseFragment.class){
                if(!isMore){
                    list.clear();
                }
                list.addAll(newList);
            }
        }
    }

    public abstract int getRootViewId();

    public abstract void initUI();

    public abstract void initData();
}
