package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    //准备数据（从数据库中来）
    //数据自己虚拟一些 造一些
    private int [] data = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image1,R.drawable.image1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        //适配器 交给gridView
        gridView.setAdapter(new MyAdapter());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ImageView imageView = view;
                Toast.makeText(MainActivity.this, "索引"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }


    //准备适配器  是所有适配的根类  baseAdapter
    //内部类模式来写
    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.length;
        }
        //position 自动给每一个适配的节点添加的索引 从0开始 正好和数组是一样
        @Override
        public Object getItem(int position) {
            return data[position];
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
            ImageView imageView;
            if(convertView == null){ //如果是第一次进入适配器 缓存的控件是空我们创建控件
                imageView = new ImageView(MainActivity.this);
            }else{
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(data[position]);//数据加载给控件的过程
            return imageView;
        }
    }
}
