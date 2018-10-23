package com.bheemapps.cvvalidator.utilityapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class ReactiveActivity extends AppCompatActivity {

    ReactiveViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reactive);
        ButterKnife.bind(this);
        model = ViewModelProviders.of(this).get(ReactiveViewModel.class);
        model.loadItemsList();

        model.getItemsList().observe(this, new Observer<ItemsList>() {
            @Override
            public void onChanged(@Nullable ItemsList itemsList) {
                if (itemsList != null) {
                }
            }
        });
    }
}