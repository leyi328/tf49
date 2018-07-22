package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    /*private int [] data = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1};*/


    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(new MyAdapter());
    }

    public List<String> getList(){
        List<String> list = new ArrayList<String>();

        for(int i = 1; i<=16; i++){
            list.add("数据"+i);
        }
        return list;
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return getList().size();
        }
        //position 自动给每一个适配的节点添加的索引 从0开始 正好和数组是一样
        @Override
        public Object getItem(int position) {
            return getList().get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //把data中的文字 车 马  炮  制作刻字到棋子上
            //返回给适配器一个刻好字的一个其子
            //选额合适的棋子材料（选择控件根据数据来选）
            //convertView 适配器已经生成的控件
            TextView textView;
            if(convertView == null){ //如果是第一次进入适配器 缓存的控件是空我们创建控件
                textView = new TextView(ListViewActivity.this);
                textView.setPadding(10,10,10,10);
                textView.setTextSize(30);
            }else{
                textView = (TextView) convertView;
            }
            textView.setText(getList().get(position));   //数据加载给控件的过程
            return textView;
        }
    }
}
