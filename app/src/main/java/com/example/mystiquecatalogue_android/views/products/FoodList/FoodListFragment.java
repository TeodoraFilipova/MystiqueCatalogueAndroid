package com.example.mystiquecatalogue_android.views.products.FoodList;


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


public class FoodListFragment extends Fragment implements FoodListContracts.View,
        FoodAdapter.OnFoodClickListener {
    private FoodListContracts.Navigator mNavigator;

    @BindView(R.id.loading_bar)
    ProgressBar mLoadingBar;

    @BindView(R.id.et_filter_search)
    EditText mEditSearchText;

    @BindView(R.id.lv_food)
    RecyclerView mFoodView;

    @Inject
    FoodAdapter mFoodAdapter;

    private FoodListContracts.Presenter mPresenter;
    private GridLayoutManager mProductsViewLayoutManager;

    @Inject
    public FoodListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_list, container, false);

        ButterKnife.bind(this, view);

        mFoodAdapter.setOnFoodClickListener(this);
        mFoodView.setAdapter(mFoodAdapter);

        mProductsViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mFoodView.setLayoutManager(mProductsViewLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadProducts();
    }

    public void setNavigator(FoodListContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void setPresenter(FoodListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProducts(List<Product> products) {
        mFoodAdapter.clear();
        mFoodAdapter.addAll(products);
        mFoodAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyProductsList() {
        mFoodAdapter.clear();
        mFoodAdapter.notifyDataSetChanged();
        Toast.makeText(getContext(),"No food available to show!", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mFoodView.setVisibility(View.GONE);
        mLoadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mFoodView.setVisibility(View.VISIBLE);
        mLoadingBar.setVisibility(View.GONE);
    }

    @Override
    public void showProductsDetails(Product product) {
        mNavigator.navigateWith(product);
    }

    @Override
    public void onClick(Product food) {
        mPresenter.selectProduct(food);
    }

    @OnTextChanged(R.id.et_filter_search)
    public void onTextChanged() {
        String pattern = mEditSearchText.getText().toString();
        mPresenter.filterProducts(pattern);
    }

}
