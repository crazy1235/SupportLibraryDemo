package com.jacksen.supportlibrarydemo.inter;

import android.view.View;

import com.jacksen.supportlibrarydemo.adapter.RecyclerAdapter;

/**
 * Created by jacksen on 2016/2/29.
 */
public interface RecyclerItemInter {

    /**
     * @param view
     * @param position
     */
    void onItemClick(View view, int position);

    /**
     * @param view
     * @param position
     */
    void onIvClick(RecyclerAdapter.ViewHolder holder, int position);
}
