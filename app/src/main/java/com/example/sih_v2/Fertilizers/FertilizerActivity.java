package com.example.sih_v2.Fertilizers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sih_v2.R;

import java.util.ArrayList;

public class FertilizerActivity extends AppCompatActivity {
    Spinner sp_category;
    Button search;
    String sp_val;
    long selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer);

        search = findViewById(R.id.search);

        sp_category = findViewById(R.id.sp_category);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this,R.array.category,android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_category.setAdapter(adapterSpinner);

        sp_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this,"On Selected",Toast.LENGTH_SHORT).show();
                sp_val = String.valueOf(sp_category.getSelectedItem());
                if(!(sp_val.equals("See All"))){
                    selected=sp_category.getSelectedItemPosition();

                }
                else{
                    selected=0;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(FertilizerActivity.this,"On Nothing Selected Selected",Toast.LENGTH_SHORT).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FertilizerActivity.this, ShowShop.class);
                intent.putExtra("val",selected);
                intent.putExtra("val2",sp_val);
                // sp_category.setSelection(sp_category.getSelectedItemPosition());
                startActivity(intent);
            }
        });


    }
}