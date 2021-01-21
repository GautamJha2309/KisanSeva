package com.example.sih_v2.Settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sih_v2.BuildConfig;
import com.example.sih_v2.ChooseActivity;
import com.example.sih_v2.LoginActivity;
import com.example.sih_v2.MainActivity;
import com.example.sih_v2.Profile.ProfileActivity;
import com.example.sih_v2.R;
import com.example.sih_v2.Schemes.Dialog.DialogLicences;
import com.example.sih_v2.Schemes.Dialog.DialogPolicy;
import com.example.sih_v2.Schemes.Dialog.DialogTerms;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class SettingsActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPreferences = getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);

        Button button = (Button) findViewById(R.id.logout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i1 = new Intent(SettingsActivity.this, ChooseActivity.class);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putBoolean("logged", false).apply();
                }
                startActivity(i1);
                Toast.makeText(SettingsActivity.this, "Logout Successfully!", Toast.LENGTH_SHORT).show();
            }
        });


        AnimatedBottomBar animatedBottomBar = findViewById(R.id.animatedBottomBar);
        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NotNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()) {
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.Profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.settings:
                        break;
                }
            }
        });


        /*Button policy = (Button) findViewById(R.id.policy);
        policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogPolicy();
            }
        });

        Button terms = (Button) findViewById(R.id.terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogTerms();
            }
        });

        Button licences = (Button) findViewById(R.id.licenses);
        licences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogLicences();
            }
        });

        ImageButton mailbutton = findViewById(R.id.mailbutton);
        mailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"sddehankar@mitaoe.ac.in", "ansingh@mitaoe.ac.in", "gsjha@mitaoe.ac.in", "racharya@mitaoe.ac.in"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Query / Connect US");
                intent.putExtra(Intent.EXTRA_TEXT,"");
                intent.putExtra(Intent.EXTRA_CC,"mailcc@gmail.com");
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });*/

    }


    public void Privacy_Policy(View view) {
        DialogPolicy exampleDialog = new DialogPolicy();
        exampleDialog.show(getSupportFragmentManager(), "Privacy Policies");
    }

    public void Terms(View view) {
        DialogTerms exampleDialog = new DialogTerms();
        exampleDialog.show(getSupportFragmentManager(), "Terms & Conditions");
    }

    public void Licences(View view) {
        DialogLicences exampleDialog = new DialogLicences();
        exampleDialog.show(getSupportFragmentManager(), "Licences");
    }


    public void connect(View view) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        String[] recipients={"sddehankar@mitaoe.ac.in", "ansingh@mitaoe.ac.in", "gsjha@mitaoe.ac.in", "racharya@mitaoe.ac.in"};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Query / Connect US");
        intent.putExtra(Intent.EXTRA_TEXT,"");
        intent.putExtra(Intent.EXTRA_CC,"mailcc@gmail.com");
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");
        startActivity(Intent.createChooser(intent, "Send mail"));
    }
   /*public void Logout(View view) {

        FirebaseAuth.getInstance().signOut();
        Intent i1 = new Intent(SettingsActivity.this, ChooseActivity.class);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("logged", false).apply();
        }
        startActivity(i1);
        Toast.makeText(SettingsActivity.this, "Logout Successfully!", Toast.LENGTH_SHORT).show();
    */
}