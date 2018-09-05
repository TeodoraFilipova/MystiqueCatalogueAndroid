package com.example.mystiquecatalogue_android.views.products.ProductDetails;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailsFragment extends Fragment implements ProductDetailsContracts.View {
    private String mFood;
    private TextView mFoodDetailsTextView;

    private ProductDetailsContracts.Presenter mPresenter;

    @BindView(R.id.tv_details_name)
    TextView mDetailsNameTextView;

    @BindView(R.id.tv_details_category)
    TextView mDetailsCategoryTextView;

    @BindView(R.id.tv_details_type)
    TextView mDetailsTypeTextView;

    @BindView(R.id.tv_details_units)
    TextView mDetailsUnitsTextView;

    @BindView(R.id.tv_details_size)
    TextView mDetailsSizeTextView;

    @BindView(R.id.tv_details_number)
    TextView mDetailsNumberTextView;

    @BindView(R.id.iv_details_pic)
    ImageView mDetailsProductImageView;

    @Inject
    public ProductDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadProduct();
    }



    @Override
    public void showProduct(Product product) {
        mDetailsNameTextView.setText(product.getName());
        mDetailsCategoryTextView.setText(product.getCategory());
        mDetailsTypeTextView.setText(product.getType());
        mDetailsUnitsTextView.setText(product.getUnits());
        mDetailsSizeTextView.setText(product.getSize());
        mDetailsNumberTextView.setText(product.getNumber());

    }

    @Override
    public void setPresenter(ProductDetailsContracts.Presenter presenter) {
        mPresenter = presenter;

    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
