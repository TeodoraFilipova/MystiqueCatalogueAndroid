package com.example.mystiquecatalogue_android.diconfig;


import com.example.mystiquecatalogue_android.views.products.ProductDetails.ProductDetailsContracts;
import com.example.mystiquecatalogue_android.views.products.ProductDetails.ProductDetailsFragment;
import com.example.mystiquecatalogue_android.views.products.ProductDetails.ProductDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ProductDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ProductDetailsFragment productDetailsFragment();

    @ActivityScoped
    @Binds
    abstract ProductDetailsContracts.Presenter productDetailsPresenter(ProductDetailsPresenter presenter);
}
