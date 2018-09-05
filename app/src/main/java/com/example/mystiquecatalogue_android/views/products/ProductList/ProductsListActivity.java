package com.example.mystiquecatalogue_android.views.products.ProductList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;
import com.example.mystiquecatalogue_android.views.products.ProductDetails.ProductDetailsActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductsListActivity extends BaseDrawerActivity
        implements ProductsListContracts.Navigator {

    public static final long IDENTIFIER = 2;

    @Inject
    ProductsListFragment mProductsListFragment;

    @Inject
    ProductsListContracts.Presenter mPresenter;

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mProductsListFragment.setNavigator(this);
        mProductsListFragment.setPresenter(mPresenter);

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
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra(ProductDetailsActivity.EXTRA_KEY, product);
        startActivity(intent);
    }
}
