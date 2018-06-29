package com.kingsley.quanmingtv;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.kingsley.quanmingtv.mvp.base.PureActivity;
import com.kingsley.quanmingtv.mvp.fragments.HomeFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends PureActivity {

    @BindView(R.id.rbHome)
    RadioButton rbHome;
    @BindView(R.id.rbLive)
    RadioButton rbLive;
    @BindView(R.id.rbFollw)
    RadioButton rbFollw;
    @BindView(R.id.rbMe)
    RadioButton rbMe;

    private boolean isExit;

    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isExit = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initUI() {
        showHomeFragment();
    }

    private void showHomeFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(fragmentTransaction);
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
            fragmentTransaction.add(R.id.fragmentContent, homeFragment);
        }
        commitShowFragment(fragmentTransaction, homeFragment);
    }

//    public void showLiveFragment(){
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        hideAllFragment(fragmentTransaction);
//        if(liveFragment == null){
//            liveFragment = LiveFragment.newInstance(getString(R.string.tab_live),null,true);
//            fragmentTransaction.add(com.king.tv.R.id.fragmentContent,liveFragment);
//        }
//        commitShowFragment(fragmentTransaction,liveFragment);
//    }

    public void commitShowFragment(FragmentTransaction fragmentTransaction, Fragment fragment) {
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }

    public void hideAllFragment(FragmentTransaction fragmentTransaction) {
        hideFragment(fragmentTransaction, homeFragment);
//        hideFragment(fragmentTransaction,liveFragment);
//        hideFragment(fragmentTransaction,followFragment);
//        hideFragment(fragmentTransaction,mineFragment);
    }

    private void hideFragment(FragmentTransaction fragmentTransaction, Fragment fragment) {
        if (fragment != null) {
            fragmentTransaction.hide(fragment);
        }
    }

    @Override
    public void onBackPressed() {
        if (!isExit) {
            isExit = true;
            EventBus.getDefault().post(isExit);
        } else {
            super.onBackPressed();
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventExit(Boolean isBool) {
        SystemClock.sleep(1000);
        isExit = false;
    }

    @OnClick({R.id.rbHome, R.id.rbLive, R.id.rbFollw, R.id.rbMe})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rbHome:
                showHomeFragment();
                break;
            case R.id.rbLive:
                //showLiveFragment();
                break;
            case R.id.rbFollw:
                //showFollowFragment();
                break;
            case R.id.rbMe:
                //showMineFragment();
                break;
        }
    }

}
