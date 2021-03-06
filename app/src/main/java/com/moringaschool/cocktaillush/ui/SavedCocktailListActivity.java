package com.moringaschool.cocktaillush.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.cocktaillush.Constants;
import com.moringaschool.cocktaillush.R;
import com.moringaschool.cocktaillush.adapters.FirebaseCocktailViewHolder;
import com.moringaschool.cocktaillush.models.Drink;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedCocktailListActivity extends AppCompatActivity {
    private DatabaseReference mCocktailReference;
    private FirebaseRecyclerAdapter<Drink, FirebaseCocktailViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mCocktailReference =FirebaseDatabase
                            .getInstance()
                            .getReference(Constants.FIREBASE_CHILD_COCKTAILS)
                            .child(uid);

        setUpFirebaseAdapter();
        hideProgressBar();
        showCocktails();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Drink> options =
                new FirebaseRecyclerOptions.Builder<Drink>()
                        .setQuery(mCocktailReference,   Drink.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Drink, FirebaseCocktailViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseCocktailViewHolder firebaseCocktailViewHolder, int position, @NonNull Drink cocktail) {
                firebaseCocktailViewHolder.bindRestaurant(cocktail);
            }

            @NonNull
            @Override
            public FirebaseCocktailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cocktail_list_item, parent, false);
                return new FirebaseCocktailViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

    private void showCocktails() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}