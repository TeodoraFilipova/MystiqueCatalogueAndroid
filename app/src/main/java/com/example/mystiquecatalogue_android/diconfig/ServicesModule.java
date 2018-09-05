package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.repositories.base.Repository;

import com.example.mystiquecatalogue_android.services.HttpProductsService;
import com.example.mystiquecatalogue_android.services.base.ProductsService;
import com.example.mystiquecatalogue_android.validatorss.base.Validator;


import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public ProductsService productsService(Repository<Product> repository, Validator<Product> validator) {
        return new HttpProductsService(repository, validator);
    }
}
