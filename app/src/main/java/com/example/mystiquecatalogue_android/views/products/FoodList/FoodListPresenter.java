package com.example.mystiquecatalogue_android.views.products.FoodList;

import com.example.mystiquecatalogue_android.async.base.SchedulerProvider;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.services.base.ProductsService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class FoodListPresenter implements FoodListContracts.Presenter {
    private static final String PRODUCT_CATEGORY = "food";
    private final ProductsService mProductsService;
    private final SchedulerProvider mSchedulerProvider;
    private FoodListContracts.View mView;

    @Inject
    public FoodListPresenter
            (ProductsService productsService, SchedulerProvider schedulerProvider) {
        mProductsService = productsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(FoodListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadProducts() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> food = mProductsService.getAllProductsInACategory(PRODUCT_CATEGORY);
                    emitter.onNext(food);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentFoodToView, error -> mView.showError(error));
    }

    @Override
    public void filterProducts(String pattern) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> food = mProductsService.getFilteredProductsByCategory(pattern, PRODUCT_CATEGORY);
                    emitter.onNext(food);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentFoodToView, error -> mView.showError(error));
    }

    @Override
    public void selectProduct(Product product) {
        mView.showProductsDetails(product);
    }

    private void presentFoodToView(List<Product> food) {
        if (food.isEmpty()) {
            mView.showEmptyProductsList();
        } else {
            mView.showProducts(food);
        }
    }
}
