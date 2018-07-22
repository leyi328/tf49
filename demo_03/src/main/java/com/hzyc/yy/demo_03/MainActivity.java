package com.hzyc.yy.demo_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



//View.OnClickListener 单击事件
public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/{

    //private Button button;

    private ImageView imageView1,imageView2,imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);

        //调试案例
        //System.out.print(不好使)
        //Toast排队输出
        //调试或输出大量数据
        // logcat日志猫 （改错的时候唯一可以查看的错误信息来源地 == 控制台）
        // tomcat输出信息的时候有级别的  info 信息级别  debug 调试级别  warn警告级别
        // 日志猫  级别/tag   message

     /*   button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //排版  alt+shift+l
                for (int i = 1; i <= 10; i++) {
                    //Toast.makeText(MainActivity.this, "你好"+i, Toast.LENGTH_LONG).show();
                    Log.i("调试信息","我的输出信息"+i);
                }
            }
        });*/


        imageView1 = (ImageView) findViewById(R.id.nicefood);
        imageView2 = (ImageView) findViewById(R.id.playfun);
        imageView3 = (ImageView) findViewById(R.id.service);
/*

        //接口模式
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
*/

      /*  imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "美食", Toast.LENGTH_SHORT).show();
            }
        });*/
    }


  /*  @Override
    public void onClick(View v) {
        //判断点击的是哪一个呢？
    }*/


    public void check(View v){
        //判断点击的是哪一个呢？
        //V 就是你点击的那个控件
        int id = v.getId();
        switch (id){
            case R.id.nicefood :
                Toast.makeText(MainActivity.this, "美食", Toast.LENGTH_SHORT).show();
                break;
            case R.id.playfun :
                Toast.makeText(MainActivity.this, "娱乐", Toast.LENGTH_SHORT).show();
                break;
            case R.id.service :
                Toast.makeText(MainActivity.this, "生活", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
