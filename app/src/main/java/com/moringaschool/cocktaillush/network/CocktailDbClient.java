package com.moringaschool.cocktaillush.network;


import static com.moringaschool.cocktaillush.Constants.YELP_API_KEY;
import static com.moringaschool.cocktaillush.Constants.YELP_BASE_URL;

import com.moringaschool.cocktaillush.network.CocktailApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CocktailDbClient {

   // private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    private static Retrofit retrofit = null;

    public static CocktailApi getClient() {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest  = chain.request().newBuilder()
                                   .addHeader("Authorization", YELP_API_KEY)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(YELP_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(CocktailApi.class);
    }
}
