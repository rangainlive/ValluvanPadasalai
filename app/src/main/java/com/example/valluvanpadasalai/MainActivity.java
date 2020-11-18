package com.example.valluvanpadasalai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.valluvanpadasalai.Adaptar.LauncherAdaptar;
public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LauncherAdaptar launcherAdaptar;

    private Button prev, next;
    private int myCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pagerView);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        launcherAdaptar = new LauncherAdaptar(this);
        viewPager.setAdapter(launcherAdaptar);

        prev.setOnClickListener(v -> viewPager.setCurrentItem(myCurrentPage-1));
        next.setOnClickListener(v -> {
            viewPager.setCurrentItem(myCurrentPage+1);
            if(myCurrentPage+1 == 4){
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
        viewPager.addOnPageChangeListener(viewListener);
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            myCurrentPage = (position);
            if(position == 0) {
                prev.setEnabled(false);
                next.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                next.setText("Next");
                prev.setText("");
            }
            else if(position == 4){
                prev.setEnabled(true);
                next.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                next.setText("Finish");
                prev.setText("Prev");
            }
            else {
                next.setEnabled(true);
                prev.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                next.setText("Next");
                prev.setText("Prev");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}