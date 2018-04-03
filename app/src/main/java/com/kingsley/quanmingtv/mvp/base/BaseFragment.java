package com.kingsley.quanmingtv.mvp.base;

import com.hannesdorfmann.mosby.mvp.MvpFragment;

/**
 * Created by Stephen on 2018/4/3.
 */

public abstract class BaseFragment <V extends BaseView, P extends BasePresenter<V>>  extends MvpFragment<V,P> {

}
