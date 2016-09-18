package com.dsliang.androiddesignpatterns.decorator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dsliang.androiddesignpatterns.ViewHolder;

/**
 * Created by dsliang on 2016/9/18.
 */
public class BottomLoadDecorator extends RecyclerView.Adapter<ViewHolder> {

    static final private int BOTTOM_LOAD_ITEM_TYPE = Integer.MAX_VALUE - 1;

    RecyclerView.Adapter mAdapter;
    Context mContext;
    LayoutInflater mLayoutInflater;

    int mLayoutId;

    public BottomLoadDecorator(Context context, RecyclerView.Adapter adapte, int layoutId) {
        if (null == adapte || null == context)
            throw new IllegalArgumentException("Parameter is null");

        if (0 == layoutId)
            throw new IllegalArgumentException("Parameters can not be zero");

        mContext = context;
        mAdapter = adapte;
        mLayoutId = layoutId;

        mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder viewHolder = null;

        if (BOTTOM_LOAD_ITEM_TYPE == viewType) {
            viewHolder = new ViewHolder(mContext, mLayoutInflater.inflate(mLayoutId, parent, false));
        } else {
            viewHolder = (ViewHolder) mAdapter.onCreateViewHolder(parent, viewType);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (isBottomLoadView(position)) {
            //do something
        } else {
            mAdapter.onBindViewHolder(holder, position);
        }
    }

    boolean isBottomLoadView(int position) {
        return position >= mAdapter.getItemCount();
    }

    @Override
    public int getItemCount() {
        return mAdapter.getItemCount() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return isBottomLoadView(position) ? BOTTOM_LOAD_ITEM_TYPE : mAdapter.getItemViewType(position);
    }
}
