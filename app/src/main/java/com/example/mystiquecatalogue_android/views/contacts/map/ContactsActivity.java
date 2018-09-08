package com.example.mystiquecatalogue_android.views.contacts.map;

import android.content.Intent;
import android.os.Bundle;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;
import com.example.mystiquecatalogue_android.views.contacts.email.EmailActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;


public class ContactsActivity extends BaseDrawerActivity implements ContactsNavigator {
    public static final long IDENTIFIER = 4;

    @Inject
    ContactsFragment mContactsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ButterKnife.bind(this);
        setSupportActionBar(getToolbar());

        mContactsFragment.setNavigator(this);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, mContactsFragment)
                .commit();

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToEmailActivity() {
        Intent intent = new Intent(this, EmailActivity.class);
        startActivity(intent);
    }
}
