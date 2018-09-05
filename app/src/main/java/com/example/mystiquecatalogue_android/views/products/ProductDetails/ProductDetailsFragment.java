package com.example.mystiquecatalogue_android.views.products.ProductDetails;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailsFragment extends Fragment implements ProductDetailsContracts.View {
    private String mFood;
    private TextView mFoodDetailsTextView;

    public ProductDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_details, container, false);

        mFoodDetailsTextView = view.findViewById(R.id.tv_foodDetails);
        mFoodDetailsTextView.setText(mFood);

        return view;
    }

    public static ProductDetailsFragment newInstance() { return new ProductDetailsFragment();
    }

    public void setFood(String food) {
        this.mFood = food;
        if (mFoodDetailsTextView == null){
            return;
        }
        mFoodDetailsTextView.setText(food);
    }

    @Override
    public void showProduct(Product product) {

    }

    @Override
    public void setPresenter(ProductDetailsContracts.Presenter presenter) {

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
