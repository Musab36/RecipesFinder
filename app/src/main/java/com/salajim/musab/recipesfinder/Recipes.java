package com.salajim.musab.recipesfinder;

/**
 * Created by Musab on 1/1/2018.
 */

public class Recipes {
    private String smallImageUrls;
    private String recipeName;
    private String rating;

    public Recipes(String smallImageUrls, String recipeName, String rating) {
        this.smallImageUrls = smallImageUrls;
        this.recipeName = recipeName;
        this.rating = rating;
    }

    public String getSmallImageUrls() {
        return smallImageUrls;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRating() {
        return rating;
    }
}
