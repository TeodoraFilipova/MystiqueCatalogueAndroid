package com.example.mystiquecatalogue_android.diconfig;

import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.validatorss.ProductValidator;
import com.example.mystiquecatalogue_android.validatorss.base.Validator;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ValidatorsModule {
    @Provides
    @Singleton
    public Validator<Product> superheroValidator() {
        return new ProductValidator();
    }
}
