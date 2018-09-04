package com.example.mystiquecatalogue_android.views;

import android.app.Application;

import com.example.mystiquecatalogue_android.models.Domestic;
import com.example.mystiquecatalogue_android.models.Drink;
import com.example.mystiquecatalogue_android.models.Food;
import com.example.mystiquecatalogue_android.repositories.FirebaseRepository;
import com.example.mystiquecatalogue_android.repositories.base.Repository;


public class AndroidApplication extends Application {
    public static Repository<Drink> drinkRepository;
    public static Repository<Food> foodRepository;
    public static Repository<Domestic> domesticRepository;

    public static Repository<Drink> getDrinkRepository() {
        if (drinkRepository == null){
            drinkRepository = new FirebaseRepository<>(Drink.class);
            }
        return drinkRepository;
    }

    public static Repository<Food> getFoodRepository() {
        if (foodRepository == null){
            foodRepository = new FirebaseRepository<>(Food.class);
        }
        return foodRepository;
    }

    public static Repository<Domestic> getDomesticRepository() {
        if (domesticRepository == null){
            domesticRepository = new FirebaseRepository<>(Domestic.class);
        }
        return domesticRepository;
    }

}
