package com.JKGAppsStudio.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.JKGAppsStudio.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JOBY KORAH GEORGE on 11/6/2018.
 */
public class Main extends AppCompatActivity  implements FrameCallback {

    private Fragment fragment;
    private FragmentManager fragmentManager;
    @BindView(R.id.textMain)
    TextView textMain;
    @BindView(R.id.frame)
    FrameLayout frame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newo);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();

        if(!(fragment instanceof TestFragment)){
            fragment = new TestFragment(this);
            fragmentManager.beginTransaction().replace(R.id.frame,fragment).commit();
        }



    }

    @Override
    public void onFrameCallbackSuccess(CharSequence s) {
        textMain.setText(s);
    }
}
