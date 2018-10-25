package com.bheemapps.cvvalidator.utilityapp;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.bheemapps.cvvalidator.utilityapp.dagger.component.DaggerUtilityApplicationComponent;
import com.bheemapps.cvvalidator.utilityapp.dagger.component.UtilityApplicationComponent;

public class UtilityApplication extends Application {

    UtilityApplicationComponent dagger;
    Student student;
    private static final String TAG = "UtilityApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        dagger = DaggerUtilityApplicationComponent
                .builder()
                .build();
    student= dagger.getStudent();

    }

    public static UtilityApplication get(Activity activity){
        return (UtilityApplication)activity.getApplication();
    }

    public UtilityApplicationComponent component(){
        return dagger;
    }

}
