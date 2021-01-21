package com.example.sih_v2.Mandi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sih_v2.R;

public class MandiActivity extends AppCompatActivity {

    EditText dist, edit_commodity;
    Button search;
    String commodity=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandi);

        edit_commodity = findViewById(R.id.edit_commodity);
        dist = findViewById(R.id.edit_district);
        search = findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commodity = edit_commodity.getText().toString();
                Intent intent = new Intent(MandiActivity.this, Show.class);
                intent.putExtra("commo",commodity);
                startActivity(intent);

            }
        });

    }
}