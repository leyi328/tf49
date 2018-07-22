package com.hzyc.yy.demo_05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    //图片  bitmmap
    //按钮 button  imageView  textView editorText
    //特殊的控件  1.需要适配器   2.比较大

   // private Switch aSwitch;

    private Spinner spinner;

    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //aSwitch = (Switch) findViewById(R.id.switch1);

       /* aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });*/

        arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getList());

        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(arrayAdapter);

        //事件很特殊
         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                 //Object object = spinner.getItemAtPosition(position);
                /* String cs = getList().get(position);
                 Toast.makeText(Main3Activity.this, ""+cs, Toast.LENGTH_SHORT).show();*/

                 Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                 //发送意图进行跳转
                 startActivity(intent);
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });

    }

    public List<String> getList(){
        List<String> list = new ArrayList<String>();
        list.add("长春市");
        list.add("吉林市");
        list.add("四平市");
        list.add("松原市");
        list.add("通化市");
        list.add("延吉市");
        return list;
    }
}
