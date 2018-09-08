package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.views.MainActivity;
import com.example.mystiquecatalogue_android.views.contacts.map.ContactsActivity;
import com.example.mystiquecatalogue_android.views.contacts.email.EmailActivity;
import com.example.mystiquecatalogue_android.views.products.DomesticList.DomesticListActivity;
import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListActivity;
import com.example.mystiquecatalogue_android.views.products.FoodList.FoodListActivity;
import com.example.mystiquecatalogue_android.views.products.ProductDetails.ProductDetailsActivity;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListActivity;
import com.example.mystiquecatalogue_android.views.products.WishList.WishListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract MainActivity mainActivity();


    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            ProductsListModule.class
    })
    abstract ProductsListActivity productsListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            ProductDetailsModule.class
    })
    abstract ProductDetailsActivity productsDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            DrinksListModule.class
    })
    abstract DrinksListActivity drinksListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            FoodListModule.class
    })
    abstract FoodListActivity foodListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            DomesticListModule.class
    })
    abstract DomesticListActivity domesticListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            WishListModule.class
    })
    abstract WishListActivity wishListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            ContactsModule.class
    })
    abstract ContactsActivity contactsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            EmailModule.class
    })
    abstract EmailActivity emailActivity();

}