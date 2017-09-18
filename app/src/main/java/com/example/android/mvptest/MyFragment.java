package com.example.android.mvptest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.mvptest.mvp.ItemView;
import com.example.android.mvptest.mvp.Presenter;

/**
 * Created by mher on 9/18/17.
 */

public class MyFragment extends Fragment implements ItemView {

    Presenter presenter;

    Button btn;

    public MyFragment() {
        presenter = new Presenter();
        presenter.subscribe(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter.registerController((FragmentController) context);
    }

    public void reload() {
        presenter = new Presenter();
        presenter.subscribe(this);
        presenter.initView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        btn = (Button) view.findViewById(R.id.btn_fragment);
        presenter.initView();
        return view;
    }

    @Override
    public void setText(String text) {
        if (btn != null) {
            btn.setText(text);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter = null;
    }
}
