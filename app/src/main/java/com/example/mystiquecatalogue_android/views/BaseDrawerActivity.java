package com.example.mystiquecatalogue_android.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.mystiquecatalogue_android.R;
import com.example.mystiquecatalogue_android.views.contacts.ContactsActivity;
import com.example.mystiquecatalogue_android.views.products.DomesticList.DomesticListActivity;
import com.example.mystiquecatalogue_android.views.products.DrinksList.DrinksListActivity;
import com.example.mystiquecatalogue_android.views.products.FoodList.FoodListActivity;
import com.example.mystiquecatalogue_android.views.products.ProductList.ProductsListActivity;
import com.example.mystiquecatalogue_android.views.products.WishList.WishListActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity() {

    }


    public void setupDrawer() {
        //if you want to update the items at a later timeit is recommended to keep it in a variable
        PrimaryDrawerItem mainItem = new PrimaryDrawerItem()
                .withIdentifier(MainActivity.IDENTIFIER)
                .withName("Main Page");
        PrimaryDrawerItem listProductItem = new PrimaryDrawerItem()
                .withIdentifier(ProductsListActivity.IDENTIFIER)
                .withName("All Products");
        PrimaryDrawerItem drinksItem = new PrimaryDrawerItem()
                .withIdentifier(DrinksListActivity.IDENTIFIER)
                .withName("Drinks");
        PrimaryDrawerItem foodItem = new PrimaryDrawerItem()
                .withIdentifier(FoodListActivity.IDENTIFIER)
                .withName("Food");
        PrimaryDrawerItem domesticItem = new PrimaryDrawerItem()
                .withIdentifier(DomesticListActivity.IDENTIFIER)
                .withName("Domestic goods");
        PrimaryDrawerItem wishedItem = new PrimaryDrawerItem()
                .withIdentifier(WishListActivity.IDENTIFIER)
                .withName("Wished products");
        PrimaryDrawerItem contactItem = new PrimaryDrawerItem()
                .withIdentifier(ContactsActivity.IDENTIFIER)
                .withName("Contacts");

        //create the drawer and remember the `Drawer` result object
        DrawerBuilder drawerBuilder = new DrawerBuilder();
        drawerBuilder.withActivity(this);
        drawerBuilder.withToolbar(mToolbar);
        drawerBuilder.addDrawerItems(
                mainItem,
                new DividerDrawerItem(),
                listProductItem,
                new DividerDrawerItem(),
                drinksItem,
                new DividerDrawerItem(),
                foodItem,
                new DividerDrawerItem(),
                domesticItem,
                new DividerDrawerItem(),
                wishedItem,
                new DividerDrawerItem(),
                contactItem
        );
        drawerBuilder.withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(
                    View view,
                    int position,
                    IDrawerItem drawerItem) {
                long identifier = drawerItem.getIdentifier();
                if (getIdentifier() == identifier) {
                    return false;
                }

                Intent intent = getNextIntent(identifier);
                if (intent == null) {
                    return false;
                }
                startActivity(intent);
                return true;
            }
        });
        Drawer drawer = drawerBuilder.build();
    }

    private Intent getNextIntent(long identifier) {
        if (identifier == MainActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, MainActivity.class
            );
        } else if (identifier == ProductsListActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, ProductsListActivity.class
            );
        } else if (identifier == DrinksListActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, DrinksListActivity.class
            );
        }else if (identifier == FoodListActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, FoodListActivity.class
            );
        }else if (identifier == DomesticListActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, DomesticListActivity.class
            );
        }else if (identifier == WishListActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, WishListActivity.class
            );
        }else if (identifier == ContactsActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, ContactsActivity.class
            );
        }
        return null;
    }

    protected abstract long getIdentifier();

    public Toolbar getToolbar() {
        return mToolbar;
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }

}
