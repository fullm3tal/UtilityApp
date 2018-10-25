package com.bheemapps.cvvalidator.utilityapp;

import com.bheemapps.cvvalidator.utilityapp.dagger.component.UtilityApplicationComponent;

import dagger.Component;

@Component(dependencies = UtilityApplicationComponent.class)
@DaggerActivityScope
public interface DaggerActivityComponent {

    @DaggerActivityScope
    Student getStudent();

}
