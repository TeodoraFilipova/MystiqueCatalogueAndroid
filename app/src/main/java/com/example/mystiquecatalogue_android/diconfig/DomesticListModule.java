package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.views.products.DomesticList.DomesticListContracts;
import com.example.mystiquecatalogue_android.views.products.DomesticList.DomesticListFragment;
import com.example.mystiquecatalogue_android.views.products.DomesticList.DomesticListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DomesticListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract DomesticListFragment domesticListFragment();

    @ActivityScoped
    @Binds
    abstract DomesticListContracts.Presenter domesticPresenter(DomesticListPresenter presenter);
}
