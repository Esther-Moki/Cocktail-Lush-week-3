package com.moringaschool.cocktaillush.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.moringaschool.cocktaillush.Constants;
import com.moringaschool.cocktaillush.R;
import com.moringaschool.cocktaillush.adapters.CocktailListadapter;
import com.moringaschool.cocktaillush.models.CocktailSearchResponse;
import com.moringaschool.cocktaillush.models.Drink;
import com.moringaschool.cocktaillush.network.CocktailApi;
import com.moringaschool.cocktaillush.network.CocktailDbClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CocktailListActivity extends AppCompatActivity {
    private static final String TAG = CocktailListActivity.class.getSimpleName();
    private CocktailListadapter mAdapter;


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentName;
//    private TextView mNameTextView;
//    private ListView mListView;

//  @BindView(R.id.listView) ListView mListView;
   // @BindView(R.id.nameTextView) TextView mNameTextView;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;


    public List<Drink> cocktails;


//    private String[] cocktails = new String[] {"Jungle Bird", "Long Island Iced Tea",
//                " Gin Gin Mule", "White Lady", " El Diablo", " Cosmopolitan",
//                "Zombie", " Hanky Panky", "Vodka Martini", " Caipirinha",
//                "Tom Collins", "Bamboo", " Tommy’s Margarita",
//                "Last Word", ". Pina Colada"};
//    private String[] ingredients = new String[] {"Gin", "Absinthe verte", "Tequila", "Brandy",
//            "Armamgnac blanche", "Cognac", "Pavlova vodka", "Vanila infused gin",
//            "Toffee vodka", "Tequila blanco", "Amaretto liqueur", "Cucumber Sake",
//            "Beer-Italian Lager", "Calamansi Juice", "Blue Curacao syrup", "Black Pepper" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentName = mSharedPreferences.getString(Constants.PREFERENCES_NAME_KEY, null);
        if(mRecentName != null) {
            fetchCocktails(mRecentName);

        }
    }

//        mListView = (ListView) findViewById(R.id.listView);
//        mNameTextView = (TextView) findViewById(R.id.nameTextView);

        // ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cocktails);
       // MyCocktailArrayAdapter adapter = new MyCocktailArrayAdapter(this, android.R.layout.simple_list_item_1, cocktails, ingredients); // the arguments must match constructor's parameters!
       // mListView.setAdapter(adapter);

//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                String cocktail = ((TextView) view).getText().toString();
//                Toast.makeText(CocktailActivity.this, cocktail, Toast.LENGTH_LONG).show();
//            }
//        });

        //Intent intent = getIntent();
       // String name = intent.getStringExtra("name");
       // mNameTextView.setText("Here are all the " + name + " cocktails" );

        //API part

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String name) {
                addToSharedPreferences(name);
                fetchCocktails(name);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String name) {
                return false;
            }
        });

        return true;
    }



    private void fetchCocktails(String name){

        CocktailApi client = CocktailDbClient.getClient();

        Call<CocktailSearchResponse> call = client.getCocktails(name);

        call.enqueue(new Callback<CocktailSearchResponse>() {
            @Override
            public void onResponse(Call<CocktailSearchResponse> call, Response<CocktailSearchResponse> response) {
               hideProgressBar();
                if (response.isSuccessful()) {
                   assert response.body() != null;
                    //List<Drink> cocktailsList = response.body().getDrinks();

                    cocktails = response.body().getDrinks();
                    mAdapter = new CocktailListadapter(CocktailListActivity.this, cocktails);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CocktailListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showCocktails();


                   // Log.d("response","response is" + cocktailsList) ;
//                    String[] drink = new String[cocktailsList.size()];
//                    String[] alcoholic = new String[cocktailsList.size()];
//                    String[] instructions = new String[cocktailsList.size()];
//                    String[] glass = new String[cocktailsList.size()];


//                    for (int i = 0; i < drink.length; i++){
//                        drink[i] = cocktailsList.get(i).getStrDrink();
//                    }
//                    for (int i = 0; i < alcoholic.length; i++){
//                        alcoholic[i] = cocktailsList.get(i).getStrAlcoholic();
//                    }
//                    for (int i = 0; i < instructions.length; i++){
//                        instructions[i] = cocktailsList.get(i).getStrIBA();
//                    }
//                    for (int i = 0; i <  glass.length; i++){
//                        glass[i] = cocktailsList.get(i).getStrInstructions();
//                    }

//                    ArrayAdapter adapter
//                            = new MyCocktailArrayAdapter(CocktailActivity.this, android.R.layout.simple_list_item_1, drink,alcoholic,instructions,glass);
//                    mListView.setAdapter(adapter);

                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<CocktailSearchResponse> call, Throwable t) {
                Log.e("Error Message", "onFailure: ",t );
                hideProgressBar();
                showFailureMessage();
            }

        });
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showCocktails() {
        mRecyclerView.setVisibility(View.VISIBLE);
//        mListView.setVisibility(View.VISIBLE);
//        mNameTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void addToSharedPreferences(String name) {
        mEditor.putString(Constants.PREFERENCES_NAME_KEY, name).apply();
    }

}