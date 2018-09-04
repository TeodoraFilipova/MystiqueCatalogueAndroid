package com.example.mystiquecatalogue_android.views.products.Domestics;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DomesticDetailsFragment extends Fragment {


    private String mDomestic;
    private TextView mDomesticDetailsTextView;

    public DomesticDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_domestic_details, container, false);

        mDomesticDetailsTextView = view.findViewById(R.id.tv_domesticDetails);
        mDomesticDetailsTextView.setText(mDomestic);

        return view;
    }

    public static DomesticDetailsFragment newInstance() { return new DomesticDetailsFragment();
    }

    public void setDomestic(String domestics) {
        this.mDomestic = domestics;
        if (mDomesticDetailsTextView == null){
            return;
        }
        mDomesticDetailsTextView.setText(domestics);
    }
}
