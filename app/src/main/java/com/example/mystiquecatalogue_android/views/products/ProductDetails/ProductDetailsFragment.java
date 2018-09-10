package com.example.mystiquecatalogue_android.views.products.ProductDetails;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductDetailsFragment extends Fragment implements ProductDetailsContracts.View {
    private ProductDetailsContracts.Presenter mPresenter;

    @BindView(R.id.tv_details_name)
    TextView mDetailsNameTextView;


    @BindView(R.id.tv_details_type)
    TextView mDetailsTypeTextView;

    @BindView(R.id.tv_details_units)
    TextView mDetailsUnitsTextView;

    @BindView(R.id.tv_details_size)
    TextView mDetailsSizeTextView;

    @BindView(R.id.tv_details_price)
    TextView mDetailsPriceTextView;

    @BindView(R.id.iv_detailspic)
    ImageView mDetailsProductImageView;

    @BindView(R.id.button_add_to_wish_list)
    Button mAddToWishListButton;

    @BindView(R.id.tv_already_in_wish_list)
    TextView mAlreadyInWishListTextView;

    @Inject
    public ProductDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_details, container, false);

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
        mDetailsTypeTextView.setText(product.getType());
        mDetailsUnitsTextView.setText(product.getUnits());
        mDetailsSizeTextView.setText(String.valueOf(product.getSize()));
        mDetailsPriceTextView.setText(String.valueOf(product.getPrice()));
        Picasso.get()
                .load(product.getImageUrl())
                .into(mDetailsProductImageView);

        showWishListStatus(product.getBought());
    }

    private void showWishListStatus(int boughtStatus) {
        if (boughtStatus == 0) {
            mAddToWishListButton.setOnClickListener(v -> {
                try {
                    mPresenter.updateProduct();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } else {
            mAddToWishListButton.setVisibility(View.GONE);
            mAlreadyInWishListTextView.setVisibility(View.VISIBLE);
        }
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

    @Override
    public void showAddedToWishList(Product product) {
        String message = "Product " + product.getName() + " added to Wish List!";
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG)
                .show();
    }
}
