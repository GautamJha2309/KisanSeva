package com.example.sih_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sih_v2.Helper.LocaleHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import io.paperdb.Paper;

public class OtpEnterActivity extends AppCompatActivity {

    TextView Register;
    EditText otp;
    Button submit,resend;
    Boolean verificationInProgress = false;
    FirebaseAuth fAuth;
    String verificationId;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_enter);

        fAuth = FirebaseAuth.getInstance();
        Register = findViewById(R.id.topText);
        otp = findViewById(R.id.name);
        submit = findViewById(R.id.submit);
        resend = findViewById(R.id.resend);
        resend.setVisibility(View.GONE);

        overridePendingTransition(0,0);
        View relativeLayout=findViewById(R.id.login_container);

        Animation animation= AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        relativeLayout.startAnimation(animation);

        Button submit = findViewById(R.id.submit);
        Intent intent = getIntent();
        verificationInProgress = intent.getBooleanExtra("val",verificationInProgress);
        verificationId = intent.getStringExtra("val2");
//Start : After Clicking Submit OTP Button n calling Method to verify OTP
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!verificationInProgress){

                }
                else{
                    //codeEnter.setVisibility(View.VISIBLE);
                    String userOTP = otp.getText().toString();
                    if(!userOTP.isEmpty() && userOTP.length()== 6){
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,userOTP);
                        verifyAuth(credential);
                    }else{
                        otp.setError("Valid OTP is required");
                    }
                }
            }
        });
//End : After Clicking Submit OTP Button n calling Method to verify OTP
        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView((String)Paper.book().read("language"));
    }
//Start Method to verify OTP and taking appropriate action After verification or failure of sending OTP
    private void verifyAuth(PhoneAuthCredential credential) {
        fAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(OtpEnterActivity.this, MainActivity.class));
                     /*Write here What to do next after Authentication Successfull*/
                }else{
                   resend.setVisibility(View.VISIBLE);
                }
            }
        });
    }
//End Method to verify OTP and taking appropriate action After verification or failure of sending OTP
    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        Register.setText(resources.getString(R.string.register));
        otp.setText(resources.getString(R.string.otp));
        submit.setText(resources.getString(R.string.submit));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.language_en)
        {
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_hi)
        {
            Paper.book().write("language","hi");
            updateView((String)Paper.book().read("language"));
        }

        return true;
    }
}
