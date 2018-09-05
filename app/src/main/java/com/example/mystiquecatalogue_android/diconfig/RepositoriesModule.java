package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.http.HttpRequester;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.parsers.base.JsonParser;
import com.example.mystiquecatalogue_android.repositories.HttpRepository;
import com.example.mystiquecatalogue_android.repositories.base.Repository;


import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    @Provides
    @Singleton
    public Repository<Product> productRepositoryRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<Product> jsonParser
    ) {
        String url = baseServerUrl + "/superheros";
        return new HttpRepository<>(url, httpRequester, jsonParser);
    }

    /*@Provides
    public Repository<Superhero> superheroRepository(){
        return new InMemoryRepository<>();
    }*/
}
