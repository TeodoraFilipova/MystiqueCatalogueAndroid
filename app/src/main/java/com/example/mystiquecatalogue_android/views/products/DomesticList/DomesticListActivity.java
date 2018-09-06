package com.example.mystiquecatalogue_android.views.products.DomesticList;

import android.content.Intent;
import android.os.Bundle;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;
import com.example.mystiquecatalogue_android.views.products.ProductDetails.ProductDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class DomesticListActivity extends BaseDrawerActivity
        implements DomesticListContracts.Navigator {

    public static final long IDENTIFIER = 543;

    @Inject
    DomesticListFragment mDomesticListFragment;

    @Inject
    DomesticListContracts.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domestic_list);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mDomesticListFragment.setNavigator(this);
        mDomesticListFragment.setPresenter(mPresenter);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, mDomesticListFragment)
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
