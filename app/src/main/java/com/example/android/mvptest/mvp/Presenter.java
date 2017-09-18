package com.example.android.mvptest.mvp;

import com.example.android.mvptest.FragmentController;

/**
 * Created by mher on 9/18/17.
 */

public class Presenter {

    ItemView view;

    FragmentController controller;

    public void subscribe(ItemView listener) {
        this.view = listener;
    }

    public void unSubscribe() {
        this.view = null;
    }

    public void registerController(FragmentController cntrl) {
        controller = cntrl;
    }

    public void unRegisterController() {
        controller = null;
    }

    public void controlFragment(boolean show) {
        if (show) {
            controller.showFragment();
        } else {
            controller.hideFragment();
        }
    }

    public void initView() {
        view.setText("Button in Fragment");
    }
}
