package com.tutorial.healthapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.tutorial.healthapp.Adapter.BestDealAdapter;
import com.tutorial.healthapp.Adapter.CategoryAdapter;
import com.tutorial.healthapp.Domain.CategoryDomain;
import com.tutorial.healthapp.Domain.ItemsDomain;
import com.tutorial.healthapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter catAdapter, bestDealAdapter;
    private RecyclerView recyclerViewCat, recyclerViewBestDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecylerViewCat();
        initLocation();
        initRecyclerViewBestDeal();

    }

    private void initLocation() {
        String[] items = new String[]{
                "LosAngles, USA",
                "NewYork, USA",
                "Tokyo, Japan"
        };
        final Spinner locationSpin = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpin.setAdapter(adapter);
    }

    private void initRecylerViewCat() {
        ArrayList<CategoryDomain> items = new ArrayList<>();
        items.add(new CategoryDomain("cat1", "Vegetable"));
        items.add(new CategoryDomain("cat2", "Fruits"));
        items.add(new CategoryDomain("cat3", "Dairy"));
        items.add(new CategoryDomain("cat4", "Drinks"));
        items.add(new CategoryDomain("cat5", "Grain"));

        recyclerViewCat = findViewById(R.id.catView);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
        ));

        catAdapter = new CategoryAdapter(items);
        recyclerViewCat.setAdapter(catAdapter);
    }

    private void initRecyclerViewBestDeal(){
        recyclerViewBestDeal = findViewById(R.id.bestView);
        recyclerViewBestDeal.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
        ));

        bestDealAdapter = new BestDealAdapter(getData());
        recyclerViewBestDeal.setAdapter(bestDealAdapter);
    }

    public ArrayList<ItemsDomain> getData(){
        ArrayList<ItemsDomain> items = new ArrayList<>();
        items.add(new ItemsDomain("orange","Fresh Orange",6.2,"With its vibrant orange hue and a burst of refreshing citrus flavor, the juicy orange is a natural source of vitamin C, invigorating your senses and supporting your immune system. A delightful snack that combines health and taste.",4));
        items.add(new ItemsDomain("apple","Fresh Apple",6.5,"With its vibrant orange hue and a burst of refreshing citrus flavor, the juicy orange is a natural source of vitamin C, invigorating your senses and supporting your immune system. A delightful snack that combines health and taste.",4.8));
        items.add(new ItemsDomain("watermelon","Fresh Watermelon",7.0,"With its vibrant orange hue and a burst of refreshing citrus flavor, the juicy orange is a natural source of vitamin C, invigorating your senses and supporting your immune system. A delightful snack that combines health and taste.",5.0));
        items.add(new ItemsDomain("berry","Fresh Berry",10.3,"With its vibrant orange hue and a burst of refreshing citrus flavor, the juicy orange is a natural source of vitamin C, invigorating your senses and supporting your immune system. A delightful snack that combines health and taste.",3.0));
        items.add(new ItemsDomain("pineapple","Fresh Pineapple",3.5,"With its vibrant orange hue and a burst of refreshing citrus flavor, the juicy orange is a natural source of vitamin C, invigorating your senses and supporting your immune system. A delightful snack that combines health and taste.",4.1));
        items.add(new ItemsDomain("strawberry","Fresh Strawberry",15.0,"With its vibrant orange hue and a burst of refreshing citrus flavor, the juicy orange is a natural source of vitamin C, invigorating your senses and supporting your immune system. A delightful snack that combines health and taste.",2.0));

        return items;
    }

}