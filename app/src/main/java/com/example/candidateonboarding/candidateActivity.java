package com.example.candidateonboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class candidateActivity extends AppCompatActivity {
    EditText employeeName,employeeLocation,employeeCollege,employeeAadharnumber;
    TextView candidate2;
    Button submitButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);

        employeeName=findViewById(R.id.employee_name);
        employeeLocation=findViewById(R.id.employee_loc);
        employeeCollege=findViewById(R.id.employee_clg);
        employeeAadharnumber=findViewById(R.id.employee_aadhar);
        submitButton=findViewById(R.id.submit_button);
        candidate2=findViewById(R.id.candidate2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference( "users");

                String name = employeeName.getText().toString();
                String location = employeeLocation.getText().toString();
                String college = employeeCollege.getText().toString();
                String Aadhar_number = employeeAadharnumber.getText().toString();

                HelperClass helperClass = new HelperClass(name, location, college, Aadhar_number);
                reference.child(name).setValue(helperClass);

                Toast.makeText(candidateActivity.this, "You have added on community", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(candidateActivity.this, candidateActivity2.class);
                startActivity(intent);

            }
        });

        candidate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(candidateActivity.this,candidateActivity2.class);
                startActivity(intent);

            }
        });

    }
}