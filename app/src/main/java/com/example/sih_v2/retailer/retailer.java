package com.example.sih_v2.retailer;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sih_v2.Helper.LocaleHelper;
import com.example.sih_v2.R;

import java.util.ArrayList;

import io.paperdb.Paper;

public class retailer extends AppCompatActivity {
    //Declaring important variables
    Spinner sp_parent, sp_child;
    Button search;
    String selectedDistrict=null;

    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent;

    // ArrayList<String> arrayList_Andra_Pradesh, arrayList_Arunachal_Pradesh,arrayList_Assam,arrayList_Bihar,arrayList_Chhattisgarh,arrayList_Goa,arrayList_Gujarat,arrayList_Haryana,arrayList_Himachal_Pradesh,arrayList_JnK,arrayList_Jharkhand,arrayList_Karnataka,arrayList_Kerala,arrayList_MadyaPradesh,arrayList_Maharashtra,arrayList_Manipur,arrayList_Meghalaya,arrayList_Mizoram,arrayList_Punjab,arrayList_TamilNadu;

    ArrayList<String> arrayList_Bihar, arrayList_Haryana, arrayList_Maharashtra, arrayList_TamilNadu;
    ArrayAdapter<String> arrayAdapter_child;

    TextView top,c_type,variety;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retailer);

        top = findViewById(R.id.topText);
        c_type = findViewById(R.id.croptype);
        variety = findViewById(R.id.Variety);
        search = findViewById(R.id.search);
        sp_parent = findViewById(R.id.sp_parent);
        sp_child = findViewById(R.id.sp_child);


        arrayList_parent = new ArrayList<>();
        arrayList_parent.add("Select Your State");
        arrayList_parent.add("Bihar");
        arrayList_parent.add("Haryana");
        //arrayList_parent.add("Jharkhand");
        arrayList_parent.add("Maharastra");
        // arrayList_parent.add("Punjab");
        arrayList_parent.add("Tamil Nadu");
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedDistrict = String.valueOf(sp_child.getSelectedItem());
                if(!(selectedDistrict =="null")){
                    if(!(selectedDistrict=="Select District")){
                        Intent intent = new Intent(retailer.this, ShowShop.class);
                        intent.putExtra("Dist",selectedDistrict);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(retailer.this,"Select District "+selectedDistrict,Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(retailer.this,"Select District",Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(retailer.this,"District is "+selectedDistrict,Toast.LENGTH_SHORT).show();
            }
        });

        arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_parent);

        sp_parent.setAdapter(arrayAdapter_parent);

        //========Child Spinner Process=========

        arrayList_Bihar = new ArrayList<>();
        arrayList_Bihar.add("Select District");
        arrayList_Bihar.add("Patna");
        arrayList_Bihar.add("Darbhanga");
        arrayList_Bihar.add("Muzaferpur");
        arrayList_Bihar.add("Gaya");
        arrayList_Bihar.add("Sitamarhi");

        arrayList_Haryana = new ArrayList<>();
        arrayList_Haryana.add("Select District");
        arrayList_Haryana.add("Ambala");
        arrayList_Haryana.add("Bhiwani");
        arrayList_Haryana.add("Faridabad");
        arrayList_Haryana.add("Gurgaon");
        arrayList_Haryana.add("Hisar");

        arrayList_Maharashtra = new ArrayList<>();
        arrayList_Maharashtra.add("Select District");
        arrayList_Maharashtra.add("Ahmadnagar");
        arrayList_Maharashtra.add("Akola");
        arrayList_Maharashtra.add("Amravati");
        arrayList_Maharashtra.add("Aurangabad");
        arrayList_Maharashtra.add("Bhandara");

        arrayList_TamilNadu = new ArrayList<>();
        arrayList_TamilNadu.add("Select District");
        arrayList_TamilNadu.add("Ariyalur");
        arrayList_TamilNadu.add("Cuddalore");
        arrayList_TamilNadu.add("Coimbatore");
        arrayList_TamilNadu.add("Dindigul");
        arrayList_TamilNadu.add("Erode");


        sp_parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                int position = (int) sp_parent.getSelectedItemId();

                if (position == 1) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_Bihar);
                }

                else if (position == 2) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_Haryana);
                }

                else if (position == 3) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_Maharashtra);
                }

                else if (position == 4) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_TamilNadu);
                }
                sp_child.setAdapter(arrayAdapter_child);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

        top.setText(resources.getString(R.string.retailer_services));
        c_type.setText(resources.getString(R.string.select_state));
        variety.setText(resources.getString(R.string.select_variety));
        search.setText(resources.getString(R.string.next));
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