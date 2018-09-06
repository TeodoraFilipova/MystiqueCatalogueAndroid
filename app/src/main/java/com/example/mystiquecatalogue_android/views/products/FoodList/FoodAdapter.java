package com.example.mystiquecatalogue_android.views.products.FoodList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Product;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Product> mFood;
    private FoodAdapter.OnFoodClickListener mOnFoodClickListener;

    @Inject
    public FoodAdapter() {
        mFood = new ArrayList<>();
    }

    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item, parent, false);
        int height = parent.getMeasuredHeight() / 2;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.setMinimumHeight(height);
        return new FoodAdapter.FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        holder.setOnClickListener(mOnFoodClickListener);
        holder.bind(mFood.get(position));
    }

    @Override
    public int getItemCount() {
        return mFood.size();
    }

    public Product getItem(int position) {
        return mFood.get(position);
    }

    public void clear() {
        mFood.clear();
    }

    public void addAll(List<Product> food) {
        mFood.addAll(food);
    }

    public void setOnFoodClickListener(FoodAdapter.OnFoodClickListener
                                                onFoodClickListener) {
        this.mOnFoodClickListener = onFoodClickListener;
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mNameTextView;

        /*       @BindView(R.id.tv_category)
               TextView mCategoryTextView;
       */
       /* @BindView(R.id.tv_type)
        TextView mTypeTextView;
*/
        @BindView(R.id.tv_units)
        TextView mUnitsTextView;

        @BindView(R.id.tv_size)
        TextView mSizeTextView;

       /* @BindView(R.id.tv_number)
        TextView mNumberTextView;*/

        @BindView(R.id.iv_food)
        ImageView mFoodImageView;

        private FoodAdapter.OnFoodClickListener mOnClickListener;
        private Product mFood;

        FoodViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Product food) {
            mNameTextView.setText(food.getName());
//            mCategoryTextView.setText(food.getCategory());
//            mTypeTextView.setText(food.getType());
            mUnitsTextView.setText(food.getUnits());
            mSizeTextView.setText(String.valueOf(food.getSize()));
//            mNumberTextView.setText(String.valueOf(food.getNumber()));
            Picasso.get()
                    .load(food.getImageUrl())
                    .into(mFoodImageView);
            mFood = food;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mFood);
        }

        public void setOnClickListener(FoodAdapter.OnFoodClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnFoodClickListener {
        void onClick(Product food);
    }

}
