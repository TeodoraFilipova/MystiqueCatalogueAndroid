package com.example.mystiquecatalogue_android.models;

public class Domestic {
    public String name;
    public String type;
    public String units;
    public String size;
    public String number;

    public Domestic(){
        // empty constructor for firebase to work
    }

    public Domestic(String name, String type, String units, String size, String number){
        this.name = name;
        this.type = type;
        this.units = units;
        this.size = size;
        this.number = number;
    }
}
