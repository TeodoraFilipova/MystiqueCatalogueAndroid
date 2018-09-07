package com.example.mystiquecatalogue_android.views.products.WishList;

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

public class WishAdapter extends RecyclerView.Adapter<WishAdapter.WishViewHolder> {
    private List<Product> mWish;
    private WishAdapter.OnWishClickListener mOnWishClickListener;

    @Inject
    public WishAdapter() {
        mWish = new ArrayList<>();
    }

    @NonNull
    @Override
    public WishAdapter.WishViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wished_item, parent, false);
        int height = parent.getMeasuredHeight() / 3;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.setMinimumHeight(height);
        return new WishAdapter.WishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishAdapter.WishViewHolder holder, int position) {
        holder.setOnClickListener(mOnWishClickListener);
        holder.bind(mWish.get(position));
    }

    @Override
    public int getItemCount() {
        return mWish.size();
    }

    public Product getItem(int position) {
        return mWish.get(position);
    }

    public void clear() {
        mWish.clear();
    }

    public void addAll(List<Product> drinks) {
        mWish.addAll(drinks);
    }

    public void setOnWishClickListener(WishAdapter.OnWishClickListener
                                               onWishClickListener) {
        this.mOnWishClickListener = onWishClickListener;
    }

    public static class WishViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_wishedname)
        TextView mNameTextView;

        @BindView(R.id.tv_wishedprice)
        TextView mPriceTextView;


        @BindView(R.id.iv_wished)
        ImageView mWishImageView;

        private WishAdapter.OnWishClickListener mOnClickListener;
        private Product mWish;

        WishViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Product wishedproduct) {
            mNameTextView.setText(wishedproduct.getName());
            mPriceTextView.setText(String.valueOf(wishedproduct.getPrice()));
            Picasso.get()
                    .load(wishedproduct.getImageUrl())
                    .into(mWishImageView);
            mWish = wishedproduct;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mWish);
        }

        public void setOnClickListener(WishAdapter.OnWishClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnWishClickListener {
        void onClick(Product wishedproduct);
    }
}
