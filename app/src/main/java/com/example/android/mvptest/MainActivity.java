package com.example.android.mvptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentController {

    Button btnShow, btnHide, btnSendBrdShow, btnSendBrdHide;
    Controller mController;
    FrameLayout mFrameLayout;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mController = new Controller(getSupportFragmentManager());
        btnShow = (Button) findViewById(R.id.btn_show_frg);
        btnShow.setOnClickListener(this);
        btnHide = (Button) findViewById(R.id.btn_hide_frg);
        btnHide.setOnClickListener(this);
        btnSendBrdShow = (Button) findViewById(R.id.btn_send_broadcast_show_frg);
        btnSendBrdShow.setOnClickListener(this);
        btnSendBrdHide = (Button) findViewById(R.id.btn_send_broadcast_hide_frg);
        btnSendBrdHide.setOnClickListener(this);
        mFrameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        initFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_frg:
                if (myFragment != null) {
                    myFragment.presenter.controlFragment(true);
                }
                break;
            case R.id.btn_hide_frg:
                if (myFragment != null) {
                    myFragment.presenter.controlFragment(false);
                }
                break;
        }
    }

    private void initFragment() {
        myFragment = new MyFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, myFragment)
                .commitNow();
        mFrameLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showFragment() {
        mFrameLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFragment() {
        mFrameLayout.setVisibility(View.INVISIBLE);
    }
}
