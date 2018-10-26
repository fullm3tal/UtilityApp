package com.bheemapps.cvvalidator.utilityapp.dagger.component;

import com.bheemapps.cvvalidator.utilityapp.Student;
import com.bheemapps.cvvalidator.utilityapp.dagger.component.UtilityApplicationComponent;
import com.bheemapps.cvvalidator.utilityapp.dagger.scope.DaggerActivityScope;

import dagger.Component;

@DaggerActivityScope
@Component(dependencies = UtilityApplicationComponent.class)
public interface DaggerActivityComponent {

    Student getStudent();

}
