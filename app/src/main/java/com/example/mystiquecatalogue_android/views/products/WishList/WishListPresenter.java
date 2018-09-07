package com.example.mystiquecatalogue_android.views.products.WishList;

import com.example.mystiquecatalogue_android.async.base.SchedulerProvider;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.services.base.ProductsService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class WishListPresenter implements WishListContracts.Presenter {
        private static final int BOUGHT_STATUS = 1;
        private final ProductsService mProductsService;
        private final SchedulerProvider mSchedulerProvider;
        private WishListContracts.View mView;

    @Inject
    public WishListPresenter
                (ProductsService productsService, SchedulerProvider schedulerProvider) {
            mProductsService = productsService;
            mSchedulerProvider = schedulerProvider;
        }

        @Override
        public void subscribe(WishListContracts.View view) {
            mView = view;
        }

        @Override
        public void loadProducts() {
            mView.showLoading();
            Disposable observable = Observable
                    .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                        List<Product> wished_products = mProductsService.getAllProductsWishList(BOUGHT_STATUS);
                        emitter.onNext(wished_products);
                        emitter.onComplete();
                    })
                    .subscribeOn(mSchedulerProvider.background())
                    .observeOn(mSchedulerProvider.ui())
                    .doFinally(mView::hideLoading)
                    .subscribe(this::presentWishToView, error -> mView.showError(error));
        }

 /*       @Override
        public void filterProducts(String pattern) {
            mView.showLoading();
            Disposable observable = Observable
                    .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                        List<Product> wished_products = mProductsService.getFilteredProductsByCategory(pattern, PRODUCT_CATEGORY);
                        emitter.onNext(drinks);
                        emitter.onComplete();
                    })
                    .subscribeOn(mSchedulerProvider.background())
                    .observeOn(mSchedulerProvider.ui())
                    .doFinally(mView::hideLoading)
                    .subscribe(this::presentDrinksToView, error -> mView.showError(error));
        }
*/
        @Override
        public void selectProduct(Product product) {
            mView.showProductsDetails(product);
        }

        private void presentWishToView(List<Product> wished_products) {
            if (wished_products.isEmpty()) {
                mView.showEmptyProductsList();
            } else {
                mView.showProducts(wished_products);
            }
        }
}