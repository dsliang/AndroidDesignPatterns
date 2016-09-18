package com.dsliang.androiddesignpatterns.decorator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsliang.androiddesignpatterns.R;
import com.dsliang.androiddesignpatterns.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsliang on 2016/9/18.
 */
public class SimpleRecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context mContext;
    List<String> mList;

    LayoutInflater mLayoutInflater;

    public SimpleRecycleViewAdapter(Context context, List<String> list) {

        if (null == context)
            throw new IllegalArgumentException("Parameter is null");

        mContext = context;
        mList = null != list ? list : new ArrayList<String>();

        mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        view = mLayoutInflater.inflate(R.layout.layout_simple_recycleview_item, parent, false);

        return new ViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setText(R.id.txtTag, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
