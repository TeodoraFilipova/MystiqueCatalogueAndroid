package com.example.mystiquecatalogue_android.views.products.Food;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Food;
import com.example.mystiquecatalogue_android.repositories.FirebaseRepository;
import com.example.mystiquecatalogue_android.repositories.base.Repository;
import com.example.mystiquecatalogue_android.uiutils.Navigator;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Navigator mNavigator;
    private ListView mFoodListView;
    private ArrayAdapter<String> mFoodListAdapter;
    private FirebaseFirestore mdb;
    private Repository<Food> mFoodRepository;

    public FoodListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_list, viewGroup, false);

        mdb = FirebaseFirestore.getInstance();

        mFoodListView = view.findViewById(R.id.lv_food);
        mFoodListAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);

        mFoodListView.setAdapter(mFoodListAdapter);
        mFoodListView.setOnItemClickListener(this);

        mFoodRepository = new FirebaseRepository<>(Food.class);

        mFoodRepository.getAll(foods -> {
            for (Food food : foods) {
                mFoodListAdapter.add(food.name);
            }
        });

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String food = mFoodListAdapter.getItem(position);
        mNavigator.navigateWith(food);
    }


    public void setmNavigator(Navigator navigator) {
        mNavigator = navigator;
    }


    public static FoodListFragment newInstance() {
        return new FoodListFragment();
    }
}
