package com.hzyc.yy.demo_09;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SqliteActivity extends AppCompatActivity {

    private Button createDatabase, update, query;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        createDatabase = (Button) findViewById(R.id.createDatabase);
        update = (Button) findViewById(R.id.update);
        query = (Button) findViewById(R.id.query);

        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1,使用自己的帮助类
                OpenSqlite os = new OpenSqlite(SqliteActivity.this);
                //2.触发整个数据库的状态
                SQLiteDatabase sqLiteDatabase = os.getReadableDatabase();//读
                //os.getWritableDatabase();//写
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSqlite os = new OpenSqlite(SqliteActivity.this);
                //2.触发整个数据库的状态
                SQLiteDatabase sqLiteDatabase = os.getReadableDatabase();
                //首线  看一下数据库的版本 如果是 == 1  调用oncreate
                //再次点击  再吃执行  如果版本依然是1  oncreate也不会执行了
                //对比  newVersion > oldVersion   调用onUpgrade 做到更新

                //sqLiteDatabase.

                sqLiteDatabase.execSQL("insert into userinfo (username,age) values ('张三',23)");
            }
        });

        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSqlite os = new OpenSqlite(SqliteActivity.this);
                //2.触发整个数据库的状态
                SQLiteDatabase sqLiteDatabase = os.getReadableDatabase();
                //sqLiteDatabase.rawQuery("select * from userinfo where username = ?",new String[]{"a"})

                Cursor cursor = sqLiteDatabase.rawQuery("select * from userinfo", null);
                while(cursor.moveToNext()){
                    String username = cursor.getString(cursor.getColumnIndex("username"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    Toast.makeText(SqliteActivity.this, username, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
