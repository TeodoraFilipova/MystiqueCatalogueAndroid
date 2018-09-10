package com.example.mystiquecatalogue_android.views.products.ProductList;


import android.app.Fragment;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;


public class ProductsListFragment extends Fragment implements ProductsListContracts.View,
        ProductsAdapter.OnProductClickListener {
    private ProductsListContracts.Navigator mNavigator;

    @BindView(R.id.loading_bar)
    ProgressBar mLoadingBar;

    @BindView(R.id.et_filter_search)
    EditText mSearchFilterText;

    @BindView(R.id.lv_products)
    RecyclerView mProductsListView;

    @Inject
    ProductsAdapter mProductsAdapter;

    private ProductsListContracts.Presenter mPresenter;
    private GridLayoutManager mProductsViewLayoutManager;

    @Inject
    public ProductsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_products_list, container, false);

        ButterKnife.bind(this, view);

        mProductsAdapter.setOnProductClickListener(this);
        mProductsListView.setAdapter(mProductsAdapter);

        mProductsViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mProductsListView.setLayoutManager(mProductsViewLayoutManager);

        return view;
    }

    void setNavigator(ProductsListContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadProducts();
    }

    @Override
    public void setPresenter(ProductsListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProducts(List<Product> products) {
        mProductsAdapter.clear();
        mProductsAdapter.addAll(products);
        mProductsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyProductsList() {
        mProductsAdapter.clear();
        mProductsAdapter.notifyDataSetChanged();
        Toast.makeText(getContext(),"No products available to show!", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mProductsListView.setVisibility(View.GONE);
        mLoadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProductsListView.setVisibility(View.VISIBLE);
        mLoadingBar.setVisibility(View.GONE);
    }

    @Override
    public void showProductsDetails(Product product) {
        mNavigator.navigateWith(product);
    }

    @Override
    public void onClick(Product product) {
        mPresenter.selectProduct(product);
    }

    @OnTextChanged(R.id.et_filter_search)
    public void onTextChanged() {
        String pattern = mSearchFilterText.getText().toString();
        mPresenter.filterProducts(pattern);
    }

}
