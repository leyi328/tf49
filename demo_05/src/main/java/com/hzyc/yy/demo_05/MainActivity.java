package com.hzyc.yy.demo_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayAdapter<CharSequence> arrayAdapter;
    @Override
    //activity页面生命周期的控制方法 （main 页面每显示一次 就会加载一次  最先加载的）
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

       // arrayAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,getList());

        //数据必须是资源 XML
        arrayAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.res,R.layout.support_simple_spinner_dropdown_item);

        listView.setAdapter(arrayAdapter);

    }

   /* public List<String> getList(){
        List<String> list = new ArrayList<String>();
        for(int i = 1; i<=16; i++){
            list.add("数据"+i);
        }
        return list;
    }*/

    //数据的存储技术
    //数据 传输方便   xxx.sql  table 大的话 传输的速度是慢的
    //好几万
    //xml （配置 配置文件 web  框架）  数据描述性 和传输行 （移动的数据库）
    // table直接导成xml 文件大小 变的很小 传输过程中 传递XML就可以了
}
