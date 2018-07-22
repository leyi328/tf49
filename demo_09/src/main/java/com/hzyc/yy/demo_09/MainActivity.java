package com.hzyc.yy.demo_09;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private EditText name,psd;
    private Button save,read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        psd = (EditText) findViewById(R.id.psd);
        save = (Button) findViewById(R.id.save);
        read = (Button) findViewById(R.id.read);

        //1.xml SharedPreferences
        //2.内外存储  存可以 取可以 维护起来不方便
      /*  save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = name.getText().toString().trim();
                String psd1 = psd.getText().toString().trim();
                //创建文件
                //如果data文件不存在  会创建
                //data存在 获取
                SharedPreferences sharedPreferences = getSharedPreferences("data",0);
                //编辑权限
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",name1);
                editor.putString("psd",psd1);
                //编辑
                //editor.remove()//删除

                boolean bol = editor.commit();
                Toast.makeText(MainActivity.this, ""+bol, Toast.LENGTH_SHORT).show();
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("data",0);
                String name = sharedPreferences.getString("name","nothing1");
                String psd = sharedPreferences.getString("psd","nothing2");

                Toast.makeText(MainActivity.this, name+"@@@@@@"+psd, Toast.LENGTH_SHORT).show();
            }
        });*/

        //IO留
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString().trim();
                String psd1 = psd.getText().toString().trim();

                FileOutputStream out = null;
                boolean bol = false;
                try {
                    out = openFileOutput("data.txt",0);
                    String str = name1+"@@@@@@"+psd1;
                    out.write(str.getBytes());
                    bol = true;

                    Toast.makeText(MainActivity.this, "保存状态="+bol, Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileInputStream input = null;
                ByteArrayOutputStream out = null;
                try {
                    input =  openFileInput("data.txt");
                    byte [] data = new byte[1024];
                    //字节 输出成 想要的格式  datainput
                    //写成数据格式
                    out = new ByteArrayOutputStream();
                    int len = 0;
                    while((len = input.read(data)) != -1){
                        out.write(data,0,len);
                    }
                    String values = out.toString();


                    //Java里面能识别的特殊字符串  android中是不好使的
                    String [] strs = values.split("@@@@@@");
                    Toast.makeText(MainActivity.this, strs[0], Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, strs[1], Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        input.close();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }
}
