package com.example.sih_v2.Protection;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.sih_v2.Helper.LocaleHelper;
import com.example.sih_v2.R;

import io.paperdb.Paper;

public class cropTypeProtection extends AppCompatActivity {
    View view;

    TextView toptext,txt;
    Button gotocam,commercial,food,veg;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_type_protection);

        toptext = findViewById(R.id.topText);
        txt = findViewById(R.id.txt);
        commercial = findViewById(R.id.commercial);
        food = findViewById(R.id.food);
        veg = findViewById(R.id.veg);
        gotocam = findViewById(R.id.gotocam);

        gotocam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cropTypeProtection.this, cropCamera.class));
            }
        });
/*
        CardView card = findViewById(R.id.card1);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cropTypeProtection.this, ProteccDetails.class));
            }
        });*/
        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView(Paper.book().read("language"));

    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        toptext.setText(resources.getString(R.string.protection));
        txt.setText(resources.getString(R.string.send_us_photo_of_your_crop_to_get_solutions_from_our_experts));
        commercial.setText(resources.getString(R.string.protection_from_weeds));
        food.setText(resources.getString(R.string.protection_from_diseases));
        veg.setText(resources.getString(R.string.protection_from_insects));
        gotocam.setText(resources.getString(R.string.upload_pic));
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

    public void displayPDF_Weeds(View view){
        startActivity(new Intent(getApplicationContext(), ProtectionDetailsActivity.class));
    }


    public void displayPDF_Diseases(View view) {
        startActivity(new Intent(getApplicationContext(), ProtectionDetailsDiseases.class));
    }

    public void displayPDF_Insects(View view) {
        startActivity(new Intent(getApplicationContext(), ProtectionDetailsInsects.class));
    }
}