
package com.moringaschool.cocktaillush.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.cocktaillush.models.Drink;

import org.parceler.Parcel;

@Parcel
@Generated("jsonschema2pojo")
public class CocktailSearchResponse {

    @SerializedName("drinks")
    @Expose
    public List<Drink> drinks = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CocktailSearchResponse() {
    }

    /**
     * 
     * @param drinks
     */
    public CocktailSearchResponse(List<Drink> drinks) {
        super();
        this.drinks = drinks;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

}
