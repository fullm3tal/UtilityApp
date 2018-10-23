package com.bheemapps.cvvalidator.utilityapp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ReactiveViewModel extends ViewModel {

    MutableLiveData<ItemsList> responseLiveData;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MutableLiveData<ItemsList> getItemsList() {
        if (responseLiveData == null) {
            responseLiveData = new MutableLiveData<>();
        }
        return responseLiveData;
    }

    public void loadItemsList() {

    }
}

