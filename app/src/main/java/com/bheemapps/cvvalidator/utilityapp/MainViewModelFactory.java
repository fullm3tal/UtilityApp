package com.bheemapps.cvvalidator.utilityapp;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel();
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel();
        } else if (modelClass.isAssignableFrom(ReactiveViewModel.class)) {
            return (T) new ReactiveViewModel();
        }

        throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
