package com.example.mystiquecatalogue_android.views.products.ProductDetails;

import com.example.mystiquecatalogue_android.async.base.SchedulerProvider;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.services.base.ProductsService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;


public class ProductDetailsPresenter implements ProductDetailsContracts.Presenter {
    private final ProductsService mProductsService;
    private final SchedulerProvider mSchedulerProvider;

    private ProductDetailsContracts.View mView;
    private int mProductId;

    @Inject
    public ProductDetailsPresenter(
            ProductsService productsService,
            SchedulerProvider schedulerProvider
    ) {
        mProductsService = productsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(ProductDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadProduct() {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Product>) emitter -> {
                    Product product = mProductsService.getDetailsById(mProductId);
                    emitter.onNext(product);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showProduct);
    }

    @Override
    public void updateProduct() throws Exception {

        Disposable observable = Observable
                .create((ObservableOnSubscribe<Product>) emitter -> {
                    Product newProduct = mProductsService.getDetailsById(mProductId);
                    int newBought = newProduct.getBought() + 1;
                    newProduct.setBought(newBought);
                    mProductsService.updateProduct(mProductId, newProduct);

                    emitter.onNext(newProduct);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showAddedToWishList);
    }

    @Override
    public void setProductId(int productId) {
        mProductId = productId;
    }
}
