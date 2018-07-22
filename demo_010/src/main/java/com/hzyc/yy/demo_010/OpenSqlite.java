package com.hzyc.yy.demo_010;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2018-07-15.
 */
public class OpenSqlite extends SQLiteOpenHelper{

    private static final int VERSION = 3; //数据库的版本
    private static final String DB_NAME = "data.db";

    public OpenSqlite(Context context) {
        super(context, DB_NAME, null,  VERSION);
    }

    //创建  data.db
    //建表  table
    //只调用一次
    @Override
    public void onCreate(SQLiteDatabase db) {
        boolean bol = false;
        //primary key == not null + unique
        db.execSQL("create table person (id integer primary key autoincrement,name varchar(10) unique)");
        bol = true;
        Log.i("数据库状态","Create"+bol);
    }

    //更新
    //在这更新数据库  这个方法默认不会触发  需压你修改版本号 每修改一次   这个方法调用一次
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        boolean bol = false;
        db.execSQL("alter table person add age int(10)");
        bol = true;
        Log.i("数据库状态","Upgrade"+bol);
    }
}
