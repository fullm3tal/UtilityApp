package com.bheemapps.cvvalidator.utilityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bheemapps.cvvalidator.utilityapp.dagger.component.DaggerInjectActivityComponent;
import com.bheemapps.cvvalidator.utilityapp.dagger.component.InjectActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InjectActivity extends AppCompatActivity {

    @Inject
    Student student;

    @BindView(R.id.tv_student_name)
    TextView tvStudentName;

    @BindView(R.id.tv_student_age)
    TextView tvStudentAge;

    private static final String TAG = "DaggerInjectActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inject);


        ButterKnife.bind(this);
        InjectActivityComponent component = DaggerInjectActivityComponent.builder()
                .utilityApplicationComponent(UtilityApplication.get(this).component())
                .build();

        component.injectDaggerInjection(this);


        Log.v(TAG, "Student name " + student.getName() + " " + student.getAge());

        tvStudentAge.setText(String.valueOf(student.getAge()));
        tvStudentName.setText(student.getName());

    }
}
