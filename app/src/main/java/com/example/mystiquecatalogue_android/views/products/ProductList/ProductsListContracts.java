package com.example.mystiquecatalogue_android.views.products.ProductList;

import com.example.mystiquecatalogue_android.models.Product;

import java.util.List;

public interface ProductsListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showProducts(List<Product> products);

        void showEmptyProductsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showProductsDetails(Product product);
    }

    interface Presenter {
        void subscribe(View view);

        void loadProducts();

        void filterProducts(String pattern);

        void selectProduct(Product product);
    }

    interface Navigator {
        void navigateWith(Product product);
    }

}
