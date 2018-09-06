package com.example.mystiquecatalogue_android.views.products.DomesticList;

import com.example.mystiquecatalogue_android.async.base.SchedulerProvider;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.services.base.ProductsService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class DomesticListPresenter implements DomesticListContracts.Presenter {
    private static final String PRODUCT_CATEGORY = "domestics";
    private final ProductsService mProductsService;
    private final SchedulerProvider mSchedulerProvider;
    private DomesticListContracts.View mView;

    @Inject
    public DomesticListPresenter
            (ProductsService productsService, SchedulerProvider schedulerProvider) {
        mProductsService = productsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(DomesticListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadProducts() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> domestic = mProductsService.getAllProductsInACategory(PRODUCT_CATEGORY);
                    emitter.onNext(domestic);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentDomesticsToView, error -> mView.showError(error));
    }

    @Override
    public void filterProducts(String pattern) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> domestics = mProductsService.getFilteredProductsByCategory(pattern, PRODUCT_CATEGORY);
                    emitter.onNext(domestics);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentDomesticsToView, error -> mView.showError(error));
    }

    @Override
    public void selectProduct(Product product) {
        mView.showProductsDetails(product);
    }

    private void presentDomesticsToView(List<Product> domestics) {
        if (domestics.isEmpty()) {
            mView.showEmptyProductsList();
        } else {
            mView.showProducts(domestics);
        }
    }
}
