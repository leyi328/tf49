package com.hzyc.yy.demo_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);//加载了xml文件

        //上下文 context == 四大组件 MainActivity.this
        Toast.makeText(MainActivity.this,"想要输出的话",Toast.LENGTH_SHORT).show();

        //获取页面的一个按钮 点击输出提示信息 toast
       /* View view = findViewById(R.id.imageView); //从对应的布局文件XML中获取到指定的控件
        final ImageView imageView = (ImageView) view;
        imageView.setTag("123");

        //添加事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             *//*   Object tag = v.getTag();
                Toast.makeText(MainActivity.this, ""+tag, Toast.LENGTH_SHORT).show();*//*
                imageView.setImageResource(R.drawable.image1);
            }
        });*/

      /*  //触碰事件
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });*/

    }
}
