package com.bheemapps.cvvalidator.utilityapp;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)){
            return (T) new MainViewModel();
        }

        if (modelClass.isAssignableFrom(DetailViewModel.class)){
            return (T) new MainViewModel();
        }

        throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
