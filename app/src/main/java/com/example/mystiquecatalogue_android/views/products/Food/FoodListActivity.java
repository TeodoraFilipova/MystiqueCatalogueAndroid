package com.example.mystiquecatalogue_android.views.products.Food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.uiutils.Navigator;


public class FoodListActivity extends AppCompatActivity implements Navigator {

    private FoodListFragment mFoodListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        mFoodListFragment = FoodListFragment.newInstance();
        mFoodListFragment.setmNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFoodListFragment)
                .commit();

    }


    @Override
    public void navigateWith(String product) {
        Intent intent = new Intent(
                this,
                FoodDetailsActivity.class
        );

        intent.putExtra("PRUDUCT_NAME", product);
        startActivity(intent);
    }
}
