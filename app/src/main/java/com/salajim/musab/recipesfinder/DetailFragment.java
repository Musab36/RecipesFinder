package com.salajim.musab.recipesfinder;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener{
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    @Bind(R.id.recipesImageView) ImageView mRecipesImageView;
    @Bind(R.id.ingredients) TextView mIngredients;
    @Bind(R.id.href) TextView mHref;

    private Recipes mRecipes;

    public static DetailFragment newInstance(Recipes recipes) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipes", Parcels.wrap(recipes));
        detailFragment.setArguments(args);
        return detailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecipes = Parcels.unwrap(getArguments().getParcelable("recipes"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext())
                .load(mRecipes.getSmallImageUrls())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mRecipesImageView);

        mIngredients.setText("Ingredients:\n " + mRecipes.getIngredients());
        mHref.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == mHref) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mRecipes.getHref()));
            startActivity(intent);
        }
    }
}
