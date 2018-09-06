package com.example.mystiquecatalogue_android.views.products.ProductDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductDetailsActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 3;
    public static final String EXTRA_KEY = "PRODUCT_EXTRA_KEY";

    @Inject
    ProductDetailsFragment mProductDetailsFragment;

    @Inject
    ProductDetailsContracts.Presenter mProductDetailsPresenter;


    private TextView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra(ProductDetailsActivity.EXTRA_KEY);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mProductDetailsPresenter.setProductId(product.getId());
        mProductDetailsFragment.setPresenter(mProductDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.context, mProductDetailsFragment)
                .commit();

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }


}
