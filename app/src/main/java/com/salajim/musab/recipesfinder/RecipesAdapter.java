package com.salajim.musab.recipesfinder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Musab on 1/1/2018.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder> {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    private ArrayList<Recipes> mRecipes = new ArrayList<>();
    private Context mContext;

    public RecipesAdapter(Context context, ArrayList<Recipes> recipes) {
        mContext = context;
        mRecipes = recipes;
    }

    @Override
    public RecipesAdapter.RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipes, parent, false);
        RecipesViewHolder viewHolder = new RecipesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipesAdapter.RecipesViewHolder holder, int position) {
        holder.bindRecipes(mRecipes.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public class RecipesViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.recipesImageView) ImageView mRecipesImageView;
        @Bind(R.id.recipesName) TextView mRecipesNameTextView;
        @Bind(R.id.rating) TextView mRating;

        private Context mContext;

        public RecipesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRecipes(Recipes recipes) {
            Picasso.with(mContext)
                    .load(recipes.getSmallImageUrls())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mRecipesImageView);

            mRecipesNameTextView.setText(recipes.getRecipeName());
            mRating.setText(recipes.getRating());
        }
    }


}
