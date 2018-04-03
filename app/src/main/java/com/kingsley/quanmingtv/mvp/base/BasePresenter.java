package com.kingsley.quanmingtv.mvp.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.kingsley.quanmingtv.App;

import javax.inject.Inject;

public class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    private App app;

    @Inject
    public BasePresenter(App app) {
        super();
        this.app = app;
    }

    public App getApp() {
        return getApp();
    }

    @Override
    public boolean isViewAttached() {
        return super.isViewAttached();
    }
}
