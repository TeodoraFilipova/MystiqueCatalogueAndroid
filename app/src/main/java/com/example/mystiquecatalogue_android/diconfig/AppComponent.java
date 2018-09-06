package com.example.mystiquecatalogue_android.diconfig;

import android.app.Application;

import com.example.mystiquecatalogue_android.validatorss.ProductValidator;
import com.example.mystiquecatalogue_android.views.AndroidApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;


    @Singleton
    @Component(modules = {
            ActivityBindingModule.class,
            AppModule.class,
            AsyncModule.class,
            HttpModule.class,
            ParsersModule.class,
            ProductsListModule.class,
            ProductDetailsModule.class,
            DrinksListModule.class,
            RepositoriesModule.class,
            ServicesModule.class,
            ValidatorsModule.class,
            ViewsModule.class,
            AndroidSupportInjectionModule.class})
    public interface AppComponent extends AndroidInjector<AndroidApplication> {

        @Component.Builder
        interface Builder {

            @BindsInstance
            AppComponent.Builder application(Application application);

            AppComponent build();
        }
}
