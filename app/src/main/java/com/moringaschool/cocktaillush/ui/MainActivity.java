package com.moringaschool.cocktaillush.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.cocktaillush.Constants;
import com.moringaschool.cocktaillush.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private DatabaseReference mSearchedNameReference;
    private ValueEventListener mSearchedNameReferenceListener;
  //  public static final String TAG = MainActivity.class.getSimpleName();
//    private Button mFindCocktailButton;
//    private EditText mNameEditText;
//    private TextView mAppNameTextView;
    @BindView(R.id. findCocktailButton) Button  mFindCocktailButton;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.savedCocktailsButton) Button mSavedCocktailsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSearchedNameReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_NAME);//pinpoint name node

        mSearchedNameReference.addValueEventListener(new ValueEventListener() { //attach listener

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) { //something changed!
                for (DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
                    String name = nameSnapshot.getValue().toString();
                    Log.d("Name updated", "name: " + name); //log
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { //update UI here if error occurred.

            }
        });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // ButterKnife.bind(this);
//        mNameEditText = (EditText) findViewById(R.id.nameEditText);
//        mFindCocktailButton = (Button)findViewById(R.id.findCocktailButton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);


        mFindCocktailButton.setOnClickListener(this);
        mSavedCocktailsButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v == mFindCocktailButton) {
            String name = mNameEditText.getText().toString();
            saveNameToFirebase(name);
            Intent intent = new Intent(MainActivity.this, CocktailListActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);

               //Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();
        }
        if(v == mSavedCocktailsButton){
            Intent intent = new Intent(MainActivity.this, SavedCocktailListActivity.class);
            startActivity(intent);
        }
    }


    public void saveNameToFirebase(String name) {
        mSearchedNameReference.push().setValue(name);
       // mSearchedNameReference.setValue(name);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedNameReference.removeEventListener(mSearchedNameReferenceListener);
    }

}