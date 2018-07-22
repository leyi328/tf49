package com.hzyc.yy.demo_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {



    EditText username,password;
    Button login,zc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //首先加载的就是onCreate这方法static{}
        //alt+enter
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        //final  String a = "123";
        //添加事件 内部类形式   内部类 是无法使用外部类的局部变量的
        //需要在内部类中使用外部类的局部变量 == final 局部常量
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取到输入的值
                String name = username.getText().toString().trim();
                String psd = password.getText().toString().trim();

                if("admin".equals(name) && "admin".equals(psd)){
                    Toast.makeText(Main2Activity.this, "登录成功!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main2Activity.this, "登录失败!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
