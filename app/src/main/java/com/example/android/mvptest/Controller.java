package com.example.android.mvptest;

import android.support.v4.app.FragmentManager;

/**
 * Created by mher on 9/18/17.
 */

public class Controller implements FragmentController {


    FragmentManager mFragmentManager;

    public Controller(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    @Override
    public void showFragment() {
        MyFragment frg = (MyFragment) mFragmentManager.findFragmentById(R.id.fragment_container);
        if (frg != null) {
            frg.reload();
        } else {
            frg = new MyFragment();
            mFragmentManager.beginTransaction().replace(R.id.fragment_container, frg)
                    .addToBackStack(MyFragment.class.getSimpleName())
                    .commit();
        }
    }

    @Override
    public void hideFragment() {
        MyFragment frg = (MyFragment) mFragmentManager.findFragmentById(R.id.fragment_container);
        if (frg != null) {
            mFragmentManager.beginTransaction().remove(frg).commit();
            mFragmentManager.popBackStackImmediate();
        }
    }
}
