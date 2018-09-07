package com.example.mystiquecatalogue_android.views.products.WishList;



import com.example.mystiquecatalogue_android.models.Product;

import java.util.List;

public interface WishListContracts {
    interface View {
        void setPresenter(WishListContracts.Presenter presenter);

        void showProducts(List<Product> products);

        void showEmptyProductsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showProductsDetails(Product product);
    }

    interface Presenter {
        void subscribe(WishListContracts.View view);

        void loadProducts();

 //       void filterProducts(String pattern);

        void selectProduct(Product product);
    }

    interface Navigator {
        void navigateWith(Product product);
    }
}
