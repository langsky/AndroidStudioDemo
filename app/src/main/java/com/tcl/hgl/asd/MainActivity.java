package com.tcl.hgl.asd;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends LauncherActivity {
    final String PACKAGE_NAME = "com.tcl.hgl.asd.";
    String[] activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities = getResources().getStringArray(R.array.activities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                activities);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        Intent intent = null;
        try {
            Class clazz = Class.forName(PACKAGE_NAME + activities[position]);
            intent = new Intent(MainActivity.this, clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return intent;
    }
}
