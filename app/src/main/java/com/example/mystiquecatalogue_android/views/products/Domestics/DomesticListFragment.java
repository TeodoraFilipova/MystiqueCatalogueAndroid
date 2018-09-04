package com.example.mystiquecatalogue_android.views.products.Domestics;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.models.Domestic;
import com.example.mystiquecatalogue_android.repositories.FirebaseRepository;
import com.example.mystiquecatalogue_android.repositories.base.Repository;
import com.example.mystiquecatalogue_android.uiutils.Navigator;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 */
public class DomesticListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Navigator mNavigator;
    private ListView mDomesticListView;
    private ArrayAdapter<String> mDomesticListAdapter;
    private FirebaseFirestore mdb;
    private Repository<Domestic> mDomesticRepository;

    public DomesticListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_domestic_list, viewGroup, false);

        mdb = FirebaseFirestore.getInstance();

        mDomesticListView = view.findViewById(R.id.lv_domestic);
        mDomesticListAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);

        mDomesticListView.setAdapter(mDomesticListAdapter);
        mDomesticListView.setOnItemClickListener(this);

        mDomesticRepository = new FirebaseRepository<>(Domestic.class);

        mDomesticRepository.getAll(domestics -> {
            for (Domestic domestic : domestics) {
                mDomesticListAdapter.add(domestic.name);
            }
        });

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String domestic = mDomesticListAdapter.getItem(position);
        mNavigator.navigateWith(domestic);
    }


    public void setmNavigator(Navigator navigator) {
        mNavigator = navigator;
    }


    public static DomesticListFragment newInstance() {
        return new DomesticListFragment();
    }
}
