package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.views.contacts.email.EmailFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class EmailModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract EmailFragment emailFragment();
}
