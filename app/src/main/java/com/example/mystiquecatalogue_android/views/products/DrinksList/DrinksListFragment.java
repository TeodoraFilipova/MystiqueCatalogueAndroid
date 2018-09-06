package com.example.mystiquecatalogue_android.views.products.DrinksList;


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
public class DrinksListFragment extends Fragment implements DrinksListContracts.View,
        DrinksAdapter.OnDrinkClickListener {
    private DrinksListContracts.Navigator mNavigator;

    @BindView(R.id.loading_bar)
    ProgressBar mLoadingBar;

    @BindView(R.id.et_filter_search)
    EditText mEditSearchText;

    @BindView(R.id.lv_drinks)
    RecyclerView mDrinksView;

    @Inject
    DrinksAdapter mDrinksAdapter;

    private DrinksListContracts.Presenter mPresenter;
    private GridLayoutManager mProductsViewLayoutManager;

    @Inject
    public DrinksListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drinks_list, container, false);

        ButterKnife.bind(this, view);

        mDrinksAdapter.setOnDrinkClickListener(this);
        mDrinksView.setAdapter(mDrinksAdapter);

        mProductsViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mDrinksView.setLayoutManager(mProductsViewLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadProducts();
    }

    public void setNavigator(DrinksListContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void setPresenter(DrinksListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProducts(List<Product> products) {
        mDrinksAdapter.clear();
        mDrinksAdapter.addAll(products);
        mDrinksAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyProductsList() {
        mDrinksAdapter.clear();
        mDrinksAdapter.notifyDataSetChanged();
        Toast.makeText(getContext(),"No drinks available to show!", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mDrinksView.setVisibility(View.GONE);
        mLoadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mDrinksView.setVisibility(View.VISIBLE);
        mLoadingBar.setVisibility(View.GONE);
    }

    @Override
    public void showProductsDetails(Product product) {
        mNavigator.navigateWith(product);
    }

    @Override
    public void onClick(Product drink) {
        mPresenter.selectProduct(drink);
    }

    @OnTextChanged(R.id.et_filter_search)
    public void onTextChanged() {
        String pattern = mEditSearchText.getText().toString();
        mPresenter.filterProducts(pattern);
    }
}
