package com.example.mystiquecatalogue_android.views.products.FoodList;

import com.example.mystiquecatalogue_android.models.Product;

import java.util.List;

public interface FoodListContracts {
    interface View {
        void setPresenter(FoodListContracts.Presenter presenter);

        void showProducts(List<Product> products);

        void showEmptyProductsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showProductsDetails(Product product);
    }

    interface Presenter {
        void subscribe(FoodListContracts.View view);

        void loadProducts();

        void filterProducts(String pattern);

        void selectProduct(Product product);
    }

    interface Navigator {
        void navigateWith(Product product);
    }
}
