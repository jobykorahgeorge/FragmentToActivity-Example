package com.JKGAppsStudio.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.JKGAppsStudio.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by JOBY KORAH GEORGE on 11/6/2018.
 */
@SuppressLint("ValidFragment")
public class TestFragment extends Fragment {

    @BindView(R.id.textViewFragment)
    TextView tvFragment;
    @BindView(R.id.buttonFrame)
    Button buttonFrames;

    FrameCallback frameCallback;

    @SuppressLint("ValidFragment")
    public TestFragment(FrameCallback frameCallback) {
        this.frameCallback=frameCallback;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_item,container,false);
        ButterKnife.bind(this,view);
        buttonFrames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFragment.setText("");
            }
        });
        tvFragment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                frameCallback.onFrameCallbackSuccess(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }
}
