package com.salajim.musab.recipesfinder;

import org.parceler.Parcel;

/**
 * Created by Musab on 1/1/2018.
 */
@Parcel
public class Recipes {
    String smallImageUrls;
    String recipeName;
    //String rating;

    public Recipes() {}

    public Recipes(String smallImageUrls, String recipeName) {
        this.smallImageUrls = smallImageUrls;
        this.recipeName = recipeName;
        //this.rating = rating;
    }

    public String getSmallImageUrls() {
        return smallImageUrls;
    }

    public String getRecipeName() {
        return recipeName;
    }

    /*
    public String getRating() {
        return rating;
    }
    */
}
