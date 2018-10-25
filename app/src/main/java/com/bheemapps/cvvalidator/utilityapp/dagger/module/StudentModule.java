package com.bheemapps.cvvalidator.utilityapp.dagger.module;

import com.bheemapps.cvvalidator.utilityapp.Student;

import dagger.Module;
import dagger.Provides;

@Module
public class StudentModule {

    @Provides
    public Student student(){
        return Student.getInstance();
    }

}
