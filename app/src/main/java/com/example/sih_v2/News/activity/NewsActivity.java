package com.example.sih_v2.News.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.sih_v2.News.adapter.CategoryAdapter;
import com.example.sih_v2.R;
import com.google.android.material.tabs.TabLayout;


public class NewsActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mContext = this;
        ViewPager viewPager = findViewById(R.id.viewPager);
        CategoryAdapter adapter = new CategoryAdapter(mContext, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
