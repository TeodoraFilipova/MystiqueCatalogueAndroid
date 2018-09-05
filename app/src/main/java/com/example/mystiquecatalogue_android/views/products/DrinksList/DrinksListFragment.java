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

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public void setNavigator(DrinksListContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void setPresenter(DrinksListContracts.Presenter presenter) {

    }

    @Override
    public void showProducts(List<Product> products) {

    }

    @Override
    public void showEmptyProductsList() {

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
    public void showProductsDetails(Product product) {

    }

    @Override
    public void onClick(Product drink) {

    }
}
