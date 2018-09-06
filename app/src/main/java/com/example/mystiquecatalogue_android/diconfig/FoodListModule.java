package com.example.mystiquecatalogue_android.diconfig;



import com.example.mystiquecatalogue_android.views.products.FoodList.FoodListContracts;
import com.example.mystiquecatalogue_android.views.products.FoodList.FoodListFragment;
import com.example.mystiquecatalogue_android.views.products.FoodList.FoodListPresenter;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


import dagger.Binds;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FoodListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract FoodListFragment foodListFragment();

    @ActivityScoped
    @Binds
    abstract FoodListContracts.Presenter foodPresenter(FoodListPresenter presenter);
}
