package com.example.mystiquecatalogue_android.views.products.ProductList;

import com.example.mystiquecatalogue_android.async.base.SchedulerProvider;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.services.base.ProductsService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class ProductsListPresenter implements ProductsListContracts.Presenter {
    private final ProductsService mProductsService;
    private final SchedulerProvider mSchedulerProvider;
    private ProductsListContracts.View mView;

    @Inject
    public ProductsListPresenter(ProductsService productsService, SchedulerProvider schedulerProvider) {
        mProductsService = productsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(ProductsListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadProducts() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> products = mProductsService.getAllProducts();
                    emitter.onNext(products);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentProductsToView, error -> mView.showError(error));
    }

    @Override
    public void filterProducts(String pattern) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> products = mProductsService.getFilteredProducts(pattern);
                    emitter.onNext(products);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentProductsToView, error -> mView.showError(error));
    }

    @Override
    public void selectProduct(Product product) {
        mView.showProductsDetails(product);
    }

    private void presentProductsToView(List<Product> products) {
        if (products.isEmpty()) {
            mView.showEmptyProductsList();
        } else {
            mView.showProducts(products);
        }
    }

}
