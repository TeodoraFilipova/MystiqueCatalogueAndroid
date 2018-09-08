package com.example.mystiquecatalogue_android.views.contacts.map;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {
    private ContactsNavigator mContactsNavigator;


    @BindView(R.id.tv_contactinfo)
    TextView mContactInfoTextView;

    @BindView(R.id.tv_address)
    TextView mAddressTextView;

    @BindView(R.id.tv_phones)
    TextView mPhonesTextView;

    @BindView(R.id.img_map)
    ImageView mMapImageView;

    @BindView(R.id.btn_writemail)
    Button mWriteEmailButton;


    @Inject
    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        ButterKnife.bind(this, view);

        mWriteEmailButton.setOnClickListener(v -> mContactsNavigator.navigateToEmailActivity());

        return view;
    }

    public void setNavigator(ContactsNavigator contactsNavigator) {
        this.mContactsNavigator = contactsNavigator;
    }
}
