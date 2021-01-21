package com.example.sih_v2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sih_v2.Helper.LocaleHelper;
import com.example.sih_v2.R;

import io.paperdb.Paper;

public class TransportationActivity extends AppCompatActivity {

    TextView txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13,txt14,txt15,txt16,txt18;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);


        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txt8 = findViewById(R.id.txt8);
        txt9 = findViewById(R.id.txt9);
        txt10 = findViewById(R.id.txt10);
        txt11 = findViewById(R.id.txt11);
        txt12 = findViewById(R.id.txt12);
        txt13 = findViewById(R.id.txt13);
        txt14 = findViewById(R.id.txt14);
        txt15 = findViewById(R.id.txt15);
        txt16 = findViewById(R.id.txt16);
        txt18 = findViewById(R.id.txt18);

        TextView txt= (TextView) findViewById(R.id.tlink1);
        txt.setMovementMethod(LinkMovementMethod.getInstance());
        txt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://relay.rivigo.com/"));
                startActivity(browserIntent);
            }
        });

        TextView txt1= (TextView) findViewById(R.id.tlink2);
        txt1.setMovementMethod(LinkMovementMethod.getInstance());
        txt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://trucksuvidha.com/"));
                startActivity(browserIntent);
            }
        });

        TextView txt3= (TextView) findViewById(R.id.tlink3);
        txt3.setMovementMethod(LinkMovementMethod.getInstance());
        txt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.transin.in/"));
                startActivity(browserIntent);
            }
        });

        TextView txt4= (TextView) findViewById(R.id.tlink4);
        txt4.setMovementMethod(LinkMovementMethod.getInstance());
        txt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.truckguru.co.in/"));
                startActivity(browserIntent);
            }
        });

        TextView txt5= (TextView) findViewById(R.id.tlink5);
        txt5.setMovementMethod(LinkMovementMethod.getInstance());
        txt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.elastic.run/"));
                startActivity(browserIntent);
            }
        });

        TextView txt6= (TextView) findViewById(R.id.tlink6);
        txt6.setMovementMethod(LinkMovementMethod.getInstance());
        txt6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.blackbuck.com/"));
                startActivity(browserIntent);
            }
        });

        TextView txt7= (TextView) findViewById(R.id.tlink7);
        txt7.setMovementMethod(LinkMovementMethod.getInstance());
        txt7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.mavyn.in/"));
                startActivity(browserIntent);
            }
        });

        TextView txt8= (TextView) findViewById(R.id.tlink8);
        txt8.setMovementMethod(LinkMovementMethod.getInstance());
        txt8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.jusdaindia.com/"));
                startActivity(browserIntent);
            }
        });

        TextView txt9= (TextView) findViewById(R.id.tlink9);
        txt9.setMovementMethod(LinkMovementMethod.getInstance());
        txt9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.eparivahan.com/"));
                startActivity(browserIntent);
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


        txt5.setText(resources.getString(R.string.sr_no));
        txt6.setText(resources.getString(R.string.company));
        txt7.setText(resources.getString(R.string.web_address));
        txt8.setText(resources.getString(R.string.rivigo));
        txt9.setText(resources.getString(R.string.suvidha));
        txt10.setText(resources.getString(R.string.transin));
        txt11.setText(resources.getString(R.string.guru));
        txt12.setText(resources.getString(R.string.elastic));
        txt13.setText(resources.getString(R.string.blackbuck));
        txt14.setText(resources.getString(R.string.mavyn));
        txt15.setText(resources.getString(R.string.jusda));
        txt16.setText(resources.getString(R.string.parivahan));
        txt18.setText(resources.getString(R.string.famregister));
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