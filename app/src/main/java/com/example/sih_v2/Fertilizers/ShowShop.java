package com.example.sih_v2.Fertilizers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sih_v2.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ShowShop extends AppCompatActivity {
   RecyclerView recycler;
   Button show;
   PostAdapter adapter;

   //public Spinner sp_category;
   String sp_val=null;
   long selected=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fertilizers);
        show = findViewById(R.id.btnShow);

        Intent intent = getIntent();
        selected = intent.getLongExtra("val",selected);
        sp_val = intent.getStringExtra("val2");
        if(sp_val.equals("See All")){
            sp_val="All";
        }

        /*sp_category = findViewById(R.id.sp_category);
       ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this,R.array.category,android.R.layout.simple_spinner_item);
       adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       sp_category.setAdapter(adapterSpinner);
        */
        //code copy start
            recycler = findViewById(R.id.recycler);
            recycler.setLayoutManager(new LinearLayoutManager(this));


        //sp_category.setSelection(sp_category.getSelectedItemPosition());
        if(selected==0) {
            FirebaseRecyclerOptions<post> options =
                    new FirebaseRecyclerOptions.Builder<post>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("Fertilizer"), post.class)
                            .build();
            //Toast.makeText(ShowShop.this,"RECYCLER CREATED",Toast.LENGTH_SHORT).show();

            adapter = new PostAdapter(options);
            recycler.setAdapter(adapter);
        }
        else{
            FirebaseRecyclerOptions<post> options =
                    new FirebaseRecyclerOptions.Builder<post>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("Fertilizer").orderByChild("Code").equalTo(selected), post.class)
                            .build();
            //Toast.makeText(ShowShop.this,"RECYCLER CREATED",Toast.LENGTH_SHORT).show();

            adapter = new PostAdapter(options);
            recycler.setAdapter(adapter);
        }
        /*sp_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(ShowShop.this,"On Selected",Toast.LENGTH_SHORT).show();
                sp_val = String.valueOf(sp_category.getSelectedItem());
                if(!(sp_val.equals("Search Product By Category"))){
                   selected=sp_category.getSelectedItemPosition();

                }
                else{
                    selected=0;
                }
                iselected=selected;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(ShowShop.this,"On Nothing Selected Selected",Toast.LENGTH_SHORT).show();
            }
        });
        */
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(ShowShop.this, FertilizerActivity.class);
               // intent.putExtra("val",selected);
               // sp_category.setSelection(sp_category.getSelectedItemPosition());
                startActivity(intent);


            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
        Toast.makeText(ShowShop.this,sp_val,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        //Toast.makeText(ShowShop.this,"STOP Method ",Toast.LENGTH_SHORT).show();
        super.onStop();
        adapter.stopListening();
    }
        //code copy end
}