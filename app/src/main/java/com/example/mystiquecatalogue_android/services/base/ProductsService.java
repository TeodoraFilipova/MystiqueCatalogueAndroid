package com.example.mystiquecatalogue_android.services.base;


import com.example.mystiquecatalogue_android.models.Product;

import java.util.List;

public interface ProductsService {
    List<Product> getAllProducts() throws Exception;

    Product getDetailsById(int id) throws Exception;

    List<Product> getFilteredProducts(String pattern) throws Exception;

    Product createProduct(Product product) throws Exception;
}
