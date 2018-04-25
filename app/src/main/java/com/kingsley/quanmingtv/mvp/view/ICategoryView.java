package com.kingsley.quanmingtv.mvp.view;

import com.kingsley.quanmingtv.bean.LiveCategory;
import com.kingsley.quanmingtv.mvp.base.BaseView;

import java.util.List;

/**
 * Created by Stephen on 2018/4/11.
 */

public interface ICategoryView extends BaseView{

    void onGetLiveCategory(List<LiveCategory> list);

}
