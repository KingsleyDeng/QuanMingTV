package com.kingsley.quanmingtv.http;

import com.kingsley.quanmingtv.bean.AppStart;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Stephen on 2018/6/29.
 */

public interface APIService {

    /**
     * 获取App启动页信息
     * @return
     */
    @GET("json/page/app-data/info.json?v=3.0.1&os=1&ver=4")
    Observable<AppStart> getAppStartInfo();

}
