package com.example.mystiquecatalogue_android.views.products.Drinks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.uiutils.Navigator;


public class DrinksListActivity extends AppCompatActivity implements Navigator {

    private DrinksListFragment mDrinksListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_list);

        mDrinksListFragment = DrinksListFragment.newInstance();
        mDrinksListFragment.setmNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mDrinksListFragment)
                .commit();

    }


    @Override
    public void navigateWith(String product) {
        Intent intent = new Intent(
                this,
                DrinksDetailsActivity.class
        );

        intent.putExtra("PRUDUCT_NAME", product);
        startActivity(intent);
    }
}
