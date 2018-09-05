package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            ProductsListModule.class
    })
    abstract ProductsListActivity productsListActivity();


}