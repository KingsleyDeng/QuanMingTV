package com.kingsley.quanmingtv.di.component;

import android.content.Context;

import com.kingsley.quanmingtv.App;
import com.kingsley.quanmingtv.di.module.AppModule;
import com.kingsley.quanmingtv.http.APIService;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Stephen on 2018/6/29.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(App app);

    Context getContext();

    Retrofit getRetrofit();

    OkHttpClient getOkHttpClient();

    APIService getAPIService();

}
