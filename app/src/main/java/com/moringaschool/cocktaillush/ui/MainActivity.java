package com.moringaschool.cocktaillush.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.moringaschool.cocktaillush.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  //  public static final String TAG = MainActivity.class.getSimpleName();
//    private Button mFindCocktailButton;
//    private EditText mNameEditText;
//    private TextView mAppNameTextView;
    @BindView(R.id. findCocktailButton) Button  mFindCocktailButton;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mNameEditText = (EditText) findViewById(R.id.nameEditText);
//        mFindCocktailButton = (Button)findViewById(R.id.findCocktailButton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);


        mFindCocktailButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mFindCocktailButton) {
            String name = mNameEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, CocktailListActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);

               //Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();
        }
    }


}