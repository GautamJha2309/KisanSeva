package com.example.sih_v2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.sih_v2.Advisory.Advisory;
import com.example.sih_v2.Fertilizers.FertilizerActivity;
import com.example.sih_v2.Helper.LocaleHelper;
import com.example.sih_v2.Mandi.MandiActivity;
import com.example.sih_v2.News.activity.NewsActivity;
import com.example.sih_v2.Profile.ProfileActivity;
import com.example.sih_v2.Protection.cropTypeProtection;
import com.example.sih_v2.Settings.SettingsActivity;
import com.example.sih_v2.Weather.activities.WeatherActivity;
import com.example.sih_v2.YTvideo.Videos;
import com.example.sih_v2.Insurance.cropInsurance;
import com.example.sih_v2.Schemes.Scheme;
import com.example.sih_v2.retailer.retailer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import nl.joery.animatedbottombar.AnimatedBottomBar;


public class MainActivity extends AppCompatActivity{


    TextView t_weather,t_estamate,t_advice,t_protection,t_commerce,t_insurence,t_market,t_advisory,t_schemes,t_news,t_retailer,t_videos;
    private Toolbar toolbar;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        t_estamate = findViewById(R.id.t_estimate);
        t_advice = findViewById(R.id.t_advice);
        t_protection = findViewById(R.id.t_protection);
       // t_commerce = findViewById(R.id.t_commerce);
        t_insurence = findViewById(R.id.t_insurance);
        //t_market = findViewById(R.id.t_market);
        t_advisory = findViewById(R.id.t_advisory);
        t_schemes = findViewById(R.id.t_schemes);
        t_news = findViewById(R.id.t_news);
        t_retailer = findViewById(R.id.t_retailer);
        t_videos = findViewById(R.id.t_videos);
        t_weather = findViewById(R.id.t_weather);


        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModelList = new ArrayList<>();
        slideModelList.add(new SlideModel("https://www.royalsundaram.in/html/files/crop-insurance/Crop-Insurance-Online.jpg"));
        slideModelList.add(new SlideModel("https://www.centralbankofindia.co.in/images/Agriculture.jpg"));
        slideModelList.add(new SlideModel("https://www.centralbankofindia.co.in/images/MSMEBanner.jpg"));
        slideModelList.add(new SlideModel("https://img.tradeindia.com/new_website1/tradeshowslandingpage/agriasia/2/banner1.jpg"));
        slideModelList.add(new SlideModel("https://img.tradeindia.com/new_website1/tradeshowslandingpage/agriasia/2/banner3.jpg"));
        imageSlider.setImageList(slideModelList, false);



        ImageView profileImageView = findViewById(R.id.profile_image_view);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/sih20-ae3ac.appspot.com/o/ProfilePhoto%2F1596257951332.jpg?alt=media&token=d9056195-6d25-4c30-835f-69c2be5905c9").transform(new CropCircleTransformation()).into(profileImageView);


        AnimatedBottomBar animatedBottomBar = findViewById(R.id.animatedBottomBar);
        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NotNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()) {
                    case R.id.Home:
                        break;
                    case R.id.Profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        overridePendingTransition(0,0);
                        break;
                }
            }
        });



        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView(Paper.book().read("language"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.settings) {
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            return true;
        }


        if (item.getItemId() == R.id.language_en)
        {
            Paper.book().write("language","en");
            updateView(Paper.book().read("language"));
            return true;
        }
        else if (item.getItemId() == R.id.language_hi)
        {
            Paper.book().write("language","hi");
            updateView(Paper.book().read("language"));
            return true;
        }
        else if (item.getItemId() == R.id.language_ta)
        {
            Paper.book().write("language","ta");
            updateView(Paper.book().read("language"));
            return true;
        }
        else if (item.getItemId() == R.id.language_mr)
        {
            Paper.book().write("language","mr");
            updateView(Paper.book().read("language"));
            return true;
        }
        else if (item.getItemId() == R.id.language_bn)
        {
            Paper.book().write("language","bn");
            updateView(Paper.book().read("language"));
            return true;
        }
        else if (item.getItemId() == R.id.language_pa)
        {
            Paper.book().write("language","pa");
            updateView(Paper.book().read("language"));
            return true;
        }
        return super.onOptionsItemSelected(item);

    }


    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        t_estamate.setText(resources.getString(R.string.estimate));
        t_advice.setText(resources.getString(R.string.advice));
        t_protection.setText(resources.getString(R.string.protection));
//        t_commerce.setText(resources.getString(R.string.prediction));
        t_insurence.setText(resources.getString(R.string.crop_insurance));
//        t_market.setText(resources.getString(R.string.market_price));
        t_advisory.setText(resources.getString(R.string.advisory));
        t_schemes.setText(resources.getString(R.string.schemes));
        t_news.setText(resources.getString(R.string.news));
        t_retailer.setText(resources.getString(R.string.retailers));
        t_videos.setText(resources.getString(R.string.videos));
        t_weather.setText(resources.getString(R.string.weather));
    }
/*
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
    }*/




    public void Protection(View view) {
        startActivity(new Intent(getApplicationContext(), cropTypeProtection.class));
    }

    public void Insurance(View view) {
        startActivity(new Intent(getApplicationContext(), cropInsurance.class));
    }

    public void Advisory(View view) {
        startActivity(new Intent(getApplicationContext(), Advisory.class));
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

    public void Mandi(View view) {
        startActivity(new Intent(getApplicationContext(), MandiActivity.class));
    }

    public void Fertilizers(View view) {
        startActivity(new Intent(getApplicationContext(), FertilizerActivity.class));
    }
}


