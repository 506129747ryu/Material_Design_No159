package com.tutorial.healthapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tutorial.healthapp.Adapter.CategoryAdapter;
import com.tutorial.healthapp.Domain.CategoryDomain;
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

}