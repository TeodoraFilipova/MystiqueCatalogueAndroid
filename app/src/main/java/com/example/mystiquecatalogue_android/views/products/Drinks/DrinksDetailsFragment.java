package com.example.mystiquecatalogue_android.views.products.Drinks;


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
public class DrinksDetailsFragment extends Fragment {


    private String mDrinks;
    private TextView mDrinksDetailsTextView;

    public DrinksDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drinks_details, container, false);

        mDrinksDetailsTextView = view.findViewById(R.id.tv_drinksDetails);
        mDrinksDetailsTextView.setText(mDrinks);

        return view;
    }

    public static DrinksDetailsFragment newInstance() { return new DrinksDetailsFragment();
    }

    public void setDrinks(String drinks) {
       this.mDrinks = drinks;
       if (mDrinksDetailsTextView == null){
           return;
       }
       mDrinksDetailsTextView.setText(drinks);
    }
}
