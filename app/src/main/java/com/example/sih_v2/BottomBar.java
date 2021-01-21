package com.example.sih_v2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.sih_v2.Insurance.cropInsurance;
import com.example.sih_v2.News.activity.NewsActivity;
import com.example.sih_v2.Protection.cropTypeProtection;
import com.example.sih_v2.Schemes.Dialog.DialogLicences;
import com.example.sih_v2.Schemes.Dialog.DialogPolicy;
import com.example.sih_v2.Schemes.Dialog.DialogTerms;
import com.example.sih_v2.Schemes.Scheme;
import com.example.sih_v2.Weather.activities.WeatherActivity;
import com.example.sih_v2.YTvideo.Videos;
import com.example.sih_v2.retailer.retailer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class BottomBar extends AppCompatActivity {
    private static final String TAG = BottomBar.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);



        animatedBottomBar = findViewById(R.id.animatedBottomBar);

        if (savedInstanceState == null) {
            animatedBottomBar.selectTabById(R.id.home, true);

            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment)
                    .commit();
        }


        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NotNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.settings:
                        fragment = new SettingsFragment();
                        break;
                }

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                } else {
                    Log.e(TAG, "Error in creating Fragment");
                }
            }
        });
    }




    public  void Protection(View view){
        startActivity(new Intent(getApplicationContext(), cropTypeProtection.class));

    }
    public void Insurance(View view) {
        startActivity(new Intent(getApplicationContext(), cropInsurance.class));
    }

    public void Advisory(View view) {
        startActivity(new Intent(getApplicationContext(), com.example.sih_v2.Advisory.Advisory.class));
    }

    public void Schemes(View view) {
        startActivity(new Intent(getApplicationContext(), Scheme.class));
    }

    public void News(View view) {
        startActivity(new Intent(getApplicationContext(), NewsActivity.class));
    }

    public void Retailers(View view) {
        startActivity(new Intent(getApplicationContext(), retailer.class));
    }

    public void videos(View view) {
        startActivity(new Intent(getApplicationContext(), Videos.class));
    }

    public void Weather(View view) {
        startActivity(new Intent(getApplicationContext(), WeatherActivity.class));
    }

    public void transport(View view) {
        startActivity(new Intent(getApplicationContext(), TransportationActivity.class));
    }

    public void Privacy_Policy(View view) {
        DialogPolicy exampleDialog = new DialogPolicy();
        exampleDialog.show(getSupportFragmentManager(), "Privacy Policies");
    }

    public void Terms(View view) {
        DialogTerms exampleDialog = new DialogTerms();
        exampleDialog.show(getSupportFragmentManager(), "Privacy Policies");
    }

    public void Licences(View view) {
        DialogLicences exampleDialog = new DialogLicences();
        exampleDialog.show(getSupportFragmentManager(), "Privacy Policies");
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
}

