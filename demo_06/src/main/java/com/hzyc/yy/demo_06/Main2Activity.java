package com.hzyc.yy.demo_06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText setValue;
    private Button toMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setValue = (EditText) findViewById(R.id.setValue);
        toMain = (Button) findViewById(R.id.toMain);

        //获取到意图 MainActivity
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        //String name = intent.getStringExtra("name");
       // String psd = intent.getStringExtra("psd");


        setValue.setText(bundle.getString("name")+"#####"+bundle.getString("psd"));
        //Toast.makeText(Main2Activity.this, "  "+name+"  "+psd, Toast.LENGTH_SHORT).show();


        //当面的页面在退栈的时候 返回给第一个页面一些值
        //正向传值  1->2 1的数据 传递而2
        //backValue  1->2   2退栈在返回到1  2的数据在返回给1    return

        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得回传值
                String backValue = setValue.getText().toString().trim();

                //one intent two (做修改)  two intent one （setResult） 不能使用普通跳转了
                //安全跳转
                //two
                //2
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                //tomcat jsp 发起请求  请求码  服务器中得到返回码 200 - 505  400  403 404  500
                intent.putExtra("backValue",backValue);
                setResult(200,intent);
                //关闭 two
                finish();

            }
        });
    }
}
