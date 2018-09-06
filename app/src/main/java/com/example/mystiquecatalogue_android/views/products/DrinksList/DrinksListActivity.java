package com.example.mystiquecatalogue_android.views.products.DrinksList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;
import com.example.mystiquecatalogue_android.views.products.ProductDetails.ProductDetailsActivity;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListContracts;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrinksListActivity extends BaseDrawerActivity
        implements DrinksListContracts.Navigator {

    public static final long IDENTIFIER = 45;

    @Inject
    DrinksListFragment mDrinksListFragment;

    @Inject
    DrinksListContracts.Presenter mPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_list);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mDrinksListFragment.setNavigator(this);
        mDrinksListFragment.setPresenter(mPresenter);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, mDrinksListFragment)
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
