package com.example.mystiquecatalogue_android.views.contacts.email;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmailFragment extends Fragment {
    private EmailNavigator mEmailNavigator;

    @BindView(R.id.tv_writeemail)
    TextView mWriteEmailTextView;

    @BindView(R.id.tv_mails)
    TextView mListOfEmailsTextView;

    @BindView(R.id.sendTo)
    EditText mSendToEditText;

    @BindView(R.id.subject)
    EditText mSubjectEditText;

    @BindView(R.id.messageText)
    EditText mMessageTextEditText;

    @BindView(R.id.btn_sendMail)
    Button mSendEmailButton;


    @Inject
    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        ButterKnife.bind(this, view);

        mSendEmailButton.setOnClickListener(v -> {
            String sendTo = mSendToEditText.getText().toString();
            String subject = mSubjectEditText.getText().toString();
            String message = mMessageTextEditText.getText().toString();

            mEmailNavigator.navigateToEmailApp(sendTo, subject, message);
        });

        return view;
    }

    public void setEmailNavigator(EmailNavigator emailNavigator) {
        this.mEmailNavigator = emailNavigator;
    }
}
