package com.zhi.www.simpleadapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    private ListView mLv;
    private SimpleAdapter mAdapter;

    private String[] names = new String[]{"01号", "02号","03号","04号","05号","06号"};
    private int[] images = new int[]{R.mipmap.icon_01, R.mipmap.icon_02,
            R.mipmap.icon_03,R.mipmap.icon_02,R.mipmap.icon_01,R.mipmap.icon_03};
    private List<HashMap<String, Object>> mData = new ArrayList<HashMap<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLv = (ListView) findViewById(R.id.lv);

        for(int i=0;i<names.length;i++){
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("names", names[i]);
            data.put("images", images[i]);
            data.put("des", "这真的是一个很棒的。。。");
            mData.add(data);
        }

        mAdapter = new SimpleAdapter(this, mData, R.layout.item, new String[]{
                "names", "images" , "des"
        }, new int[]{
                R.id.tv_name, R.id.iv_image, R.id.tv_des});
        mLv.setAdapter(mAdapter);
    }
}
