package com.bheemapps.cvvalidator.utilityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class DaggerInjectActivity extends AppCompatActivity {


    @BindView(R.id.tv_student_name)
    TextView tvStudentName;

    @BindView(R.id.tv_student_age)
    TextView tvStudentAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_inject);

       DaggerActivityComponent component=  DaggerDaggerActivityComponent.builder()
                .utilityApplicationComponent(UtilityApplication.get(this).component())
        .build();

      Student student= component.getStudent();

      tvStudentAge.setText(student.getAge());
      tvStudentName.setText(student.getName());

    }
}
