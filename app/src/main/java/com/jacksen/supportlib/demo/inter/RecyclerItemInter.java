package com.jacksen.supportlib.demo.inter;

import android.view.View;

import com.jacksen.supportlib.demo.adapter.RecyclerAdapter2;

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
     *
     */
    void onIvClick(RecyclerAdapter2.ViewHolder holder, int position);
}
