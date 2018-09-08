package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.views.contacts.map.ContactsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ContactsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ContactsFragment contactsFragment();
}
