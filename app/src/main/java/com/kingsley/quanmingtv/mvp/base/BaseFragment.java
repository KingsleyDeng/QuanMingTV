package com.kingsley.quanmingtv.mvp.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.kingsley.quanmingtv.App;
import com.kingsley.quanmingtv.Constants;
import com.kingsley.quanmingtv.mvp.activity.ContentActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Stephen on 2018/4/3.
 */

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends MvpFragment<V, P> {

    protected Context context;

    private View rootView;

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context = getActivity();
        rootView = inflater.inflate(getRootViewId(), container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        initUI();
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null)
            mUnbinder.unbind();
    }

    public View getRootView() {
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public void replaceFragment(@IdRes int id, Fragment fragment) {
        getFragmentManager().beginTransaction().replace(id, fragment).commit();
    }

    public void replaceChildFragment(@IdRes int id, Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(id, fragment).commit();
    }

    public App getApp() {
        return (App) getActivity().getApplication();
    }

    public <T> void toSetList(List<T> list, List<T> newList, boolean isMore) {

        if (list != null && newList != null) {
            synchronized (BaseFragment.class) {
                if (!isMore) {
                    list.clear();
                }
                list.addAll(newList);
            }
        }
    }

    public static void registerEvent(Object obj) {
        EventBus.getDefault().register(obj);
    }

    public static void unregisterEvent(Object obj) {
        EventBus.getDefault().unregister(obj);
    }

    public static void sendEvent(Object obj) {
        EventBus.getDefault().post(obj);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(Object obj) {

    }

    protected Intent getIntent(){
        return getActivity().getIntent();
    }

    protected Intent getFragmentIntent(int fragmentKey){
        Intent intent = getContentActivityIntent();
        intent.putExtra(Constants.KEY_FRAGMENT,fragmentKey);
        return intent;
    }

    protected Intent getContentActivityIntent(){
        return new Intent(context, ContentActivity.class);
    }

    protected void startActivity(Class<?> cls){
        startActivity(new Intent(context,cls));
    }

    protected void finish(){
        getActivity().finish();
    }

    public abstract void initUI();

    public abstract int getRootViewId();

    public abstract void initData();

}
