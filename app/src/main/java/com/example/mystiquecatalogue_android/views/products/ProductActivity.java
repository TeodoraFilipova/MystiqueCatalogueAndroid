package com.example.mystiquecatalogue_android.views.products;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;
import com.example.mystiquecatalogue_android.views.products.Domestics.DomesticListActivity;
import com.example.mystiquecatalogue_android.views.products.Drinks.DrinksListActivity;
import com.example.mystiquecatalogue_android.views.products.Food.FoodListActivity;


public class ProductActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 2;

    private Toolbar mToolbar;
    private Button mDrinksButton;
    private Button mFoodButton;
    private Button mDomesticsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mToolbar = findViewById(R.id.drawer_toolbar);

       findViewById(R.id.btn_drinks).setOnClickListener(view ->{
            Intent intent = new Intent(this, DrinksListActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_food).setOnClickListener(view ->{
            Intent intent = new Intent(this, FoodListActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_domestics).setOnClickListener(view ->{
            Intent intent = new Intent(this, DomesticListActivity.class);
            startActivity(intent);
        });


    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }

}
