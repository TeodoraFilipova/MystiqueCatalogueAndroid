package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.parsers.GsonJsonParser;
import com.example.mystiquecatalogue_android.parsers.base.JsonParser;


import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<Product> jsonParser(){
        return new GsonJsonParser<>(Product.class, Product[].class);
    }
}
