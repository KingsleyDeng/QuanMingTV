package com.kingsley.quanmingtv.mvp.presenter;

import com.kingsley.quanmingtv.App;
import com.kingsley.quanmingtv.mvp.base.BasePresenter;
import com.kingsley.quanmingtv.mvp.view.ICategoryView;

/**
 * Created by Stephen on 2018/4/11.
 */

public class CategoryPresenter extends BasePresenter<ICategoryView> {

    public CategoryPresenter(App app) {
        super(app);
    }

    public void getAllCategories(){
        getView().showProgress();


    }

}
