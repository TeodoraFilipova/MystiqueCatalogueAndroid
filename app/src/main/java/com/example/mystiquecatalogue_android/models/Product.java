package com.example.mystiquecatalogue_android.models;

import java.io.Serializable;

public class Product implements Serializable {
    public String imageUrl;
    public String name;
    public String category;
    public int id;
    public String type;
    public String units;
    public int size;
    public int number;

    public Product() {
        //empty constructor
    }

    public Product(String imageUrl, String name, String category, int id, String type, String units, int size, int number) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.category = category;
        this.id = id;
        this.type = type;
        this.units = units;
        this.size = size;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
