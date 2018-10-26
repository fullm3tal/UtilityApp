package com.bheemapps.cvvalidator.utilityapp.dagger.component;

import com.bheemapps.cvvalidator.utilityapp.InjectActivity;
import com.bheemapps.cvvalidator.utilityapp.dagger.scope.InjectActivityScope;
import com.bheemapps.cvvalidator.utilityapp.Student;
import com.bheemapps.cvvalidator.utilityapp.dagger.module.InjectActivityModule;

import dagger.Component;

@InjectActivityScope
@Component(modules = {InjectActivityModule.class} , dependencies = {UtilityApplicationComponent.class})
public interface InjectActivityComponent {

    void injectDaggerInjection(InjectActivity injectActivity);

}
