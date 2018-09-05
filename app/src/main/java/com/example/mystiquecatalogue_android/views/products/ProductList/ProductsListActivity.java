package com.example.mystiquecatalogue_android.views.products.ProductList;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;


public class ProductsListActivity extends BaseDrawerActivity implements ProductsListContracts.Navigator {

    public static final long IDENTIFIER = 2;

    private Toolbar mToolbar;
    private ProductsListFragment mProductsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        mToolbar = findViewById(R.id.drawer_toolbar);

        mProductsListFragment = ProductsListFragment.newInstance();
        mProductsListFragment.setNavigator(this);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, mProductsListFragment)
                .commit();

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }

    @Override
    public void navigateWith(Product product) {
        //TODO implement
    }
}
