package com.example.mystiquecatalogue_android.repositories;


import com.example.mystiquecatalogue_android.repositories.base.Repository;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.function.Consumer;

public class FirebaseRepository<T> implements Repository<T> {

    private final FirebaseFirestore mdb;
    private final Class<T> mKlass;
    private final String mCollectionName;

    public FirebaseRepository(Class<T> klass) {
        mdb = FirebaseFirestore.getInstance();
        mKlass = klass;
        mCollectionName = klass.getSimpleName().toLowerCase() + "s";
    }


    @Override
    public void getAll(Consumer<List<T>> action) {
        mdb.collection(mCollectionName)
                .get()
                .addOnCompleteListener(task -> {
                    List<T> items = task.getResult()
                            .toObjects(mKlass);
                    action.accept(items);
                });

    }

    @Override
    public void add(T item, Consumer<T> action) {
        mdb.collection(mCollectionName)
                .add(item)
                .addOnCompleteListener(task -> {
                    action.accept(item);
                });
    }
}
