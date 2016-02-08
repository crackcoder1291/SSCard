package com.example.lenovo.samplecard;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.lenovo.samplecard.adapter.MainPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Context context;

    private TabLayout mTablayout;
    public static ViewPager pager;
    private String[] tabs;
    private ArrayList<Fragment> fragments;
    private MainPagerAdapter pagerAdapter;

    public void instantiate() {

        context = MainActivity.this;
        mTablayout = (TabLayout) findViewById(R.id.tab_layout);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = new String[]{"Insert", "Extract"};

        fragments = new ArrayList<>();
        fragments.add(new ItemsFragment());
        fragments.add(new ItemsFragment());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instantiate();

        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), tabs, fragments);
        pager.setAdapter(pagerAdapter);

        mTablayout.setTabsFromPagerAdapter(pagerAdapter);
        mTablayout.setupWithViewPager(pager);

    }

}
