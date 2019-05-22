package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.adapter.ViewPagerAdapter;


//tanggal pengeerjaan : 20-05-2019
//nim  : 10116569
//nama : Frangky michael
//kelas: IF 13

public class OnBoardingActivity extends AppCompatActivity {

    private ViewPager geser;
    private LinearLayout Layout1;

    private ViewPagerAdapter adapter;
    private TextView[] teks;

    private Button mBtnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        geser = (ViewPager) findViewById(R.id.view_pager_slide);
        Layout1 = (LinearLayout) findViewById(R.id.layout_dots);
        mBtnSkip = (Button) findViewById(R.id.btn_skip);

        adapter = new ViewPagerAdapter(this);

        geser.setAdapter(adapter);

        mBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnBoardingActivity.this, MainActivity.class));
                finish();
            }
        });
        addDots(0);
        geser.addOnPageChangeListener(pagerListener);
    }

    public void addDots(int position){
        Layout1.removeAllViews();
        teks = new TextView[3];
        for (int i = 0; i < teks.length; i++) {
            teks[i] = new TextView(this);
            teks[i].setText(Html.fromHtml("&#8226;"));
            teks[i].setTextSize(35);
            teks[i].setPadding(10,10,10,10);
            teks[i].setTextColor(getResources().getColor(R.color.colorPrimary));

            Layout1.addView(teks[i]);
        }
        if (teks.length > 0){
            teks[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    ViewPager.OnPageChangeListener pagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDots(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
