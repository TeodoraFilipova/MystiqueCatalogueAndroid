package com.example.mystiquecatalogue_android.views.products.Domestics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mystiquecatalogue_android.R;


public class DomesticDetailsActivity extends AppCompatActivity {

    private TextView mView;
    private DomesticDetailsFragment mDomesticDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domestic_details);

        Intent intent = getIntent();

        String product = intent.getStringExtra("PRUDUCT_NAME");

        mDomesticDetailsFragment = DomesticDetailsFragment.newInstance();
        mDomesticDetailsFragment.setDomestic(product);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.context, mDomesticDetailsFragment)
                .commit();

    }
}
