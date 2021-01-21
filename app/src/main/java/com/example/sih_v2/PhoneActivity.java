package com.example.sih_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sih_v2.Helper.LocaleHelper;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import io.paperdb.Paper;

public class PhoneActivity extends AppCompatActivity {

   // public static final String TAG = TAG;
    TextView register,state;
    EditText number;
    Button next;
    FirebaseAuth fAuth;
    String verificationId;
    PhoneAuthProvider.ForceResendingToken token;
    Boolean verificationInProgress = false;
    ProgressBar progressBar;



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        fAuth = FirebaseAuth.getInstance();
        register = findViewById(R.id.topText);
        number = findViewById(R.id.name);
        next = findViewById(R.id.next);
        progressBar = findViewById(R.id.progressBar);
        state = findViewById(R.id.state);

        Intent intent = getIntent();
        number.setText(intent.getStringExtra("val").toString());

        overridePendingTransition(0,0);
        View relativeLayout=findViewById(R.id.login_container);

        Animation animation= AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        relativeLayout.startAnimation(animation);
//After clicking Send Otp Button
// to send otp with reading Mobile Number
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!number.getText().toString().isEmpty() && number.getText().toString().length()==10) {
                    String phoneNum = "+"+"91"+number.getText().toString();
                   //Log.d("TAG", "onClick: Phone No -> "+phoneNum);
                    progressBar.setVisibility(View.VISIBLE);
                    state.setText("Sending OTP");
                    state.setVisibility(View.VISIBLE);
                    requestOTP(phoneNum);//call to method which will request to send otp
                   if(verificationInProgress==true){
                        Intent intent = new Intent(PhoneActivity.this, OtpEnterActivity.class);
                        intent.putExtra("val",verificationInProgress);
                        intent.putExtra("val2",verificationId);
                        startActivity(intent);
                    }
                }
                else{
                    number.setError("Phone Number is not valid");
                    number.setText("");
                }
            }
        });
//End of next (OTP Sending) Button Block
        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView((String)Paper.book().read("language"));

    }
//Method to send OTP Call in Next button's OnClick event
    private void requestOTP(String phoneNum) {
        //Start copy
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNum, 60L, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                progressBar.setVisibility(View.GONE);
                state.setVisibility(View.GONE);
                verificationId=s;
                token=forceResendingToken;
                verificationInProgress=true;
            }

            @Override
            public void onCodeAutoRetrievalTimeOut(String s) {
                super.onCodeAutoRetrievalTimeOut(s);
                //Toast.makeText(PhoneActivity.this,"Verification Time Out", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(PhoneActivity.this,"Cannot Create Account "+e.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        //End copy
    }
////End Of Method to send OTP Call in Next button's OnClick event

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        register.setText(resources.getString(R.string.register));
        //number.setText(resources.getString(R.string.mobile_number));
        next.setText(resources.getString(R.string.next));
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
}