package com.salajim.musab.recipesfinder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Musab on 1/1/2018.
 */

public class RecipesService {
    public static void findRecipes(String matches, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BaseUrl).newBuilder();
        urlBuilder.addQueryParameter(Constants.Api_Key_Holder, Constants.ApiKey);

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Recipes> processResults(Response response) {
        ArrayList<Recipes> recipes = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject recipesJSON = new JSONObject(jsonData);
                JSONArray matchesJSON = recipesJSON.getJSONArray("matches");
                for(int i = 0; i < matchesJSON.length(); i ++) {
                    JSONObject recipeJSON = matchesJSON.getJSONObject(i);
                    String smallImageUrls = recipeJSON.getString("smallImageUrl");
                    String recipeName = recipeJSON.getString("recipeName");
                    String rating = recipeJSON.getString("rating");

                    Recipes recipe = new Recipes(smallImageUrls, recipeName, rating);
                    recipes.add(recipe);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recipes;
    }
}
