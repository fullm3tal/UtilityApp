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
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    MutableLiveData<ItemsList> responseLiveData;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MutableLiveData<ItemsList> getItemsList() {
        if (responseLiveData == null) {
            responseLiveData = new MutableLiveData<>();
        }
        return responseLiveData;
    }

    public void loadItemsList() {

        List<String> strings = new ArrayList<>();
        strings.add("RxJava");
        strings.add("MVVM pattern with Livedata");
        ItemsList list = new ItemsList();
        list.strings = strings;
        Observable.just(list).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemsList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ItemsList itemsList) {
                        responseLiveData.setValue(itemsList);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }

                });

    }
}