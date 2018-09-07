package com.example.mystiquecatalogue_android.views.products.DomesticList;

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

public class DomesticAdapter extends RecyclerView.Adapter<DomesticAdapter.DomesticViewHolder> {
    private List<Product> mDomestic;
    private DomesticAdapter.OnDomesticClickListener mOnDomesticClickListener;

    @Inject
    public DomesticAdapter() {
        mDomestic = new ArrayList<>();
    }

    @NonNull
    @Override
    public DomesticAdapter.DomesticViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.domestic_item, parent, false);
        int height = parent.getMeasuredHeight() / 2;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.setMinimumHeight(height);
        return new DomesticAdapter.DomesticViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DomesticAdapter.DomesticViewHolder holder, int position) {
        holder.setOnClickListener(mOnDomesticClickListener);
        holder.bind(mDomestic.get(position));
    }

    @Override
    public int getItemCount() {
        return mDomestic.size();
    }

    public Product getItem(int position) {
        return mDomestic.get(position);
    }

    public void clear() {
        mDomestic.clear();
    }

    public void addAll(List<Product> domestic) {
        mDomestic.addAll(domestic);
    }

    public void setOnDomesticClickListener(DomesticAdapter.OnDomesticClickListener
                                                onDomesticClickListener) {
        this.mOnDomesticClickListener = onDomesticClickListener;
    }

    public static class DomesticViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_domesticname)
        TextView mNameTextView;

       /* @BindView(R.id.tv_domesticcategory)
        TextView mCategoryTextView;

        @BindView(R.id.tv_domestictype)
        TextView mTypeTextView;*/

        @BindView(R.id.tv_domesticsize)
        TextView mSizeTextView;

        @BindView(R.id.tv_domesticunits)
        TextView mUnitsTextView;

        /*@BindView(R.id.tv_number)
        TextView mNumberTextView;*/

        @BindView(R.id.tv_domesticprice)
        TextView mPriceTextView;

        @BindView(R.id.iv_domestic)
        ImageView mDomesticImageView;

        private DomesticAdapter.OnDomesticClickListener mOnClickListener;
        private Product mDomestic;

        DomesticViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Product domestic) {
            mNameTextView.setText(domestic.getName());
//            mCategoryTextView.setText(domestic.getCategory());
//            mTypeTextView.setText(domestic.getType());

            mSizeTextView.setText(String.valueOf(domestic.getSize()));

            mUnitsTextView.setText(domestic.getUnits());
//            mNumberTextView.setText(String.valueOf(domestic.getNumber()));
            mPriceTextView.setText(String.valueOf(domestic.getPrice()));

            Picasso.get()
                    .load(domestic.getImageUrl())
                    .into(mDomesticImageView);
            mDomestic = domestic;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mDomestic);
        }

        public void setOnClickListener(DomesticAdapter.OnDomesticClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnDomesticClickListener {
        void onClick(Product domestic);
    }

}