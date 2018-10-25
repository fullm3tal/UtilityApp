package com.bheemapps.cvvalidator.utilityapp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DetailViewModel extends ViewModel {

    MutableLiveData<ItemsList> responseLiveData;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MutableLiveData<ItemsList> getItemsList() {
        if (responseLiveData == null) {
            responseLiveData = new MutableLiveData<>();
        }
        return responseLiveData;
    }

    public void loadItemsList(String name) {


        switch (name) {

            case "RxJava 2":
                loadRxJavaList();
                break;
            case "Dagger 2":
                loadDaggerList();
                break;

        }

    }

    private void loadDaggerList() {
        List<String> strings = new ArrayList<>();
        strings.add("Dagger Module");
        strings.add("Dagger Component");
        strings.add("Dagger Inject");
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

    private void loadRxJavaList() {

        List<String> strings = new ArrayList<>();
        strings.add("Observable.create()");
        strings.add("Observable.fromCallable()");
        strings.add("observable.fromIterable()");
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
