package com.bheemapps.cvvalidator.utilityapp;

import android.arch.core.executor.TaskExecutor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RxCreateActivity extends AppCompatActivity {

    @BindView(R.id.tv_create)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_create);
        ButterKnife.bind(this);
        Bundle bundle= getIntent().getExtras();
        Integer integer= bundle.getInt("Key");
               switch (integer) {
                   case 0:
                   callObservableCreate();
                   break;
                   case 1:
                       callObservableFrom();
                       break;
                   case 2:
                       break;
               }
    }

    private void callObservableFrom() {

        //FromCallable wraps an Expensive call and handle exceptions RXjava way
        //fromCallable is used to do the expensive long running operations
        //Moreover, the method won't execute immediately, it will only execute, if any subscriber
        // is attached to it.

        Observable<Integer>  observable= Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 3+4;
            }
        });

        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                   textView.append(" Number "+integer);
            }

            @Override
            public void onError(Throwable e) {
                textView.setText("Error reported");
            }

            @Override
            public void onComplete() {
                textView.append(" Number adding completed.");
            }
        });


    }

    private void callObservableCreate(){

        //Observable.create: Observable.create lets you emit multiple items. Observable.create
        // let's you delay the call to onNext to a later point in time.
        Observable<Integer> o = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(10);
                emitter.onNext(100);
                emitter.onNext(123);
                emitter.onComplete();
            }
        });

        o.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                textView.append(" Item Received on Consumer " + integer);
            }
        });

        o.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                textView.append(" On Next " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
               textView.append(" On Complete");
            }
        });

    }

}
