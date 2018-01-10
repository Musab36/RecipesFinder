package com.salajim.musab.recipesfinder;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Musab on 1/10/2018.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Recipes> mRecipes;

    public PagerAdapter(FragmentManager fm, ArrayList<Recipes> recipes) {
        super(fm);
        mRecipes = recipes;
    }

    @Override
    public Fragment getItem(int position) {
        return DetailFragment.newInstance(mRecipes.get(position));
    }

    @Override
    public int getCount() {
        return mRecipes.size();
    }

    /*

    @Override
    public CharSequence getPageTitle() {
        return mRecipes.get(position).getTitle();
    }
    */
}
