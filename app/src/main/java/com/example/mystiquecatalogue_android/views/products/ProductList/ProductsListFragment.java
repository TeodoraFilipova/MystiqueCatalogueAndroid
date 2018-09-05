package com.example.mystiquecatalogue_android.views.products.ProductList;


import android.app.Fragment;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsListFragment extends Fragment implements ProductsListContracts.View{
    private ProductsListContracts.Navigator mNavigator;

    @BindView(R.id.lv_products)
    ListView mProductsListView;

    public ProductsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_products_list, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    public static ProductsListFragment newInstance() {
        return new ProductsListFragment();
    }

    void setNavigator(ProductsListContracts.Navigator navigator) {
        mNavigator = navigator;
    }


    @Override
    public void setPresenter(ProductsListContracts.Presenter presenter) {

    }

    @Override
    public void showProducts(List<Product> superheroes) {

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
}
