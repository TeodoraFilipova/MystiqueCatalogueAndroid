package com.example.mystiquecatalogue_android.views.products.Domestics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.uiutils.Navigator;


public class DomesticListActivity extends AppCompatActivity implements Navigator {

    private DomesticListFragment mDomesticListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domestic_list);

        mDomesticListFragment = DomesticListFragment.newInstance();
        mDomesticListFragment.setmNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mDomesticListFragment)
                .commit();

    }


    @Override
    public void navigateWith(String product) {
        Intent intent = new Intent(
                this,
                DomesticDetailsActivity.class
        );

        intent.putExtra("PRUDUCT_NAME", product);
        startActivity(intent);
    }
}
