package com.moringaschool.cocktaillush.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.cocktaillush.Constants;
import com.moringaschool.cocktaillush.R;
import com.moringaschool.cocktaillush.models.Drink;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CocktailDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CocktailDetailFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.cocktailImageView)
    ImageView mImageLabel;
    @BindView(R.id.cocktailNameTextView)
    TextView mNameLabel;
    @BindView(R.id.cocktailClassTextView)
    TextView mClassLabel;
    @BindView(R.id.instructionsTextView)
    TextView mInstructionsLabel;
    @BindView(R.id.tagsTextView)
    TextView mTagsLabel;
    @BindView(R.id.feedbackTextView)
    TextView mFeedbackLabel;
    @BindView(R.id.categoryTextView)
    TextView mCategoryLabel;
    @BindView(R.id.saveCocktailButton)
    TextView mSaveCocktailButton;


    private Drink mCocktail;


    public CocktailDetailFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CocktailDetailFragment newInstance(Drink cocktail) {
        CocktailDetailFragment cocktailDetailFragment = new CocktailDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("cocktail", Parcels.wrap(cocktail));
        cocktailDetailFragment.setArguments(args);
        return cocktailDetailFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCocktail = Parcels.unwrap(getArguments().getParcelable("cocktail"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cocktail_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mCocktail.getStrDrinkThumb()).into(mImageLabel);

        // List<String> drinks = new ArrayList<>();


        mNameLabel.setText(mCocktail.getStrDrink());
        mClassLabel.setText(mCocktail.getStrAlcoholic());
        mInstructionsLabel.setText(mCocktail.getStrInstructions());
        mTagsLabel.setText(mCocktail.getStrTags());
        mFeedbackLabel.setText(mCocktail.getStrInstructionsIT());
        mCategoryLabel.setText(mCocktail.getStrGlass());

        mSaveCocktailButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mTagsLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mCocktail.getStrImageSource()));
            startActivity(webIntent);
        }
        //if (v == mSaveCocktailButton) {
            if (v == mSaveCocktailButton) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();
                DatabaseReference cocktailRef = FirebaseDatabase
                        .getInstance()
                        .getReference(Constants.FIREBASE_CHILD_COCKTAILS)
                        .child(uid);
               // cocktailRef.push().setValue(mCocktail);


                DatabaseReference pushRef = cocktailRef.push();
                String pushId = pushRef.getKey();
                mCocktail.setPushId(pushId);
                pushRef.setValue(mCocktail);

                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
            }


    }
}