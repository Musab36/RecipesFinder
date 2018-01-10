package com.salajim.musab.recipesfinder;

import android.util.Log;

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
    public static void findRecipes(String results, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.RECIPES_BASE_URL).newBuilder();
        //urlBuilder.addQueryParameter(Constants.ApiKey, matches);

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

        Log.v("url", url);
    }

    public ArrayList<Recipes> processResults(Response response) {
        ArrayList<Recipes> recipes = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject recipesJSON = new JSONObject(jsonData);
                JSONArray matchesJSON = recipesJSON.getJSONArray("results");
                for(int i = 0; i < matchesJSON.length(); i ++) {
                    JSONObject recipeJSON = matchesJSON.getJSONObject(i);
                    String smallImageUrls = recipeJSON.getString("thumbnail");
                    String recipeName = recipeJSON.getString("title");
                    //String rating = recipeJSON.getString("href");

                    Recipes recipe = new Recipes(smallImageUrls, recipeName);
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
