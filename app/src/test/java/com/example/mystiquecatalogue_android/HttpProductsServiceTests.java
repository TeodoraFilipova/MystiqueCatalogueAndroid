package com.example.mystiquecatalogue_android;

import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.repositories.base.Repository;
import com.example.mystiquecatalogue_android.services.HttpProductsService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HttpProductsServiceTests {
    @Mock
    Repository mockRepository;

    @InjectMocks
    HttpProductsService testHttpProductsService;

    private static List<Product> defaultMockRepositoryContent = Arrays.asList(
            new Product("https://cdn.shopify.com/s/files/1/0559/2049/products/cucumber_loofa_st.jpg?v=1422537026",
                    "soap", "domestics", 1, "cosmetics", "ml", 50, 10, 2.35, 0),
            new Product("https://ak.jogurucdn.com/media/image/p15/media_gallery-2016-03-11-8-snigdha_1_8f0028a78131f5e00f61257fff8018ea.jpg",
                    "beer", "drinks", 2, "alcohol", "ml", 500, 100, 3.69, 0),
            new Product("https://si.wsj.net/public/resources/images/BN-XI366_DIATRI_P_20180205164158.jpg",
                    "chocolate", "food", 3, "sweets", "g", 100, 100, 2.45, 0)
    );

    @Test
    public void getAllProducts_Should_ReturnAllProductsFromRepository_When_RepositoryHasProducts() throws Exception {
        // Arrange
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        // Act
        List<Product> result = testHttpProductsService.getAllProducts();
        Product[] finalResult = new Product[result.size()];
        finalResult = result.toArray(finalResult);

        Product[] expected = new Product[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);

        // Assert
        Assert.assertArrayEquals(expected, finalResult);
    }

    @Test
    public void getAllProductsInACategory_Should_ReturnAllMatchingProductsFromRepo_When_MatchExists() throws Exception {
        // Arrange
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        // Act
        List<Product> result = testHttpProductsService.getAllProductsInACategory("food");
        Product finalResult = result.get(0);

        Product expected = new Product("https://si.wsj.net/public/resources/images/BN-XI366_DIATRI_P_20180205164158.jpg",
                "chocolate", "food", 3, "sweets", "g", 100, 100, 2.45, 0);

        // Assert
        Assert.assertEquals(expected.getImageUrl(), finalResult.getImageUrl());
        Assert.assertEquals(expected.getName(), finalResult.getName());
        Assert.assertEquals(expected.getCategory(), finalResult.getCategory());
        Assert.assertEquals(expected.getId(), finalResult.getId());
        Assert.assertEquals(expected.getType(), finalResult.getType());
        Assert.assertEquals(expected.getUnits(), finalResult.getUnits());
        Assert.assertEquals(expected.getSize(), finalResult.getSize());
        Assert.assertEquals(expected.getNumber(), finalResult.getNumber());
        Assert.assertEquals(expected.getPrice(), finalResult.getPrice(), 0);
        Assert.assertEquals(expected.getBought(), finalResult.getBought());
    }

    @Test
    public void getDetailsById_Should_ReturnProductWithMatchingId_When_MatchExists() throws Exception {
        // Arrange
        Mockito.when(mockRepository.getById(1)).thenReturn(defaultMockRepositoryContent.get(0));

        // Act
        Product finalResult = testHttpProductsService.getDetailsById(1);

        Product expected = defaultMockRepositoryContent.get(0);

        // Assert
        Assert.assertEquals(expected.getImageUrl(), finalResult.getImageUrl());
        Assert.assertEquals(expected.getName(), finalResult.getName());
        Assert.assertEquals(expected.getCategory(), finalResult.getCategory());
        Assert.assertEquals(expected.getId(), finalResult.getId());
        Assert.assertEquals(expected.getType(), finalResult.getType());
        Assert.assertEquals(expected.getUnits(), finalResult.getUnits());
        Assert.assertEquals(expected.getSize(), finalResult.getSize());
        Assert.assertEquals(expected.getNumber(), finalResult.getNumber());
        Assert.assertEquals(expected.getPrice(), finalResult.getPrice(), 0);
        Assert.assertEquals(expected.getBought(), finalResult.getBought());
    }

    @Test
    public void getFilteredProducts_Should_ReturnProductsWithNameMatchingPattern_When_MatchExists() throws Exception {
        // Arrange
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        // Act
        List<Product> result = testHttpProductsService.getFilteredProducts("o");
        Product[] finalResult = new Product[result.size()];
        finalResult = result.toArray(finalResult);

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(defaultMockRepositoryContent.get(0));
        expectedProducts.add(defaultMockRepositoryContent.get(2));
        Product[] expected = new Product[expectedProducts.size()];
        expected = expectedProducts.toArray(expected);

        // Assert
        Assert.assertArrayEquals(expected, finalResult);
    }

    @Test
    public void getFilteredProductsByCategory_Should_ReturnProductsInCategoryWithNameMatchingPattern_When_MatchExists() throws Exception {
        // Arrange
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        // Act
        List<Product> result = testHttpProductsService.getFilteredProductsByCategory("o", "food");
        Product finalResult = result.get(0);

        Product expected = defaultMockRepositoryContent.get(2);

        // Assert
        Assert.assertEquals(expected.getImageUrl(), finalResult.getImageUrl());
        Assert.assertEquals(expected.getName(), finalResult.getName());
        Assert.assertEquals(expected.getCategory(), finalResult.getCategory());
        Assert.assertEquals(expected.getId(), finalResult.getId());
        Assert.assertEquals(expected.getType(), finalResult.getType());
        Assert.assertEquals(expected.getUnits(), finalResult.getUnits());
        Assert.assertEquals(expected.getSize(), finalResult.getSize());
        Assert.assertEquals(expected.getNumber(), finalResult.getNumber());
        Assert.assertEquals(expected.getPrice(), finalResult.getPrice(), 0);
        Assert.assertEquals(expected.getBought(), finalResult.getBought());
    }

    @Test
    public void getAllProductsInWishList_Should_ReturnProductsWithBoughtValueNotZero_When_MatchExists() throws Exception {
        // Arrange
        defaultMockRepositoryContent.get(0).setBought(1);
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        // Act
        List<Product> result = testHttpProductsService.getAllProductsInWishList();
        Product finalResult = result.get(0);

        Product expected = defaultMockRepositoryContent.get(0);

        // Assert
        Assert.assertEquals(expected.getImageUrl(), finalResult.getImageUrl());
        Assert.assertEquals(expected.getName(), finalResult.getName());
        Assert.assertEquals(expected.getCategory(), finalResult.getCategory());
        Assert.assertEquals(expected.getId(), finalResult.getId());
        Assert.assertEquals(expected.getType(), finalResult.getType());
        Assert.assertEquals(expected.getUnits(), finalResult.getUnits());
        Assert.assertEquals(expected.getSize(), finalResult.getSize());
        Assert.assertEquals(expected.getNumber(), finalResult.getNumber());
        Assert.assertEquals(expected.getPrice(), finalResult.getPrice(), 0);
        Assert.assertEquals(expected.getBought(), finalResult.getBought());
    }
}
