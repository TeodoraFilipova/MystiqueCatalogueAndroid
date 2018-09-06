package com.example.mystiquecatalogue_android.views.products.DomesticList;


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
public class DomesticListFragment extends Fragment
        implements DomesticListContracts.View, DomesticAdapter.OnDomesticClickListener {

    private DomesticListContracts.Navigator mNavigator;

    @BindView(R.id.loading_bar)
    ProgressBar mLoadingBar;

    @BindView(R.id.et_filter_search)
    EditText mEditSearchText;

    @BindView(R.id.lv_domestic)
    RecyclerView mDomesticView;

    @Inject
    DomesticAdapter mDomesticAdapter;

    private DomesticListContracts.Presenter mPresenter;
    private GridLayoutManager mProductsViewLayoutManager;

    @Inject
    public DomesticListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_domestic_list, container, false);

        ButterKnife.bind(this, view);

        mDomesticAdapter.setOnDomesticClickListener(this);
        mDomesticView.setAdapter(mDomesticAdapter);

        mProductsViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mDomesticView.setLayoutManager(mProductsViewLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadProducts();
    }

    @Override
    public void setPresenter(DomesticListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProducts(List<Product> products) {
        mDomesticAdapter.clear();
        mDomesticAdapter.addAll(products);
        mDomesticAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyProductsList() {
        mDomesticAdapter.clear();
        mDomesticAdapter.notifyDataSetChanged();
        Toast.makeText(getContext(),"No domestic products available to show!",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mDomesticView.setVisibility(View.GONE);
        mLoadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mDomesticView.setVisibility(View.VISIBLE);
        mLoadingBar.setVisibility(View.GONE);
    }

    @Override
    public void showProductsDetails(Product product) {
        mNavigator.navigateWith(product);
    }

    public void setNavigator(DomesticListContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void onClick(Product domestic) {
        mPresenter.selectProduct(domestic);
    }

    @OnTextChanged(R.id.et_filter_search)
    public void onTextChanged() {
        String pattern = mEditSearchText.getText().toString();
        mPresenter.filterProducts(pattern);
    }
}
