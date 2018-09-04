package com.example.mystiquecatalogue_android.services.base;

import com.minkov.androidapp.models.Superhero;

import java.util.List;

public interface SuperheroesService {
    List<Superhero> getAllSuperheroes() throws Exception;

    Superhero getDetailsById(int id) throws Exception;

    List<Superhero> getFilteredSuperheroes(String pattern) throws Exception;

    Superhero createSuperhero(Superhero superhero) throws Exception;
}
