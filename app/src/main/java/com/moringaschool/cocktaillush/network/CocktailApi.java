package com.moringaschool.cocktaillush.network;

import com.moringaschool.cocktaillush.models.CocktailSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CocktailApi {
    @GET("search.php?")
    Call<CocktailSearchResponse> getCocktails(
             @Query("s") String name);
}


//www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita