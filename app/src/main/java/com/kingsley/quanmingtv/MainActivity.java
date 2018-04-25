package com.kingsley.quanmingtv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

import com.kingsley.quanmingtv.mvp.base.PureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
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

    }

    @Override
    public void onBackPressed() {

    }
}
