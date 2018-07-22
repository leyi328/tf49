package com.hzyc.yy.demo_011;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button read_010;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        read_010 = (Button) findViewById(R.id.read_010);

        read_010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "content://com.hzyc.yy.demo_010.MyContentProvider/person";
                ContentResolver cr = getContentResolver();
                Cursor cursor = cr.query(Uri.parse(uri), new String[]{"name", "age"}, null, null, null);
                while (cursor.moveToNext()){
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    Log.i("内容提供者信息","name="+name+"   age="+age);
                }
            }
        });
    }
}
