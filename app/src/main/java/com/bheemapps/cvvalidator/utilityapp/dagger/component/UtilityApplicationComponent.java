package com.bheemapps.cvvalidator.utilityapp.dagger.component;

import com.bheemapps.cvvalidator.utilityapp.Student;
import com.bheemapps.cvvalidator.utilityapp.dagger.module.StudentModule;
import com.bheemapps.cvvalidator.utilityapp.dagger.scope.UtilityAppScope;

import dagger.Component;
import dagger.Module;

@Component(modules = {StudentModule.class})
public interface UtilityApplicationComponent {

 @UtilityAppScope
 Student getStudent();


}
