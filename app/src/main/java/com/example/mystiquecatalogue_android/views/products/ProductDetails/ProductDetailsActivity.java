package com.example.mystiquecatalogue_android.views.products.ProductDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;

import butterknife.ButterKnife;


public class ProductDetailsActivity extends BaseDrawerActivity {
    public static final String EXTRA_KEY = "PRODUCT_EXTRA_KEY";

    private TextView mView;
    private ProductDetailsFragment mProductDetailsFragment;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        mToolbar = findViewById(R.id.drawer_toolbar);

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra(ProductDetailsActivity.EXTRA_KEY);

        mProductDetailsFragment = ProductDetailsFragment.newInstance();

        ButterKnife.bind(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.context, mProductDetailsFragment)
                .commit();

    }

    @Override
    protected long getIdentifier() {
        return 0;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }
}
