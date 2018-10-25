package com.bheemapps.cvvalidator.utilityapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {

    private static final String TAG = "PeopleActivity";

    MainViewModel model;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        model = ViewModelProviders.of(this).get(MainViewModel.class);
        model.loadItemsList();
        recyclerView = findViewById(R.id.rv_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        model.getItemsList().observe(this, new Observer<ItemsList>() {
            @Override
            public void onChanged(@Nullable ItemsList itemsList) {
                if (itemsList != null) {
                    processChange(itemsList);
                }
            }
        });
    }

    private void processChange(ItemsList itemsList) {
        showItemsList(itemsList.strings);
    }

    private void showItemsList(List<String> peopleList) {
        CustomAdapter customAdapter = new CustomAdapter(peopleList, this, this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onRecyclerViewItemClicked(String name) {
        Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(this, DetailActivity.class);
        Bundle bundle= new Bundle();
        bundle.putString("FeatureName", name);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
