package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.views.products.WishList.WishListContracts;
import com.example.mystiquecatalogue_android.views.products.WishList.WishListFragment;
import com.example.mystiquecatalogue_android.views.products.WishList.WishListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class WishListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract WishListFragment wishListFragment();

    @ActivityScoped
    @Binds
    abstract WishListContracts.Presenter wishPresenter(WishListPresenter presenter);

}
