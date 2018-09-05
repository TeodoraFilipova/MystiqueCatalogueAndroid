package com.example.mystiquecatalogue_android.diconfig;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewsModule {

    @Provides
    public RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> productArrayAdapter(Context context){
        return new ProductsAdapter();
    }


}
