package com.hzyc.yy.demo_05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    private ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.i("生命周期","onCreate");
        setContentView(R.layout.activity_main2);
        listView2 = (ListView) findViewById(R.id.listView2);

        listView2.setAdapter(new Image_TextActivity(getList(),Main2Activity.this));

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //跳转页面  intent 意图
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                //发送意图进行跳转
                startActivity(intent);
            }
        });
    }
    public List<Map<String,Object>> getList(){

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(int i = 1; i<=16; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("photo",R.drawable.image1);
            map.put("name","美食"+i);
            map.put("price",12+i);
            map.put("rating",i%5);
            map.put("bz","MIMIX");
            list.add(map);
        }
        return list;
    }

    //2
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("生命周期","onStart");
    }

    //3

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("生命周期","onResume");
    }

    //4

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("生命周期","onPause");
    }

    //5

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("生命周期","onStop");
    }

    //6
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("生命周期","onDestroy");
    }

    //7

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("生命周期","onRestart");
    }
}
