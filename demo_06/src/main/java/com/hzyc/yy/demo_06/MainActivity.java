package com.hzyc.yy.demo_06;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText name,psd;
    private Button toMain2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        psd = (EditText) findViewById(R.id.psd);
        toMain2 = (Button) findViewById(R.id.toMain2);


        SharedPreferences spf = getSharedPreferences("data",0);
        String name1 = spf.getString("name1","nothing");

        if(!"nothing".equals(name1)){
            name.setText(name1);
        }
        //onCreate 方法只加载一次
        //只获取一次  （如果你的控件数据比较大 比较多  只取一次性能会要一些）
        /*final String name1 = name.getText().toString().trim();
        String psd1 = psd.getText().toString().trim();*/

        toMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = name.getText().toString().trim();
                String psd1 = psd.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                //1.传值方式 可以使用意图传值
                //map模式 key-value
              /*  intent.putExtra("name",name1);
                intent.putExtra("psd",psd1);*/



                //2.类似于Javabean模式  需要通过统一bean封装一些数据 传输的过程传输零散的属性
                //  实体bean  -> 对象  （面向对象）
                //跳转  非安全级别的   requestCode  reslutCode==response
                //intent 装里10个数据 导致intent变大  跳转页面的（跳转页面的速度变慢）
                Bundle bundle = new Bundle();
                bundle.putString("name",name1);
                bundle.putString("psd",psd1);

                intent.putExtras(bundle);

                //startActivity(intent);//非安全跳转 也叫单向跳转
                //如果two需要返回值给one
                //1
                startActivityForResult(intent,0); //开始一个activity 并得到结果  激活一个函数 默认父类中自带的  主要的作用是接收 setResult的数据


                //Activity  重量级视图的组件  （信号不好  越用越卡  死机）
                //运行在虚拟机中 运行在真机中完全不一样的
                //Java 二次开发   Scanner Date Math （拿到Java的源代码 在源代码的基础上再次进行开发）
                //android 三次开发  java - > android -> ArrayMap


            }
        });
    }

    //3
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == 200){
            String backValue = data.getStringExtra("backValue");
            Toast.makeText(MainActivity.this, backValue, Toast.LENGTH_SHORT).show();
        }
    }

    //在系统企图被杀死的时候自动调用
    //存储在硬盘 手机上硬盘  固定存储内存 （虚拟机  ROOT权限才可以查看内存中的数据）
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String name1 = name.getText().toString().trim();
        if("".equals(name1)){
            Toast.makeText(MainActivity.this, "不需要保护的", Toast.LENGTH_SHORT).show();
        }else{
            //存储到xml
            //手机应用内部（06） 是否存在data.xml  不存在创建data  存在会找到data获取
            SharedPreferences spf = getSharedPreferences("data",0);
            //得到这个data编辑权限
            SharedPreferences.Editor editor = spf.edit();
            editor.putString("name1",name1);  //< name="name1"> name1 </name>
            boolean bol = editor.commit();
            Toast.makeText(MainActivity.this, "保护状态="+bol, Toast.LENGTH_SHORT).show();
        }
    }
}
