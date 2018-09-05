package com.example.mystiquecatalogue_android.validatorss;

import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.validatorss.base.Validator;
import com.example.mystiquecatalogue_android.views.Constants;


public class ProductValidator implements Validator<Product> {
    @Override
    public boolean isValid(Product object) {
        return object != null &&
                isNameValid(object) &&
                isCategoryValid(object) &&
                isTypeValid(object) &&
                isUnitsValid(object) &&
                isIdValid(object) &&
                isSizeValid(object) &&
                isNumberValid(object);

    }

    private boolean isNameValid(Product object) {
        return object.getName().length() >= Constants.PRODUCT_NAME_MIN_LENGHT &&
                object.getName().length() <= Constants.PRODUCT_NAME_MAX_LENGHT;
    }

    private boolean isCategoryValid(Product object) {
        return object.getCategory().length() >= Constants.PRODUCT_CATEGORY_MIN_LENGHT &&
                object.getCategory().length() <= Constants.PRODUCT_CATEGORY_MAX_LENGHT;
    }

    private boolean isTypeValid(Product object) {
        return object.getType().length() >= Constants.PRODUCT_TYPE_MIN_LENGHT &&
                object.getType().length() <= Constants.PRODUCT_TYPE_MAX_LENGHT;
    }

    private boolean isUnitsValid(Product object) {
        return object.getUnits().length() >= Constants.PRODUCT_UNITS_MIN_LENGHT &&
                object.getUnits().length() <= Constants.PRODUCT_UNITS_MAX_LENGHT;
    }

    private boolean isIdValid(Product object) {
        return object.getId() > 0;
    }

    private boolean isSizeValid(Product object) {
        return object.getSize() > 0;
    }

    private boolean isNumberValid(Product object) {
        return object.getNumber() > 0;
    }

}
