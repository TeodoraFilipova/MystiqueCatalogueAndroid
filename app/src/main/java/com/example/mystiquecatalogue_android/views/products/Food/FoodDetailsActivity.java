package com.example.mystiquecatalogue_android.views.products.Food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;


public class FoodDetailsActivity extends AppCompatActivity {

    private TextView mView;
    private FoodDetailsFragment mFoodDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        Intent intent = getIntent();

        String product = intent.getStringExtra("PRUDUCT_NAME");

        mFoodDetailsFragment = FoodDetailsFragment.newInstance();
        mFoodDetailsFragment.setFood(product);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.context, mFoodDetailsFragment)
                .commit();

    }
}
