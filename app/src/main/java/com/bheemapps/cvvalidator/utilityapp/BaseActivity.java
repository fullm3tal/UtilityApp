package com.bheemapps.cvvalidator.utilityapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


//    public <T> void open(T<? extends BaseActivity> clazz){
//        startActivity(new Intent(this,clazz));
//    }

}
