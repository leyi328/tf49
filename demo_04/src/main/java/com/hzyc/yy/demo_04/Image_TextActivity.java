package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Image_TextActivity extends AppCompatActivity {

    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__text);
        gridView = (GridView) findViewById(R.id.gridView2);
        gridView.setAdapter(new Image_TextAdapter());
    }

    //数据造好了
    public List<Map<String,Object>> getList(){

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(int i = 1; i<=16; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("photo",R.drawable.image1);
            map.put("name","美食"+i);
            map.put("rating",i%5);
            list.add(map);
        }
        return list;
    }

    public class Image_TextAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return getList().size();
        }
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
            //在适配器中获取image_text.xml获取这个布局文件
            //在从这个文件中获取需要的控件
            View view; //== image_text.xml
            if(convertView == null){
                view = Image_TextActivity.this.getLayoutInflater().inflate(R.layout.image_text,null);
            }else{
                view = convertView;
            }
            //取出控件
            ImageView imageView = (ImageView) view.findViewById(R.id.photo);
            TextView textView = (TextView) view.findViewById(R.id.name);
            RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            imageView.setImageResource(Integer.parseInt(getList().get(position).get("photo").toString()));
            textView.setText(getList().get(position).get("name").toString());
            ratingBar.setRating(Float.parseFloat(getList().get(position).get("rating").toString()));
            return view;
        }
    }
}
