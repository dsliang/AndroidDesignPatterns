package com.dsliang.androiddesignpatterns.decorator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dsliang.androiddesignpatterns.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dsliang on 2016/9/18.
 */
public class DecoratorActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator);

        initView();
        initDate();
    }

    private void initDate() {

        RecyclerView.Adapter adapter;
        List<String> list;

        list = Arrays.asList(getResources().getStringArray(R.array.english_letters));
        adapter = new SimpleRecycleViewAdapter(this, list);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new BottomLoadDecorator(this, adapter, R.layout.layout_bottom_load_decorator);
        mRecyclerView.setAdapter(adapter);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleViewDecorator);
    }
}
