package com.example.mystiquecatalogue_android.views.contacts.email;

import android.content.Intent;
import android.os.Bundle;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;


public class EmailActivity extends BaseDrawerActivity implements EmailNavigator {
    private static final long IDENTIFIER = 9898;

    @Inject
    EmailFragment mEmailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        ButterKnife.bind(this);
        setSupportActionBar(getToolbar());

        mEmailFragment.setEmailNavigator(this);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, mEmailFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }


    @Override
    public void navigateToEmailApp(String sendTo, String subject, String message) {
        Intent email = new Intent(Intent.ACTION_SEND);

        email.putExtra(Intent.EXTRA_EMAIL, sendTo);
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        email.setType("massager/rfc822");

        startActivity(Intent.createChooser(email, "Choose app to send mail"));
    }
}
