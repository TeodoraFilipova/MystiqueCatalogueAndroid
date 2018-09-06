package com.example.mystiquecatalogue_android.views.products.DomesticList;

import com.example.mystiquecatalogue_android.models.Product;

import java.util.List;

public interface DomesticListContracts {
    interface View {
        void setPresenter(DomesticListContracts.Presenter presenter);

        void showProducts(List<Product> products);

        void showEmptyProductsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showProductsDetails(Product product);
    }

    interface Presenter {
        void subscribe(DomesticListContracts.View view);

        void loadProducts();

        void filterProducts(String pattern);

        void selectProduct(Product product);
    }

    interface Navigator {
        void navigateWith(Product product);
    }
}
