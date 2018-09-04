package com.example.mystiquecatalogue_android.views.products.Food;


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
public class FoodDetailsFragment extends Fragment {


    private String mFood;
    private TextView mFoodDetailsTextView;

    public FoodDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_details, container, false);

        mFoodDetailsTextView = view.findViewById(R.id.tv_foodDetails);
        mFoodDetailsTextView.setText(mFood);

        return view;
    }

    public static FoodDetailsFragment newInstance() { return new FoodDetailsFragment();
    }

    public void setFood(String food) {
        this.mFood = food;
        if (mFoodDetailsTextView == null){
            return;
        }
        mFoodDetailsTextView.setText(food);
    }

}
