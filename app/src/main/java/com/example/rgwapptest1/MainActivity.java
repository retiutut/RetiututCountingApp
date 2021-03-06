package com.example.rgwapptest1;

import android.os.Bundle;

import com.example.rgwapptest1.ui.main.PageViewModel;
import com.example.rgwapptest1.ui.main.PlaceholderFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rgwapptest1.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    SectionsPagerAdapter sectionsPagerAdapter;
    ViewPager mPager;
    FragmentManager manager;

    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        sectionsPagerAdapter = new SectionsPagerAdapter(this, manager);
        mPager = findViewById(R.id.view_pager);
        mPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(mPager);
        FloatingActionButton plus = findViewById(R.id.plus);
        FloatingActionButton minus = findViewById(R.id.minus);

        /*
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* THIS IS HOW TO GET THE CURRENTLY VIEWABLE FRAGMENT */
                PlaceholderFragment fragment = (PlaceholderFragment)
                        manager.findFragmentByTag(
                                "android:switcher:" + R.id.view_pager + ":" + mPager.getCurrentItem()
                        );
                Integer i = fragment.getLiveData() == null ? 1 : fragment.getLiveData() - 1;
                fragment.setLiveData(i);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* THIS IS HOW TO GET THE CURRENTLY VIEWABLE FRAGMENT */
                PlaceholderFragment fragment = (PlaceholderFragment)
                        manager.findFragmentByTag(
                                "android:switcher:" + R.id.view_pager + ":" + mPager.getCurrentItem()
                        );
                Integer i = fragment.getLiveData() == null ? 1 : fragment.getLiveData() + 1;
                fragment.setLiveData(i);
            }
        });
    }
}