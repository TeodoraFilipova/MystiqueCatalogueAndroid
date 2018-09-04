package com.example.mystiquecatalogue_android.views.products;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.minkov.androidapp.R;
import com.minkov.androidapp.models.Superhero;
import com.minkov.androidapp.views.BaseDrawerActivity;
import com.minkov.androidapp.views.SuperheroDetails.SuperheroDetailsActivity;
import com.minkov.androidapp.views.SuperheroDetails.SuperheroDetailsFragment;
import com.minkov.androidapp.views.SuperheroDetails.SuperheroDetailsPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SuperheroesListActivity
        extends BaseDrawerActivity
        implements SuperheroesListContracts.Navigator {
    public static final long IDENTIFIER = 49;

    @Inject
    SuperheroesListFragment mSuperheroesListFragment;

    @Inject
    SuperheroesListContracts.Presenter mSuperheroesListPresenter;

    @Inject
    SuperheroDetailsFragment mSuperheroDetailsFragment;

    @Inject
    SuperheroDetailsPresenter mSuperheroDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superheroes_list);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mSuperheroesListFragment.setNavigator(this);
        mSuperheroesListFragment.setPresenter(mSuperheroesListPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mSuperheroesListFragment);

        if (!isPhone()) {
            mSuperheroDetailsFragment.setPresenter(mSuperheroDetailsPresenter);
            transaction.replace(R.id.content_details, mSuperheroDetailsFragment);
        }

        transaction.commit();
    }

    private boolean isPhone() {
        return findViewById(R.id.content_details) == null;
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(Superhero superhero) {
        if (isPhone()) {
            Intent intent = new Intent(
                    this,
                    SuperheroDetailsActivity.class
            );

            intent.putExtra(SuperheroDetailsActivity.EXTRA_KEY, superhero);

            startActivity(intent);
        } else {
            mSuperheroDetailsPresenter.setSuperheroId(superhero.getId());
            mSuperheroDetailsPresenter.loadSuperhero();
        }
    }
}
