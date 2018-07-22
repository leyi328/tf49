package com.hzyc.yy.demo_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;

public class Main4Activity extends AppCompatActivity {

    private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

      /*  for(int i = 1; i<=10; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.image1);
            scrollView.addView(imageView);
        }*/
    }
}
