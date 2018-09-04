package com.example.mystiquecatalogue_android.views;

import android.app.Application;

import com.example.mystiquecatalogue_android.http.HttpRequester;
import com.example.mystiquecatalogue_android.models.Domestic;
import com.example.mystiquecatalogue_android.models.Drink;
import com.example.mystiquecatalogue_android.models.Food;
import com.example.mystiquecatalogue_android.parsers.base.JsonParser;
import com.example.mystiquecatalogue_android.repositories.FirebaseRepository;
import com.example.mystiquecatalogue_android.repositories.HttpRepository;
import com.example.mystiquecatalogue_android.repositories.base.Repository;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


public class AndroidApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
        //return DaggerAppComponent.builder().application(this).build();
    }

}
