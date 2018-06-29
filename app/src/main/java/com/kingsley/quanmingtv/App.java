package com.kingsley.quanmingtv;

import android.app.Application;
import android.content.Context;

import com.kingsley.quanmingtv.bean.DaoMaster;
import com.kingsley.quanmingtv.bean.DaoSession;
import com.kingsley.quanmingtv.di.component.AppComponent;

public class App extends Application {

    private DaoMaster.DevOpenHelper mHelper;

    private DaoSession mDaoSession;

    private AppComponent mAppComponent;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);


    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDatabase();

    }

    public void initDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "tv-db", null);
        DaoMaster daoMaster = new DaoMaster(mHelper.getWritableDatabase());
        mDaoSession = daoMaster.newSession();
    }

    public AppComponent getAppCommponent() {
        return mAppComponent;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

}
