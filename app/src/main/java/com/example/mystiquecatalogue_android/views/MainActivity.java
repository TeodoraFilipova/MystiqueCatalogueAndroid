package com.example.mystiquecatalogue_android.views;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;


public class MainActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 1;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.drawer_toolbar);
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }
}