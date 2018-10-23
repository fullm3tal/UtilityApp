package com.bheemapps.cvvalidator.utilityapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements RecyclerViewClickListener {

    DetailViewModel model;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        model = ViewModelProviders.of(this).get(DetailViewModel.class);
        model.loadItemsList();
        recyclerView = findViewById(R.id.rv_items_detail);
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

    private void showItemsList(List<String> list) {
        CustomAdapter customAdapter = new CustomAdapter(list, this, this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onRecyclerViewItemClicked(int position) {

        Intent intent = new Intent(this, RxCreateActivity.class);
        Bundle bundle = new Bundle();
                bundle.putInt("Key", position);
                intent.putExtras(bundle);
                startActivity(intent);

    }
}
