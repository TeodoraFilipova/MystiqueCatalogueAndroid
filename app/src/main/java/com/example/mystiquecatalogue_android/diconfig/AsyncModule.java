package com.example.mystiquecatalogue_android.diconfig;



import com.example.mystiquecatalogue_android.async.AsyncSchedulerProvider;
import com.example.mystiquecatalogue_android.async.base.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }
}
