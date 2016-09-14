package com.xianwei.activity;

import android.annotation.TargetApi;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Build;
import android.view.Window;
import android.widget.RadioGroup;

import com.xianwei.fragment.MessagesFragment;

public class MainActivity extends Activity {
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity);

        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
            MessagesFragment details = new MessagesFragment();
            getFragmentManager().beginTransaction().add(R.id.content, details).commit();
        }

        fragmentManager = getFragmentManager();
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });
        radioGroup.check(R.id.rd_bt_message);
    }

}
