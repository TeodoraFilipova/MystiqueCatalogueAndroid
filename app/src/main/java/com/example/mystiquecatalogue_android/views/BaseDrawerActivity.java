package com.example.mystiquecatalogue_android.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.mystiquecatalogue_android.views.contacts.ContactsActivity;
import com.example.mystiquecatalogue_android.views.products.ProductActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public abstract class BaseDrawerActivity extends AppCompatActivity {


    private void setupDrawer() {
        //if you want to update the items at a later timeit is recommended to keep it in a variable
        PrimaryDrawerItem mainItem = new PrimaryDrawerItem()
                .withIdentifier(MainActivity.IDENTIFIER)
                .withName("Main Page");
        PrimaryDrawerItem listProductItem = new PrimaryDrawerItem()
                .withIdentifier(ProductActivity.IDENTIFIER)
                .withName("Products Catalogue");
        /*PrimaryDrawerItem promotionItem = new PrimaryDrawerItem()
                .withIdentifier(PromotionActivity.IDENTIFIER)
                .withName("Week Promotion");*/
        PrimaryDrawerItem contactItem = new PrimaryDrawerItem()
                .withIdentifier(ContactsActivity.IDENTIFIER)
                .withName("Contacts");

        //create the drawer and remember the `Drawer` result object
        DrawerBuilder drawerBuilder = new DrawerBuilder();
        drawerBuilder.withActivity(this);
        drawerBuilder.withToolbar(getDrawerToolbar());
        drawerBuilder.addDrawerItems(
                mainItem,
                new DividerDrawerItem(),
                listProductItem,
               /* new DividerDrawerItem(),
                promotionItem,*/
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
        } else if (identifier == ProductActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, ProductActivity.class
            );
        } /*else if (identifier == PromotionActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, PromotionActivity.class
            );
        }*/ else if (identifier == ContactsActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, ContactsActivity.class
            );
        }
        return null;
    }

    protected abstract long getIdentifier();

    protected abstract Toolbar getDrawerToolbar();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }

}
