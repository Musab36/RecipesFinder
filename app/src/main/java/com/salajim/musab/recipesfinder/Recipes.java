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
    String ingredients;
    String href;

    public Recipes() {}

    public Recipes(String smallImageUrls, String recipeName, String ingredients, String href) {
        this.smallImageUrls = smallImageUrls;
        this.recipeName = recipeName;
        //this.rating = rating;
        this.ingredients = ingredients;
        this.href = href;
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

    public String getIngredients() {
        return ingredients;
    }

    public String getHref() {
        return href;
    }
}
