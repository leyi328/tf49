package com.hzyc.yy.demo_07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;

    private ArrayAdapter<String> arrayAdapter;
    private ActionMode actionMode;

    //action mode模式
    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.one,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int id = item.getItemId();
            switch (id) {
                case R.id.save:
                    Toast.makeText(Main2Activity.this, "点击了保存", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    break;
                case R.id.delete:
                    Toast.makeText(Main2Activity.this, "点击了删除", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    break;
                case R.id.sao:
                    Toast.makeText(Main2Activity.this, "点击了扫一扫", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getList());
        listView.setAdapter(arrayAdapter);

        //registerForContextMenu(listView);//注册  注册到长点击事件上  longCilck

        //注册一个 actionMode菜单
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(actionMode != null){
                    return false;
                }
                actionMode = Main2Activity.this.startActionMode(callback);
                return true;
            }
        });
    }

    public List<String> getList() {

        List<String> list = Arrays.asList("数据1", "数据2", "数据3", "数据4", "数据5", "数据6");

        return list;
    }

    //注册和激活的
   /* @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.one,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.save:
                Toast.makeText(Main2Activity.this, "点击了保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(Main2Activity.this, "点击了删除", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sao:
                Toast.makeText(Main2Activity.this, "点击了扫一扫", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }*/
}
