package com.example.mystiquecatalogue_android.views.products.DrinksList;

import com.example.mystiquecatalogue_android.async.base.SchedulerProvider;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.services.base.ProductsService;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class DrinksListPresenter implements DrinksListContracts.Presenter {
    private static final String PRODUCT_CATEGORY = "drinks";
    private final ProductsService mProductsService;
    private final SchedulerProvider mSchedulerProvider;
    private DrinksListContracts.View mView;

    @Inject
    public DrinksListPresenter
            (ProductsService productsService, SchedulerProvider schedulerProvider) {
        mProductsService = productsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(DrinksListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadProducts() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> drinks = mProductsService.getAllProductsInACategory(PRODUCT_CATEGORY);
                    emitter.onNext(drinks);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentDrinksToView, error -> mView.showError(error));
    }

    @Override
    public void filterProducts(String pattern) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> drinks = mProductsService.getFilteredProductsByCategory(pattern, PRODUCT_CATEGORY);
                    emitter.onNext(drinks);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentDrinksToView, error -> mView.showError(error));
    }

    @Override
    public void selectProduct(Product product) {
        mView.showProductsDetails(product);
    }

    private void presentDrinksToView(List<Product> drinks) {
        if (drinks.isEmpty()) {
            mView.showEmptyProductsList();
        } else {
            mView.showProducts(drinks);
        }
    }
}
