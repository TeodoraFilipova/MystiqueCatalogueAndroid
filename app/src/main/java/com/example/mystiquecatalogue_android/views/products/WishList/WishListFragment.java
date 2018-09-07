package com.example.mystiquecatalogue_android.views.products.WishList;


import android.app.Fragment;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishListFragment extends Fragment implements WishListContracts.View,
        WishAdapter.OnWishClickListener {

    private WishListContracts.Navigator mNavigator;

    @BindView(R.id.loading_bar)
    ProgressBar mLoadingBar;

    @BindView(R.id.et_filter_search)
    EditText mEditSearchText;

    @BindView(R.id.lv_drinks)
    RecyclerView mWishView;

    @Inject
    WishAdapter mWishAdapter;

    private WishListContracts.Presenter mPresenter;
    private GridLayoutManager mProductsViewLayoutManager;

    @Inject
    public WishListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wish_list, container, false);

        ButterKnife.bind(this, view);

        mWishAdapter.setOnWishClickListener(this);
        mWishView.setAdapter(mWishAdapter);

        mProductsViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mWishView.setLayoutManager(mProductsViewLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadProducts();
    }

    public void setNavigator(WishListContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void setPresenter(WishListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProducts(List<Product> products) {
        mWishAdapter.clear();
        mWishAdapter.addAll(products);
        mWishAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyProductsList() {
        mWishAdapter.clear();
        mWishAdapter.notifyDataSetChanged();
        Toast.makeText(getContext(),"No products added to the Wish List yet!", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mWishView.setVisibility(View.GONE);
        mLoadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mWishView.setVisibility(View.VISIBLE);
        mLoadingBar.setVisibility(View.GONE);
    }

    @Override
    public void showProductsDetails(Product product) {
        mNavigator.navigateWith(product);
    }

    @Override
    public void onClick(Product wishproduct) {
        mPresenter.selectProduct(wishproduct);
    }

/*    @OnTextChanged(R.id.et_filter_search)
    public void onTextChanged() {
        String pattern = mEditSearchText.getText().toString();
        mPresenter.filterProducts(pattern);
    }*/
}
