package com.example.mystiquecatalogue_android.views.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;


public class ContactsActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 4;

    private Button mButton;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        mToolbar = findViewById(R.id.drawer_toolbar);

        mButton = findViewById(R.id.btn_writemail);

        mButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                 Intent intent = new Intent(ContactsActivity.this,
                        EmailActivity.class);
                startActivity(intent);
            }
        });
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
