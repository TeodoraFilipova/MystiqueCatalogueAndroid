package com.example.mystiquecatalogue_android.models;

public class Drink {
    public String name;
    public String type;
    public String units;
    public String size;
    public String number;

    public Drink(){
        // empty constructor for firebase to work
    }

    public Drink(String name, String type, String units, String size, String number){
        this.name = name;
        this.type = type;
        this.units = units;
        this.size = size;
        this.number = number;
    }

}
