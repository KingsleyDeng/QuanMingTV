package com.kingsley.quanmingtv.mvp.base;

import com.hannesdorfmann.mosby.mvp.MvpView;


public interface BaseView extends MvpView{


    void showProgress();

    void onCompleted();

    void onError(Throwable e);
}
