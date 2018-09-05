package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListContracts;
import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListFragment;
import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListPresenter;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListContracts;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListPresenter;

import dagger.Binds;
import dagger.android.ContributesAndroidInjector;

public abstract class DrinksListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract DrinksListFragment drinksListFragment();

    @ActivityScoped
    @Binds
    abstract DrinksListContracts.Presenter drinksPresenter(DrinksListPresenter presenter);
}
