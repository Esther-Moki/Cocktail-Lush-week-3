package com.moringaschool.cocktaillush.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    //  public static final String TAG = MainActivity.class.getSimpleName();
//    private Button mFindCocktailButton;
//    private EditText mNameEditText;
//    private TextView mAppNameTextView;
    @BindView(R.id. findCocktailButton) Button  mFindCocktailButton;
  //  @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.savedCocktailsButton) Button mSavedCocktailsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        mSearchedNameReference = FirebaseDatabase
//                .getInstance()
//                .getReference()
//                .child(Constants.FIREBASE_CHILD_SEARCHED_NAME);//pinpoint name node
//
//        mSearchedNameReference.addValueEventListener(new ValueEventListener() { //attach listener
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) { //something changed!
//                for (DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
//                    String name = nameSnapshot.getValue().toString();
//                    Log.d("Name updated", "name: " + name); //log
//                }
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) { //update UI here if error occurred.
//
//            }
//        });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // ButterKnife.bind(this);
//        mNameEditText = (EditText) findViewById(R.id.nameEditText);
//        mFindCocktailButton = (Button)findViewById(R.id.findCocktailButton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);


        mFindCocktailButton.setOnClickListener(this);
        mSavedCocktailsButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //code for displaying the welcome message
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    @Override
    public void onClick(View v) {
        if(v == mFindCocktailButton) {
         //   String name = mNameEditText.getText().toString();
           // saveNameToFirebase(name);
            Intent intent = new Intent(MainActivity.this, CocktailListActivity.class);
          //  intent.putExtra("name", name);
            startActivity(intent);

               //Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();
        }
        if(v == mSavedCocktailsButton){
            Intent intent = new Intent(MainActivity.this, SavedCocktailListActivity.class);
            startActivity(intent);
        }
    }


//    public void saveNameToFirebase(String name) {
//        mSearchedNameReference.push().setValue(name);
//       // mSearchedNameReference.setValue(name);
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mSearchedNameReference.removeEventListener(mSearchedNameReferenceListener);
//    }

    //inflate the new menu in an onCreateOptionsMenu() method within Main Acitivty
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //action to perform when the user selects the logout option
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
         //after logging out we return the user to the Login Activity and add flags to remove the current activity from our stack
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();//used here for ending the current instance of MainActivity
    }

}