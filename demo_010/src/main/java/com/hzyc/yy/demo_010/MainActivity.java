package com.hzyc.yy.demo_010;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button createDatabase, update, query, call, insetDataByCp, readContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDatabase = (Button) findViewById(R.id.createDatabase);
        update = (Button) findViewById(R.id.update);
        query = (Button) findViewById(R.id.query);
        call = (Button) findViewById(R.id.call);
        insetDataByCp = (Button) findViewById(R.id.insetDataByCp);
        readContact = (Button) findViewById(R.id.readContact);


        final SQLiteDatabase sqLiteDatabase = new OpenSqlite(MainActivity.this).getReadableDatabase();

        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SQLiteDatabase sqLiteDatabase = new OpenSqlite(MainActivity.this).getReadableDatabase();
                // SQLiteDatabase sqLiteDatabase = new OpenSqlite(MainActivity.this).getWritableDatabase();
                //getReadableDatabase == getWritableDatabase 默认情况下
                //得到是一个可以读写数据库的实例
                //磁盘空间已满（20480 db）getReadableDatabase 返回一个只读实例  select 好使的  insert update  不好使
                //磁盘空间已满 getWritableDatabase 不好使了 无法得到数据库实例了


                //无法存储太大的数据 （不要装满）
                sqLiteDatabase.execSQL("insert into person (name,age) values ('张三',20)");
                sqLiteDatabase.execSQL("insert into person (name,age) values ('李四',30)");
                sqLiteDatabase.execSQL("insert into person (name,age) values ('王五',40)");


            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //普通的 sql
             /*   sqLiteDatabase.execSQL("insert into person (name,age) values ('张三',20)");
                sqLiteDatabase.execSQL("insert into person (name,age) values ('李四',30)");
                sqLiteDatabase.execSQL("insert into person (name,age) values ('王五',40)");*/

                //预处理 sql
                //sqLiteDatabase.execSQL("insert into person (name,age) values (?,?)",new Object[]{"李四",23});

                //后学的android  学习语言不是java  C++
                //学完了C++ 学android  简单了解java语言
                //不会使用jdbc 不会写sql
                //持久层快将 追求的一种理念
                //学习到一间是 框架怎么写的
                //框架淘汰初级程序员的产物

                //非sql模式  cotentValues
                //cotentValues 一行记录  map格式   key-value

             /*   ContentValues contentValues = new ContentValues();
                contentValues.put("name","小强");
                contentValues.put("age",20);

                //i==5  i!=影响的行数   == 这行记录的主键值
                //long == 是主键值     int
                long i = sqLiteDatabase.insert("person",null,contentValues);
                Log.i("操作结果",""+i);*/


                //更新
               /* ContentValues contentValues = new ContentValues();
                contentValues.put("name","小明");
                contentValues.put("age",63);
                int i = sqLiteDatabase.update("person",contentValues,"id=?",new String[]{"3"});
                Log.i("操作结果", "" + i);*/

                //删除
                int i = sqLiteDatabase.delete("person", "id=?", new String[]{"1"});
            }

        });


        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cursor cursor = sqLiteDatabase.rawQuery("select * from person order by id",null);

                //非sql查询模式
                //c.move( int offset);    //以当前位置为参考,移动到指定行
                //c.moveToFirst();    //移动到第一行
                //cc.moveToLast();        //移动到最后一行
                //c c.moveToPosition( int position);    //移动到指定行
                //cc.moveToPrevious();    //移动到前一行
                //cc.moveToNext();        //移动到下一行
                //cc.isFirst();        //是否指向第一条
                //cc.isLast();        //是否指向最后一条
                //cc.isBeforeFirst();    //是否指向第一条之前
                //cc.isAfterLast();    //是否指向最后一条之后
                //cc.isNull( int columnIndex);    //指定列是否为空(列基数为0)
                //cc.isClosed();        //游标是否已关闭
                //cc.getCount();        //总数据项数
                //cc.getPosition();    //返回当前游标所指向的行数
                //cc.getColumnIndex(String columnName);//返回某列名对应的列索引值
                //cc.getString( int columnIndex);    //返回当前行指定列的值

                Cursor cursor = sqLiteDatabase.query("person", new String[]{"name", "age"}, "name = ?", new String[]{"张三"}, "name", null, "id desc");

                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));

                    Log.i("操作结果", name + "@@@@@@" + age);
                }

                //封装成list<Map<String,Object>> //写出工具或方法把cuesor转换成list 做一个数据缓存

                //cursor.getColumnCount()//总列数
                //cursor.getType()//获取每列的数据类型
                //cursor.getColumnIndex()// 列索引
                //cursor.getColumnName()// 列名
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10010"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);


                //ContentResolver cr = getContentResolver(); // 客户端 发起请求
                //读取系统联系人
                //不知道uri
                //不知道列名
                // Cursor cursor = cr.query();

            }
        });


        insetDataByCp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //使用010的cp添加数据
             /*   String uri = "content://com.hzyc.yy.demo_010.MyContentProvider/person";
               *//* ContentResolver cr = getContentResolver();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name","擎天柱");
                contentValues.put("age",200);
                Uri uri1 = cr.insert(Uri.parse(uri),contentValues);
                Log.i("内容提供者数据信息",""+uri1);*/


                //删除
              /*  String uri = "content://com.hzyc.yy.demo_010.MyContentProvider/person/10";
                ContentResolver cr = getContentResolver();
                int i = cr.delete(Uri.parse(uri),"id=?",new String[]{"10"});*/

                //修改莫一行
              /*  String uri = "content://com.hzyc.yy.demo_010.MyContentProvider/person/10";

               *//* ContentValues contentValues = new ContentValues();
                contentValues.put("name","威震天");
                contentValues.put("age",210);

                ContentResolver cr = getContentResolver();
                int i = cr.update(Uri.parse(uri),contentValues,"id = ?",new String[]{"10"});*/

            /*    String uri = "content://com.hzyc.yy.demo_010.MyContentProvider/person/10/name";
                ContentValues contentValues = new ContentValues();
                contentValues.put("name","威震天");
                ContentResolver cr = getContentResolver();
                int i = cr.update(Uri.parse(uri),contentValues,"id = ?",new String[]{"10"});*/

                //不知道 CP 不是我写的
                //知道uri
              /*  String uri = "content://com.hzyc.yy.demo_010.MyContentProvider/person/10";
                ContentResolver cr = getContentResolver();
                String values = cr.getType(Uri.parse(uri));*/

                //vnd.android.cursor.dir/  person表
                //vnd.android.cursor.item  person行

                //使用内容提供者查询数据
                String uri = "content://com.hzyc.yy.demo_010.MyContentProvider/person/10";
                ContentResolver cr = getContentResolver();
                Cursor cursor = cr.query(Uri.parse(uri), new String[]{"name", "age"}, "id = ?", new String[]{"10"}, "id asc");
                while (cursor.moveToNext()){
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    Log.i("内容提供者信息","name="+name+"   age="+age);
                }
            }
        });

        readContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver cr = getContentResolver();
                Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, new String[]{ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME}, null, null, null);
                while (cursor.moveToNext()) {
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    Log.i("内容提供者数据信息", "id=" + id + "   name=" + name);
                }
            }
        });
    }
}
