package com.example.sih_v2.Advisory;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sih_v2.Helper.LocaleHelper;
import com.example.sih_v2.R;

import java.util.ArrayList;
import java.util.Calendar;

import io.paperdb.Paper;


public class Advisory extends AppCompatActivity {

    Spinner sp_parent, sp_child, sp_child1;
    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent, arrayAdapter_child, arrayAdapter_child1;

    ArrayList<String> arrayList_select, arrayList_Cereal, arrayList_Fibre, arrayList_Oils, arrayList_pulses, arrayList_sugarcrops;

    //arraylist for crop type
    ArrayList<String> arrayList_Fmillet, arrayList_Maize, arrayList_Pmillet, arrayList_rice, arrayList_sorghum, arrayList_wheat, arrayList_cotton, arrayList_jute, arrayList_mesta, arrayList_sunhemp, arrayList_castor, arrayList_mustard, arrayList_sesame, arrayList_sunflower, arrayList_blackgram, arrayList_chickpea, arrayList_cowpea, arrayList_fieldpea, arrayList_monng, arrayList_horsegram, arrayList_lentil, arrayList_sugarcane;

    TextView mTv,topText,c_type,variety,category;
    Button mbtn,mbtn1;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    Calendar c;
    DatePickerDialog dpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisory);

       // mTv = findViewById(R.id.txtView);
        topText = findViewById(R.id.topText);
        c_type = findViewById(R.id.croptype);
        variety = findViewById(R.id.Variety);
        category = findViewById(R.id.Category);
        //mbtn = findViewById(R.id.btnPick);
        mbtn1 = findViewById(R.id.btnPick1);


        sp_parent = (Spinner) findViewById(R.id.sp_parent);
        sp_child = (Spinner) findViewById(R.id.sp_child);
        sp_child1 = (Spinner) findViewById(R.id.sp_child1);

        arrayList_parent = new ArrayList<>();
        arrayList_parent.add("Select");
        arrayList_parent.add("Cereals");
        arrayList_parent.add("Fibre");
        arrayList_parent.add("Oil Seeds");
        arrayList_parent.add("Pulses");
        arrayList_parent.add("Sugar Crops");
        arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_parent);

        sp_parent.setAdapter(arrayAdapter_parent);
        arrayList_select = new ArrayList<>();
        arrayList_select.add("Select");

        //CEREALS
        arrayList_Cereal = new ArrayList<>();
        arrayList_Cereal.add("Select");
        arrayList_Cereal.add("Finger millet");
        arrayList_Cereal.add("Maize");
        arrayList_Cereal.add("Pearl millet");
        arrayList_Cereal.add("Rice");
        arrayList_Cereal.add("Sorghum");
        arrayList_Cereal.add("Wheat");


        //FIBRE
        arrayList_Fibre = new ArrayList<>();
        arrayList_Fibre.add("Select");
        arrayList_Fibre.add("Cotton");
        arrayList_Fibre.add("Jute");
        arrayList_Fibre.add("Mesta");
        arrayList_Fibre.add("Sun-hemp");

        //Oil Seeds
        arrayList_Oils = new ArrayList<>();
        arrayList_Oils.add("Select");
        arrayList_Oils.add("Castor");
        arrayList_Oils.add("Indian Mustard");
        arrayList_Oils.add("Sesame");
        arrayList_Oils.add("Sun-flower");

        //PULSES
        arrayList_pulses = new ArrayList<>();
        arrayList_pulses.add("Select");
        arrayList_pulses.add("Black Gram");
        arrayList_pulses.add("Chick-pea");
        arrayList_pulses.add("Cowpea");
        arrayList_pulses.add("Green gram (Moong)");
        arrayList_pulses.add("Horse Gram");
        arrayList_pulses.add("Lentil");

        //SUGAR CROPS
        arrayList_sugarcrops = new ArrayList<>();
        arrayList_sugarcrops.add("Select");
        arrayList_sugarcrops.add("Sugar Cane");

        //array list of child1
        arrayList_Fmillet = new ArrayList<>();
        arrayList_Fmillet.add("Select");
        arrayList_Fmillet.add("Dapoli Safed");

        arrayList_Maize = new ArrayList<>();
        arrayList_Maize.add("Select");
        arrayList_Maize.add("Hishell (MCH-42) (Hybrid)");
        arrayList_Maize.add("HM-12 (HKH 313) (Hybrid)");
        arrayList_Maize.add("KMH 3712 (Hybrid)");
        arrayList_Maize.add("KMH-25K60 (Hybrid)");
        arrayList_Maize.add("KMH-3426 (Hybrid)");
        arrayList_Maize.add("NMH-731 (Hybrid)");
        arrayList_Maize.add("NMH-803 (Hybrid)");
        arrayList_Maize.add("Vivek Maize hybrid  (FH 3483)");
        arrayList_Maize.add("SMH-3904");

        arrayList_Pmillet = new ArrayList<>();
        arrayList_Pmillet.add("Select");
        arrayList_Pmillet.add("86M66 (MSH 226) (Hyrid)");
        arrayList_Pmillet.add("86M86  (MH 1684) (Hybrid)");
        arrayList_Pmillet.add("Kaveri Super Boss (Hybrid)  (MH 1553)");
        arrayList_Pmillet.add("MP-7792 (MH-1609)");
        arrayList_Pmillet.add("MP-7872  (MH-1610)");

        arrayList_rice = new ArrayList<>();
        arrayList_rice.add("Select");
        arrayList_rice.add("Arize Tej (HRI 169) (IET21411) (Hybrid)");
        arrayList_rice.add("CO 4  (IET 21449)  (TNRH 174)");
        arrayList_rice.add("JKRH 3333 (IET 20759) (Hybrid)");
        arrayList_rice.add("NK 5251 (IET 19738) (Hybrid)");
        arrayList_rice.add("NPH 924-1 (IET 21255) (Hybrid)");
        arrayList_rice.add("PNPH 24 (IET 21406)  (Hybrid)");
        arrayList_rice.add("RH-1531 (Frontline Gold) (IET 21404) (Hybrid)");
        arrayList_rice.add("US 382 (IET 20727) (Hybrid)");

        arrayList_sorghum = new ArrayList<>();
        arrayList_sorghum.add("Select");
        arrayList_sorghum.add("CSH-27  (SPH-1644)");
        arrayList_sorghum.add("CSH28 (NSH54) (SPH 1647) (Hybrid)");
        arrayList_sorghum.add("CSV 27  (SPV 1870)");
        arrayList_sorghum.add("CSV 29 R (SPV 2033)");
        arrayList_sorghum.add("CSV26  (SPV 1829)");
        arrayList_sorghum.add("SPH-1629 (MLSH 296 Gold/DJ 2002) (Hybrid)");

        arrayList_wheat = new ArrayList<>();
        arrayList_wheat.add("Select");
        arrayList_wheat.add("PBW 644");
        arrayList_wheat.add("Pusa Pachheti (HD 3059)");
        arrayList_wheat.add("TL  2969  (Triticale)");
        arrayList_wheat.add("UAS-428 (Durum)");

        arrayList_cotton = new ArrayList<>();
        arrayList_cotton.add("Select");
        arrayList_cotton.add("H-1300");

        arrayList_jute = new ArrayList<>();
        arrayList_jute.add("Select");
        arrayList_jute.add("JROM-1 (PRADIP)");

        arrayList_mesta = new ArrayList<>();
        arrayList_mesta.add("Select");
        arrayList_mesta.add("Shakti  (JBM-81)");

        arrayList_sunhemp = new ArrayList<>();
        arrayList_sunhemp.add("Select");
        arrayList_sunhemp.add("Ankur (SUIN-037)");

        arrayList_castor = new ArrayList<>();
        arrayList_castor.add("Select");
        arrayList_castor.add("DSP 222 (Hyrid)");

        arrayList_mustard = new ArrayList<>();
        arrayList_mustard.add("Select");
        arrayList_mustard.add("CORAL-437  (PAC-437)");
        arrayList_mustard.add("Pant Rai-19 (PR-2006-1)");
        arrayList_mustard.add("RGN-229");
        arrayList_mustard.add("RGN-236");


        arrayList_sesame = new ArrayList<>();
        arrayList_sesame.add("Select");
        arrayList_sesame.add("DSS-9");
        arrayList_sesame.add("JLT-408");


        arrayList_sunflower = new ArrayList<>();
        arrayList_sunflower.add("Select");
        arrayList_sunflower.add("RSFH-130 (Bhadra)");
        arrayList_sunflower.add("RSFV-901 (Kanthi)");


        arrayList_blackgram = new ArrayList<>();
        arrayList_blackgram.add("Select");
        arrayList_blackgram.add("Vishwas (NUL-7)");


        arrayList_chickpea = new ArrayList<>();
        arrayList_chickpea.add("Select");
        arrayList_chickpea.add("HK-4  (HK 05-169)");
        arrayList_chickpea.add("L-555 (GLK-26155)");
        arrayList_chickpea.add("Raj Vijay Gram 203 (RVG 203)");


        arrayList_cowpea = new ArrayList<>();
        arrayList_cowpea.add("Select");
        arrayList_cowpea.add("MFC-08-14 (Forage)");


        arrayList_fieldpea = new ArrayList<>();
        arrayList_fieldpea.add("Select");
        arrayList_fieldpea.add("HFP 529");


        arrayList_monng = new ArrayList<>();
        arrayList_monng.add("Select");
        arrayList_monng.add("KM 2195 (Swati)");


        arrayList_horsegram = new ArrayList<>();
        arrayList_horsegram.add("Select");
        arrayList_horsegram.add("Gujarat Dantiwada Horsegram-1 (GHG-5)");


        arrayList_lentil = new ArrayList<>();
        arrayList_lentil.add("Select");
        arrayList_lentil.add("IPL-316");


        arrayList_sugarcane = new ArrayList<>();
        arrayList_sugarcane.add("Select");
        arrayList_sugarcane.add("Co 0237");
        arrayList_sugarcane.add("Co 0403");
        arrayList_sugarcane.add("CoVSI-9805");
        arrayList_sugarcane.add("Karan-9  (Co-05011)");
        arrayList_sugarcane.add("Pratap Ganna-1  (CoPk-05191)");


        sp_parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_select);
                }
                if (position == 1) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_Cereal);

                    sp_child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> child, View view, int position, long id) {

                            if (position == 0) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_select);
                            }
                            else if (position == 1) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_Fmillet);
                            }
                            else if (position == 2) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_Maize);
                            }
                            else if (position == 3) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_Pmillet);
                            }
                            else if (position == 4) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_rice);
                            }
                            else if (position == 5) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sorghum);
                            }
                            else if (position == 6) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_wheat);
                            }
                            sp_child1.setAdapter(arrayAdapter_child1);
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> child) {}
                    });

                }
                if (position == 2) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_Fibre);

                    sp_child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> child, View view, int position, long id) {

                            if (position == 0) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_select);
                            }
                            else if (position == 1) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_cotton);
                            }
                            else if (position == 2) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_jute);
                            }
                            else if (position == 3) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_mesta);
                            }
                            else if (position == 4) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sunhemp);
                            }
                            sp_child1.setAdapter(arrayAdapter_child1);
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> child) {}
                    });

                }
                if (position == 3) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_Oils);

                    sp_child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> child, View view, int position, long id) {

                            if (position == 0) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_select);
                            }
                            else if (position == 1) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_castor);
                            }
                            else if (position == 2) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_mustard);
                            }
                            else if (position == 3) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sesame);
                            }
                            else if (position == 4) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sunflower);
                            }
                            sp_child1.setAdapter(arrayAdapter_child1);
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> child) {}
                    });


                }
                if (position == 4) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_pulses);

                    sp_child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> child, View view, int position, long id) {

                            if (position == 0) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_select);
                            }
                            else if (position == 1) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_blackgram);
                            }
                            else if (position == 2) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_chickpea);
                            }
                            else if (position == 3) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_cowpea);
                            }
                            else if (position == 4) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_monng);
                            }
                            else if (position == 5) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_horsegram);
                            }
                            else if (position == 6) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_lentil);
                            }
                            sp_child1.setAdapter(arrayAdapter_child1);
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> child) {}
                    });


                }
                if (position == 5) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sugarcrops);

                    sp_child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> child, View view, int position, long id) {

                            if (position == 0) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_select);
                            }
                            else if (position == 1) {
                                arrayAdapter_child1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sugarcane);
                            }
                            sp_child1.setAdapter(arrayAdapter_child1);
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> child) {}
                    });
                }
                sp_child.setAdapter(arrayAdapter_child);

            }
            @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });




       /* mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Advisory.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        mTv.setText(mDay + "/" + (mMonth+1) + "/" + mYear);
                    }
                }, day, month, year);
                dpd.show();
            }
        });*/


        findViewById(R.id.btnPick1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String crop = sp_parent.getSelectedItem().toString();
                String type = sp_child.getSelectedItem().toString();
                String variety  = sp_child1.getSelectedItem().toString();
                Intent intent = new Intent(Advisory.this, CropDesc.class);

                //String crop = sp_parent.getSelectedItem().toString();

                intent.putExtra("crop",crop);
                intent.putExtra("type",type);
                intent.putExtra("variety", variety);
                startActivity(intent);
                //in next activity
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

        topText.setText(resources.getString(R.string.advisory_services));
        c_type.setText(resources.getString(R.string.type_of_crop));
        variety.setText(resources.getString(R.string.variety));
        category.setText(resources.getString(R.string.select_variety));
        //mTv.setText(resources.getString(R.string.dd_mm_yyyy));
        //mbtn.setText(resources.getString(R.string.pick_date));
        mbtn1.setText(resources.getString(R.string.next));
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