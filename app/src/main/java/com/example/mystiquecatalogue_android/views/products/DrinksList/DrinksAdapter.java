package com.example.mystiquecatalogue_android.views.products.DrinksList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder> {
    private List<Product> mDrinks;
    private DrinksAdapter.OnDrinkClickListener mOnDrinkClickListener;

    @Inject
    public DrinksAdapter() {
        mDrinks = new ArrayList<>();
    }

    @NonNull
    @Override
    public DrinksAdapter.DrinksViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drinks_item, parent, false);
        int height = parent.getMeasuredHeight() / 2;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.setMinimumHeight(height);
        return new DrinksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksViewHolder holder, int position) {
        holder.setOnClickListener(mOnDrinkClickListener);
        holder.bind(mDrinks.get(position));
    }

    @Override
    public int getItemCount() {
        return mDrinks.size();
    }

    public Product getItem(int position) {
        return mDrinks.get(position);
    }

    public void clear() {
        mDrinks.clear();
    }

    public void addAll(List<Product> drinks) {
        mDrinks.addAll(drinks);
    }

    public void setOnDrinkClickListener(DrinksAdapter.OnDrinkClickListener
                                                onDrinkClickListener) {
        this.mOnDrinkClickListener = onDrinkClickListener;
    }

    public static class DrinksViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_drinkname)
        TextView mNameTextView;

 /*       @BindView(R.id.tv_category)
        TextView mCategoryTextView;
*/
       /* @BindView(R.id.tv_type)
        TextView mTypeTextView;
*/
        @BindView(R.id.tv_drinksize)
        TextView mSizeTextView;

        @BindView(R.id.tv_drinkunits)
        TextView mUnitsTextView;

        @BindView(R.id.tv_drinkprice)
        TextView mPriceTextView;

       /* @BindView(R.id.tv_number)
        TextView mNumberTextView;*/

        @BindView(R.id.iv_drinks)
        ImageView mDrinkImageView;

        private DrinksAdapter.OnDrinkClickListener mOnClickListener;
        private Product mDrink;

        DrinksViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Product drink) {
            mNameTextView.setText(drink.getName());
//            mCategoryTextView.setText(drink.getCategory());
//            mTypeTextView.setText(drink.getType());
            mUnitsTextView.setText(drink.getUnits());
            mSizeTextView.setText(String.valueOf(drink.getSize()));
//            mNumberTextView.setText(String.valueOf(drink.getNumber()));
            mPriceTextView.setText(String.valueOf(drink.getPrice()));
            Picasso.get()
                    .load(drink.getImageUrl())
                    .into(mDrinkImageView);
            mDrink = drink;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mDrink);
        }

        public void setOnClickListener(DrinksAdapter.OnDrinkClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnDrinkClickListener {
        void onClick(Product drink);
    }

}
