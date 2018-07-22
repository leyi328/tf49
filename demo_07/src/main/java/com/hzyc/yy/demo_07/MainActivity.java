package com.hzyc.yy.demo_07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private TextView textViewOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewOne = (TextView) findViewById(R.id.textViewOne);

        textViewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                //管理动画的   实现修改页面跳转的动画效果
                overridePendingTransition(R.anim.tip_right, R.anim.tip_left);

            }
        });
    }


    //激活选项菜单 optionsMenu 默认存在 需要激活不需要注册
    //选项菜单就会激活  不需要注册
    // menu 表示的就是选项菜单的位置
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater(); //菜单填充器
        menuInflater.inflate(R.menu.one, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //实现菜单选择

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.save:
                Toast.makeText(MainActivity.this, "点击了保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(MainActivity.this, "点击了删除", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sao:
                Toast.makeText(MainActivity.this, "点击了扫一扫", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
