package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListContracts;
import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListFragment;
import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DrinksListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract DrinksListFragment drinksListFragment();

    @ActivityScoped
    @Binds
    abstract DrinksListContracts.Presenter drinksPresenter(DrinksListPresenter presenter);
}
