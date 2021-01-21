package com.example.sih_v2.Schemes;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sih_v2.Helper.LocaleHelper;
import com.example.sih_v2.R;
import com.example.sih_v2.Schemes.Dialog.Dialogue1;
import com.example.sih_v2.Schemes.Dialog.Dialogue2;
import com.example.sih_v2.Schemes.Dialog.Dialogue3;
import com.example.sih_v2.Schemes.Dialog.Dialogue4;
import com.example.sih_v2.Schemes.Dialog.Dialogue5;
import com.example.sih_v2.Schemes.Dialog.Dialogue6;
import com.example.sih_v2.Schemes.Dialog.Dialogue7;
import com.example.sih_v2.Schemes.Dialog.Dialogue8;

import io.paperdb.Paper;


public class Scheme extends AppCompatActivity {
    private Button scheme1,desc1,scheme2,desc2,scheme3,desc3,scheme4,desc4,scheme5,desc5,scheme6,desc6,scheme7,desc7,scheme8,desc8;
    TextView top;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);

        top = findViewById(R.id.topText);

        //DIALOG CALLING
        scheme1 = (Button) findViewById(R.id.scheme1);
        scheme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog1();
            }
        });
        desc1 = (Button) findViewById(R.id.desc1);
        desc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog1();
            }
        });

        scheme2 = (Button) findViewById(R.id.scheme2);
        scheme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog2();
            }
        });
        desc2 = (Button) findViewById(R.id.desc2);
        desc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog2();
            }
        });

        scheme3 = (Button) findViewById(R.id.scheme3);
        scheme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog3();
            }
        });
        desc3 = (Button) findViewById(R.id.desc3);
        desc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog3();
            }
        });

        scheme4 = (Button) findViewById(R.id.scheme4);
        scheme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog4();
            }
        });
        desc4 = (Button) findViewById(R.id.desc4);
        desc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog4();
            }
        });

        scheme5 = (Button) findViewById(R.id.scheme5);
        scheme5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog5();
            }
        });
        desc5 = (Button) findViewById(R.id.desc5);
        desc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog5();
            }
        });

        scheme6 = (Button) findViewById(R.id.scheme6);
        scheme6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog6();
            }
        });
        desc6 = (Button) findViewById(R.id.desc6);
        desc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog6();
            }
        });

        scheme7 = (Button) findViewById(R.id.scheme7);
        scheme7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog7();
            }
        });
        desc7 = (Button) findViewById(R.id.desc7);
        desc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog7();
            }
        });

        scheme8 = (Button) findViewById(R.id.scheme8);
        scheme8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog8();
            }
        });
        desc8 = (Button) findViewById(R.id.desc8);
        desc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog8();
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

        top.setText(resources.getString(R.string.schemes));
        scheme1.setText(resources.getString(R.string.pradhanmantri_fasal_bima_yojana));
        desc1.setText(resources.getString(R.string.scheme1));
        scheme2.setText(resources.getString(R.string.pradhanmantri_krishi_sinchayee_yojana));
        desc2.setText(resources.getString(R.string.scheme2));
        scheme3.setText(resources.getString(R.string.paramparagat_krishi_vikas_yojana));
        desc3.setText(resources.getString(R.string.scheme3));
        scheme4.setText(resources.getString(R.string.pradhan_mantri_kisan_samman_nidhi));
        desc4.setText(resources.getString(R.string.scheme4));
        scheme5.setText(resources.getString(R.string.pradhan_mantri_kisan_maandhan_yojana));
        desc5.setText(resources.getString(R.string.scheme5));
        scheme6.setText(resources.getString(R.string.soil_health_card_scheme));
        desc6.setText(resources.getString(R.string.scheme6));
        scheme7.setText(resources.getString(R.string.gramin_bhandaran_yojana));
        desc7.setText(resources.getString(R.string.scheme7));
        scheme8.setText(resources.getString(R.string.kisan_credit_card));
        desc8.setText(resources.getString(R.string.scheme8));
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


    //DIALOG DEFINITION
    public void openDialog1() {
        Dialogue1 exampleDialog = new Dialogue1();
        exampleDialog.show(getSupportFragmentManager(), "Pradhanmantri Fasal Bima Yojana");
    }

    public void openDialog2() {
        Dialogue2 exampleDialog = new Dialogue2();
        exampleDialog.show(getSupportFragmentManager(), "Pradhanmantri Krishi Sinchai Yojana");
    }


    public void openDialog3() {
        Dialogue3 exampleDialog = new Dialogue3();
        exampleDialog.show(getSupportFragmentManager(), "Paramparagat Krishi Vikas Yojana");
    }

    public void openDialog4() {
        Dialogue4 exampleDialog = new Dialogue4();
        exampleDialog.show(getSupportFragmentManager(), "Pradhan Mantri Kisan Samman Nidhi");
    }

    public void openDialog5() {
        Dialogue5 exampleDialog = new Dialogue5();
        exampleDialog.show(getSupportFragmentManager(), "Pradhan Mantri Kisan Maandhan Yojana");
    }

    public void openDialog6() {
        Dialogue6 exampleDialog = new Dialogue6();
        exampleDialog.show(getSupportFragmentManager(), "Soil Health Card Scheme");
    }

    public void openDialog7() {
        Dialogue7 exampleDialog = new Dialogue7();
        exampleDialog.show(getSupportFragmentManager(), "Gramin Bhandaran Yojana");
    }

    public void openDialog8() {
        Dialogue8 exampleDialog = new Dialogue8();
        exampleDialog.show(getSupportFragmentManager(), "Kisan Credit Card");
    }

}