package com.hzyc.yy.demo_05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-04.
 */
public class Image_TextActivity extends BaseAdapter {

    //Activity里面的list和context传进来
    //android  只有一个办法 通过构造方法
    private List<Map<String,Object>> list;
    private Context context;
    public Image_TextActivity(List<Map<String,Object>> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            view = LayoutInflater.from(context).inflate(R.layout.iamge_text,null);
        }else{
            view = convertView;
        }
        //取出控件
        ImageView imageView = (ImageView) view.findViewById(R.id.photo);
        TextView textView1 = (TextView) view.findViewById(R.id.name);
        TextView textView2 = (TextView) view.findViewById(R.id.price);
        TextView textView3 = (TextView) view.findViewById(R.id.bz);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        imageView.setImageResource(Integer.parseInt(list.get(position).get("photo").toString()));
        textView1.setText(list.get(position).get("name").toString());
        textView2.setText(list.get(position).get("price").toString());
        textView3.setText(list.get(position).get("bz").toString());
        ratingBar.setRating(Float.parseFloat(list.get(position).get("rating").toString()));
        return view;
    }
}