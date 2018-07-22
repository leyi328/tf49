package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        relativeLayout = (RelativeLayout) findViewById(R.id.rl1);

        //设计页面的 两种方法
        //1.直接修改 布局.xml
        //2.写Java代码 往布局的.xml中添加
        Button button = new Button(Main2Activity.this);
        button.setText("按钮");
        relativeLayout.addView(button);
    }
}
