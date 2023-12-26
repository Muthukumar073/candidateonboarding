package com.example.candidateonboarding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class candidateActivity2 extends AppCompatActivity {
   EditText addemployee_name,addemployee_location,addemployee_college,addemployee_aadhar;
   Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate2);

        addemployee_name=findViewById(R.id.addemployee_name);
        addemployee_location=findViewById(R.id.addemployee_loc);
        addemployee_college=findViewById(R.id.addemployee_clg);
        addemployee_aadhar=findViewById(R.id.addemployee_aadhar);
        submit_button=findViewById(R.id.submit_button);



    }
    public Boolean validatename(){
        String val =addemployee_name.getText().toString();
        if (val.isEmpty()){
            addemployee_name.setError("Name cannot be empty");
            return false;
        }else{
            addemployee_name.setError(null);
            return true;
        }
    }

    public Boolean validateaadhar() {
        String val = addemployee_aadhar.getText().toString();
        if (val.isEmpty()) {
            addemployee_aadhar.setError("Aadhar number cannot be empty");
            return false;
        } else {
            addemployee_aadhar.setError(null);
            return true;
        }
    }

    public void checkuser(){
        String username=addemployee_name.getText().toString().trim();
        String useraadhar=addemployee_aadhar.getText().toString().trim();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference( "users");
        Query checkuserDatabase=reference.orderByChild("name").equalTo(username);

        checkuserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    addemployee_name.setError(null);
                    String aadharfromDB=snapshot.child(username).child("aadhar").getValue(String.class);

                    if (!Objects.equals(aadharfromDB,useraadhar)){
                        addemployee_name.setError(null);
                        Intent intent=new Intent(candidateActivity2.this,MainActivity.class);
                        startActivity(intent);
                    }else{
                        addemployee_aadhar.setError("Invalid Credentials");
                        addemployee_aadhar.requestFocus();
                    }
                }else{
                    addemployee_name.setError("User does not exist");
                    addemployee_name.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}