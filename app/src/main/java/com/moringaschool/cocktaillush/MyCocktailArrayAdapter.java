package com.moringaschool.cocktaillush;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyCocktailArrayAdapter  extends ArrayAdapter {
    private Context mContext;
    private String[] mCocktails;
    private String[] mAlcoholic;
    private String [] mInstructions;
    private String [] mGlass;




    public MyCocktailArrayAdapter(Context mContext, int resource, String[] mCocktails, String[] mAlcoholic,String [] mInstructions,String [] mGlass) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mCocktails = mCocktails;
        this.mAlcoholic = mAlcoholic;
        this.mInstructions = mInstructions;
        this.mGlass = mGlass;

    }

    @Override
    public Object getItem(int position) {
        String cocktail = mCocktails[position];
        String alcoholic = mAlcoholic[position];
        String instructions = mInstructions[position];
        String glass =  mGlass[position];


        return String.format("%s \nThis cocktail is: %s", cocktail, alcoholic +
                "\n It happens to be a: " + instructions +
                "\n The set up instructions for this cocktail are: " + glass);
    }

    @Override
    public int getCount() {
        return mCocktails.length;
    }
}
