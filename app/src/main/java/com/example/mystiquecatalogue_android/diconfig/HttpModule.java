package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.http.HttpRequester;
import com.example.mystiquecatalogue_android.http.OkHttpHttpRequester;
import com.example.mystiquecatalogue_android.views.Constants;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester(){
        return new OkHttpHttpRequester();
    }

    @Provides
    @Named("baseServerUrl")
    public String baseServerUrl(){
        return Constants.BASE_SERVER_URL;
    }
}
