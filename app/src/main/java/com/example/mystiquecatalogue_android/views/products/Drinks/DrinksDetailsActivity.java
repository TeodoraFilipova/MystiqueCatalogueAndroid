package com.example.mystiquecatalogue_android.views.products.Drinks;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;


public class DrinksDetailsActivity extends AppCompatActivity {

    private TextView mView;
    private DrinksDetailsFragment mDrinksDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_details);

        Intent intent = getIntent();

        String product = intent.getStringExtra("PRUDUCT_NAME");

        mDrinksDetailsFragment = DrinksDetailsFragment.newInstance();
        mDrinksDetailsFragment.setDrinks(product);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.context, mDrinksDetailsFragment)
                .commit();

    }
}
