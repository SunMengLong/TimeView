package com.menglong.timeview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listView;
    ArrayList<DataBean> dataList = new ArrayList<DataBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        initData();
        listView.setAdapter(new MyBaseAdapter());
    }

    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int arg0) {
            return dataList.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            View view = View.inflate(MainActivity.this, R.layout.item, null);
            TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
            TextView tv_time = (TextView) view.findViewById(R.id.tv_time);
            TimeView timeView = (TimeView) view.findViewById(R.id.timeView);
            timeView.setTime(dataList.get(arg0).getTime());
            tv_content.setText(dataList.get(arg0).getContent());
            tv_time.setText(dataList.get(arg0).getTime());
            return view;
        }
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            dataList.add(new DataBean("哈哈哈哈" + i, "25/10"));
        }
    }

}