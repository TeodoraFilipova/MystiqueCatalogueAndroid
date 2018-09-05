package com.example.mystiquecatalogue_android.diconfig;



import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListContracts;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListFragment;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ProductsListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ProductsListFragment superheroesListFragment();

    @ActivityScoped
    @Binds
    abstract ProductsListContracts.Presenter Presenter(ProductsListPresenter presenter);
}

