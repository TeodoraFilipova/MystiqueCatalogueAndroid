package com.example.mystiquecatalogue_android.views;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;

import butterknife.ButterKnife;


public class MainActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

}