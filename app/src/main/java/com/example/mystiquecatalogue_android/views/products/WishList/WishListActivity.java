package com.example.mystiquecatalogue_android.views.products.WishList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;
import com.example.mystiquecatalogue_android.views.products.ProductDetails.ProductDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class WishListActivity extends BaseDrawerActivity
        implements WishListContracts.Navigator {

    public static final long IDENTIFIER = 30;

    @Inject
    WishListFragment mWishListFragment;

    @Inject
    WishListContracts.Presenter mPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mWishListFragment.setNavigator(this);
        mWishListFragment.setPresenter(mPresenter);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, mWishListFragment)
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
