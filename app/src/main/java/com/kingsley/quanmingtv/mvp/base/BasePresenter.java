package com.kingsley.quanmingtv.mvp.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.kingsley.quanmingtv.App;
import com.kingsley.quanmingtv.bean.DaoSession;
import com.kingsley.quanmingtv.di.component.AppComponent;

import javax.inject.Inject;

public class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    private App app;

    private DaoSession mDaoSession;

    private AppComponent mAppComponent;

    @Inject
    public BasePresenter(App app) {
        super();
        this.app = app;
        mDaoSession = app.getDaoSession();
        mAppComponent = app.getAppCommponent();
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    public DaoSession getmDaoSession(){
        return mDaoSession;
    }

    public App getApp() {
        return getApp();
    }

    @Override
    public boolean isViewAttached() {
        return super.isViewAttached();
    }
}
