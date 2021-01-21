package com.example.sih_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sih_v2.Helper.LocaleHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.paperdb.Paper;

public class RegisterActivity extends AppCompatActivity {

    TextView register;
    EditText name,email,passcode,phone;
    Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.topText);
        email = findViewById(R.id.inputEmail);
        passcode = findViewById(R.id.inputPassword);
        name = findViewById(R.id.name);
        registration = findViewById(R.id.proceed);
        phone = findViewById(R.id.phone);


        //register button activity
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Please Enter Email Address", Toast.LENGTH_SHORT).show();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                    Toast.makeText(RegisterActivity.this, "Please Enter valid Email Address", Toast.LENGTH_SHORT).show();
                }
                else  if(TextUtils.isEmpty(passcode.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                else if(passcode.getText().toString().length()<6){
                    Toast.makeText(RegisterActivity.this, "Please Enter 6 or more than digit password", Toast.LENGTH_SHORT).show();
                }
                else  if(TextUtils.isEmpty(name.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                //if(!number.getText().toString().isEmpty() && number.getText().toString().length()==10)
                else  if(TextUtils.isEmpty(phone.getText().toString())){

                    Toast.makeText(RegisterActivity.this, "Please Enter Phone Number", Toast.LENGTH_SHORT).show();
                }else if(phone.getText().toString().length()<10 || phone.getText().toString().length()>10){
                    phone.setError("More Than 10 Digit.....please Enter Valid {Phone Number");
                }
                else {
                    /*Button register = (Button) findViewById(R.id.proceed);
                    register.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(getApplicationContext(), PhoneActivity.class));
                        }
                    });*/
                    registration();

                }
            }
        });


        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView(Paper.book().read("language"));

    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        register.setText(resources.getString(R.string.register));
        email.setText(resources.getString(R.string.email));
        passcode.setText(resources.getString(R.string.password));
        name.setText(resources.getString(R.string.name));
        registration.setText(resources.getString(R.string.proceed));
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.language_en)
        {
            Paper.book().write("language","en");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_hi)
        {
            Paper.book().write("language","hi");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_ta)
        {
            Paper.book().write("language","ta");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_mr)
        {
            Paper.book().write("language","mr");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_bn)
        {
            Paper.book().write("language","bn");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_pa)
        {
            Paper.book().write("language","pa");
            updateView(Paper.book().read("language"));
        }

        return true;
    }


    // register the use in firebase
    private void registration() {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.getText().toString(), passcode.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        Map<String,Object> map = new HashMap<>();
                        map.put("email",email.getText().toString());
                        map.put("password", passcode.getText().toString());
                        map.put("name",name.getText().toString());
                        map.put("phone",phone.getText().toString());

                        FirebaseDatabase.getInstance().getReference()
                                .child("Users")
                                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid()))
                                .setValue(map)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(RegisterActivity.this, "Registration Done. Verify Email and Login again ", Toast.LENGTH_SHORT).show();
                                                    //finish();

                                                    registration.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            Toast.makeText(RegisterActivity.this, "Verify your Phone Number", Toast.LENGTH_LONG).show();
                                                            Intent intent = new Intent(RegisterActivity.this, PhoneActivity.class);
                                                            intent.putExtra("val",phone.getText().toString());
                                                            startActivity(intent);
                                                        }
                                                    });
                                                }
                                                else{
                                                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(),  Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Failed :"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}