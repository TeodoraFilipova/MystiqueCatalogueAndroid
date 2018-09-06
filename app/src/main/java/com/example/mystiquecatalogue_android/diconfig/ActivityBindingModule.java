package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.views.MainActivity;
import com.example.mystiquecatalogue_android.views.contacts.ContactsActivity;
import com.example.mystiquecatalogue_android.views.contacts.EmailActivity;
import com.example.mystiquecatalogue_android.views.products.DomesticList.DomesticListActivity;
import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListActivity;
import com.example.mystiquecatalogue_android.views.products.ProductDetails.ProductDetailsActivity;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListActivity;

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
            DomesticListModule.class
    })
    abstract DomesticListActivity domesticListActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract ContactsActivity contactsActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract EmailActivity emailActivity();

}