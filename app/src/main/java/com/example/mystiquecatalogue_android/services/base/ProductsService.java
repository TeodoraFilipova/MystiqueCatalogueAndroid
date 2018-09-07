package com.example.mystiquecatalogue_android.services.base;


import com.example.mystiquecatalogue_android.models.Product;

import java.io.StringReader;
import java.util.List;

public interface ProductsService {
    List<Product> getAllProducts() throws Exception;

    List<Product> getAllProductsInACategory(String category) throws Exception;

    Product getDetailsById(int id) throws Exception;

    List<Product> getFilteredProducts(String pattern) throws Exception;

    List<Product> getFilteredProductsByCategory(String pattern, String category) throws Exception;

    List<Product> getAllProductsInWishList() throws Exception;

    Product updateProduct(int id, Product product) throws Exception;

    Product createProduct(Product product) throws Exception;
}
