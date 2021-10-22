package com.moringaschool.cocktaillush.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.cocktaillush.R;
import com.moringaschool.cocktaillush.models.Drink;
import com.moringaschool.cocktaillush.ui.CocktailDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CocktailListadapter  extends RecyclerView.Adapter<CocktailListadapter.CocktailViewHolder> {
    private List<Drink> mCocktails;
    private Context mContext;

    public CocktailListadapter(Context context, List<Drink> cocktails) {
        mContext = context;
        mCocktails = cocktails;
    }

    @NonNull
    @Override
    public CocktailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cocktail_list_item, parent, false);
        CocktailViewHolder viewHolder = new CocktailViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CocktailViewHolder holder, int position) {
            holder.bindCocktail(mCocktails.get(position));
    }

    @Override
    public int getItemCount() {
        return mCocktails.size();
    }

    public class CocktailViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        @BindView(R.id.cocktailImageView) ImageView mCocktailImageView;
        @BindView(R.id.cocktailNameTextView) TextView mNameTextView;
        @BindView(R.id.instructionsTextView) TextView mInstructionsTextView;
        @BindView(R.id.cocktailClassTextView) TextView mCocktailClassTextView;

        private Context mContext;

        public CocktailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindCocktail(Drink cocktail) {
            Picasso.get().load(cocktail.getStrDrinkThumb()).into(mCocktailImageView);
            mNameTextView.setText(cocktail.getStrDrink());
            mInstructionsTextView.setText(cocktail.getStrInstructions());
            mCocktailClassTextView.setText("Type: " + cocktail.getStrAlcoholic());
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, CocktailDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("cocktails", Parcels.wrap(mCocktails));
            mContext.startActivity(intent);
        }
    }
}
