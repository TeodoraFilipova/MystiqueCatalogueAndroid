package com.example.mystiquecatalogue_android.views.products.Drinks;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Drink;
import com.example.mystiquecatalogue_android.repositories.FirebaseRepository;
import com.example.mystiquecatalogue_android.repositories.base.Repository;
import com.example.mystiquecatalogue_android.uiutils.Navigator;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrinksListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Navigator mNavigator;
    private ListView mDrinksListView;
    private ArrayAdapter<String> mDrinksListAdapter;
    private FirebaseFirestore mdb;
    private Repository<Drink> mDrinksRepository;

    public DrinksListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drinks_list, viewGroup, false);

        mdb = FirebaseFirestore.getInstance();

        mDrinksListView = view.findViewById(R.id.lv_drinks);
        mDrinksListAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);

        mDrinksListView.setAdapter(mDrinksListAdapter);
        mDrinksListView.setOnItemClickListener(this);

        mDrinksRepository = new FirebaseRepository<>(Drink.class);

        mDrinksRepository.getAll(drinks -> {
            for (Drink drink : drinks) {
                mDrinksListAdapter.add(drink.name);
            }
        });

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String drink = mDrinksListAdapter.getItem(position);
        mNavigator.navigateWith(drink);
    }


    public void setmNavigator(Navigator navigator) {
        mNavigator = navigator;
    }


    public static DrinksListFragment newInstance() {
        return new DrinksListFragment();
    }
}
