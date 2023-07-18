package com.izdeveloper.wishlistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    private Adapter adapterList;
    private Storage list;
    private RecyclerView RW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView btnSortByAlph, btnSortByTime;
        list = Storage.getSingle();

        RW = findViewById(R.id.rv);
        RW.setLayoutManager(new LinearLayoutManager(this));

        adapterList = new Adapter(getApplicationContext(), list.getItems());
        RW.setAdapter(adapterList);

        btnSortByAlph = findViewById(R.id.btnSortByAlph);
        btnSortByTime = findViewById(R.id.btnSortByTime);

        btnSortByTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sortWithTime();
            }
        });

        btnSortByAlph.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sortWithAlph();

            }
        });

    }
    private void sortWithTime() {
        ArrayList<Article> allItems, sortedItems;

        allItems = list.getItems();
        sortedItems = new ArrayList<>(allItems.size());

        for (Article c : allItems) {
            boolean yesorno = false;

            for (int i = 0; i < sortedItems.size(); i++) {

                if (c.getTimeOfAddition() < sortedItems.get(i).getTimeOfAddition()) {
                    sortedItems.add(i, c);

                    yesorno = true;

                    break;
                }
            }
            if (!yesorno) {
                sortedItems.add(c);

            }
        }

        allItems.clear();
        allItems.addAll(sortedItems);
        adapterList.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapterList = new Adapter(getApplicationContext(), list.getItems());
        RW.setAdapter(adapterList);

        adapterList.notifyDataSetChanged();

    }

    public void switchToAAA(View view) {
        Intent i = new Intent(this, AddItemActivity.class);

        startActivity(i);
    }

    private void sortWithAlph() {
        ArrayList<String> itemNames = new ArrayList<>();
        for (Article item : list.getItems()) {
            itemNames.add(item.getItemName());
        }
        Collections.sort(itemNames);

        ArrayList<Article> sortedItems = new ArrayList<>();
        for (String itemName : itemNames) {
            boolean yesorno = false;

            for (int i = 0; i < sortedItems.size(); i++) {

                Article c = sortedItems.get(i);

                if (c.getItemName().equals(itemName)) {
                    sortedItems.add(i, c);
                    yesorno = true;

                    break;
                }
            }

            if (!yesorno) {
                for (Article a : list.getItems()) {
                    if (a.getItemName().equals(itemName)) {
                        sortedItems.add(a);

                        break;
                    }
                }
            }
        }

        list.getItems().clear();
        list.getItems().addAll(sortedItems);
        adapterList.notifyDataSetChanged();
    }
}
