package com.bheemapps.cvvalidator.utilityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bheemapps.cvvalidator.utilityapp.dagger.component.DaggerActivityComponent;
import com.bheemapps.cvvalidator.utilityapp.dagger.component.DaggerDaggerActivityComponent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaggerInjectActivity extends AppCompatActivity {


    @BindView(R.id.tv_student_name)
    TextView tvStudentName;

    @BindView(R.id.tv_student_age)
    TextView tvStudentAge;

    private static final String TAG = "DaggerInjectActivity";
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_inject);

        ButterKnife.bind(this);
       DaggerActivityComponent component=  DaggerDaggerActivityComponent.builder()
                .utilityApplicationComponent(UtilityApplication.get(this).component())
        .build();

      Student student= component.getStudent();

        Log.v(TAG,"Student name "+student.getName()+" "+student.getAge());
      
      tvStudentAge.setText(String.valueOf(student.getAge()));
      tvStudentName.setText(student.getName());

    }
}
