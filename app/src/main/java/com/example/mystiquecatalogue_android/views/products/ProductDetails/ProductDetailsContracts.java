package com.example.mystiquecatalogue_android.views.products.ProductDetails;

import com.example.mystiquecatalogue_android.models.Product;

public interface ProductDetailsContracts {
    interface View {
        void showProduct(Product product);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showAddedToWishList(Product product);
    }

    interface Presenter {
        void subscribe(View view);

        void loadProduct();

        void updateProduct() throws Exception;

        void setProductId(int id);
    }
}
