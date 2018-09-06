package com.example.mystiquecatalogue_android.views.products.FoodList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;
import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListContracts;
import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListFragment;
import com.example.mystiquecatalogue_android.views.products.ProductDetails.ProductDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class FoodListActivity extends BaseDrawerActivity
        implements FoodListContracts.Navigator {

    public static final long IDENTIFIER = 46;

    @Inject
    FoodListFragment mFoodListFragment;

    @Inject
    FoodListContracts.Presenter mPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mFoodListFragment.setNavigator(this);
        mFoodListFragment.setPresenter(mPresenter);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, mFoodListFragment)
                .commit();

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(Product product) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra(ProductDetailsActivity.EXTRA_KEY, product);
        startActivity(intent);
    }
}
