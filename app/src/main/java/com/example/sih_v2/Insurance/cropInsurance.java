package com.example.sih_v2.Insurance;

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

public class cropInsurance extends AppCompatActivity {

    TextView toptext,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_insurance);

        toptext = findViewById(R.id.topText);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
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
        txt17 = findViewById(R.id.txt17);
        txt18 = findViewById(R.id.txt18);

        TextView txt= (TextView) findViewById(R.id.link1);
        txt.setMovementMethod(LinkMovementMethod.getInstance());
        txt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("http://www.aicofindia.com/AICEng/Pages/Default.aspx"));
                startActivity(browserIntent);
            }
        });

        TextView txt1= (TextView) findViewById(R.id.link2);
        txt1.setMovementMethod(LinkMovementMethod.getInstance());
        txt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.bajajallianz.com/commercial-insurance.html"));
                startActivity(browserIntent);
            }
        });

        TextView txt3= (TextView) findViewById(R.id.link3);
        txt3.setMovementMethod(LinkMovementMethod.getInstance());
        txt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.cholainsurance.com/pradhan-mantri-fby.html"));
                startActivity(browserIntent);
            }
        });

        TextView txt4= (TextView) findViewById(R.id.link4);
        txt4.setMovementMethod(LinkMovementMethod.getInstance());
        txt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://general.futuregenerali.in/rural-insurance"));
                startActivity(browserIntent);
            }
        });

        TextView txt5= (TextView) findViewById(R.id.link5);
        txt5.setMovementMethod(LinkMovementMethod.getInstance());
        txt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.hdfcergo.com/commercial-insurance/weather-insurance"));
                startActivity(browserIntent);
            }
        });

        TextView txt6= (TextView) findViewById(R.id.link6);
        txt6.setMovementMethod(LinkMovementMethod.getInstance());
        txt6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.icicilombard.com/rural-insurance"));
                startActivity(browserIntent);
            }
        });

        TextView txt7= (TextView) findViewById(R.id.link7);
        txt7.setMovementMethod(LinkMovementMethod.getInstance());
        txt7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.iffcotokio.co.in/micro-rural-insurance"));
                startActivity(browserIntent);
            }
        });

        TextView txt8= (TextView) findViewById(R.id.link8);
        txt8.setMovementMethod(LinkMovementMethod.getInstance());
        txt8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.sbigeneral.in/portal/"));
                startActivity(browserIntent);
            }
        });

        TextView txt9= (TextView) findViewById(R.id.link9);
        txt9.setMovementMethod(LinkMovementMethod.getInstance());
        txt9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.reliancegeneral.co.in/Insurance/Claims/Crop-Insurance.aspx"));
                startActivity(browserIntent);
            }
        });


        TextView txt10= (TextView) findViewById(R.id.link10);
        txt10.setMovementMethod(LinkMovementMethod.getInstance());
        txt10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("http://www.tataaiginsurance.in/rural-insurance/AboutRural/"));
                startActivity(browserIntent);
            }
        });


        TextView txt11= (TextView) findViewById(R.id.link11);
        txt11.setMovementMethod(LinkMovementMethod.getInstance());
        txt11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("http://www.universalsompo.com/products/commercial/11-products/commercial/32-farmer-s-package-policy"));
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

        toptext.setText(resources.getString(R.string.crop_insurance));
        txt1.setText(resources.getString(R.string.crop_insurance_majorly_depends_on_the_crop_season));
        txt2.setText(resources.getString(R.string.rabi_season_october_march_winter));
        txt3.setText(resources.getString(R.string.zaid_season_march_june_summer));
        txt4.setText(resources.getString(R.string.companies_offering_crop_insurance));
        txt5.setText(resources.getString(R.string.s_no));
        txt6.setText(resources.getString(R.string.company));
        txt7.setText(resources.getString(R.string.web_address));
        txt8.setText(resources.getString(R.string.agriculture_insurance_company_of_india_pvt_ltd));
        txt9.setText(resources.getString(R.string.bajaj_alliance_general_insurance_co_ltd));
        txt10.setText(resources.getString(R.string.cholamandalam_ms_general_insurance_co_ltd));
        txt11.setText(resources.getString(R.string.future_generali_india_insurance_company_ltd));
        txt12.setText(resources.getString(R.string.hdfc_ergo_general_insurance_co_ltd));
        txt13.setText(resources.getString(R.string.icici_lombard_general_insurance_co_ltd));
        txt14.setText(resources.getString(R.string.iffco_tokio_general_insurance_co_ltd));
        txt15.setText(resources.getString(R.string.sbi_general_insurance_co_ltd));
        txt16.setText(resources.getString(R.string.reliance_ngeneral_insurance_co_ltd));
        txt17.setText(resources.getString(R.string.tata_aig_ngeneral_insurance_co_ltd));
        txt18.setText(resources.getString(R.string.universal_sompo_general_insurance_co_ltd));
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