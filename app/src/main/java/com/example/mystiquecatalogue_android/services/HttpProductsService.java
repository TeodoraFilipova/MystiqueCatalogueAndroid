package com.example.mystiquecatalogue_android.services;

import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.repositories.base.Repository;
import com.example.mystiquecatalogue_android.services.base.ProductsService;
import com.example.mystiquecatalogue_android.validatorss.base.Validator;


import java.util.List;
import java.util.stream.Collectors;

public class HttpProductsService implements ProductsService {
    private final Repository<Product> mProductsRepository;
    private final Validator<Product> mProductValidator;

    public HttpProductsService(
            Repository<Product> ProductsRepository,
            Validator<Product> ProductValidator) {
        mProductsRepository = ProductsRepository;
        mProductValidator = ProductValidator;
    }

    @Override
    public List<Product> getAllProducts() throws Exception {
        return mProductsRepository.getAll();
    }

    @Override
    public Product getDetailsById(int id) throws Exception {
        return mProductsRepository.getById(id);
    }

    @Override
    public List<Product> getFilteredProducts(String pattern) throws Exception {
        String patternToLower = pattern.toLowerCase();

        return getAllProducts().stream()
                .filter(product -> product.getName().toLowerCase().contains(patternToLower))
                .collect(Collectors.toList());
    }

    @Override
    public Product createProduct(Product superhero) throws Exception {
        if (!mProductValidator.isValid(superhero)) {
            throw new IllegalArgumentException("Product is invalid");
        }

        return mProductsRepository.add(superhero);
    }
}
