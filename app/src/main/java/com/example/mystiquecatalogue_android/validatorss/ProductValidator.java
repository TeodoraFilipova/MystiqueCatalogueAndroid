package com.example.mystiquecatalogue_android.validatorss;

import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.validatorss.base.Validator;
import com.example.mystiquecatalogue_android.views.Constants;


public class ProductValidator implements Validator<Product> {
    @Override
    public boolean isValid(Product object) {
        return object != null &&
                isNameValid(object);

    }


    private boolean isNameValid(Product object) {
        return object.getName().length() >= Constants.PRODUCT_NAME_MIN_LENGHT &&
                object.getName().length() <= Constants.PRODUCT_NAME_MAX_LENGHT;
    }
}
