package com.example.mystiquecatalogue_android.diconfig;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewsModule {

    @Provides
    public ArrayAdapter<Product> productArrayAdapter(Context context){
        return new ProductsAdapter(context);
    }


}
