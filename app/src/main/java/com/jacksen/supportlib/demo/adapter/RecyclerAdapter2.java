package com.jacksen.supportlib.demo.adapter;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jacksen.supportlib.demo.R;
import com.jacksen.supportlib.demo.bean.BeautyBean;
import com.jacksen.supportlib.demo.inter.RecyclerItemInter;

/**
 * Created by jacksen on 2016/2/29.
 */
public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder> {

    private BeautyBean[] items;

    private RecyclerItemInter itemInter;


    public void setItemInter(RecyclerItemInter itemInter) {
        this.itemInter = itemInter;
    }

    public RecyclerAdapter2(BeautyBean[] items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (items[position].getImageId() != 0) {
            holder.getPicIv().setImageResource(items[position].getImageId());
        }
        ViewCompat.setTransitionName(holder.getPicIv(), String.valueOf(position) + "_beauty");

        holder.getTitleTv().setText(items[position].getName());
        holder.getDescTv().setText(items[position].getDesc());
        holder.getLinearLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != itemInter) {
                    itemInter.onItemClick(holder.itemView, position);
                }
            }
        });
        holder.getPicIv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != itemInter) {
                    itemInter.onIvClick(holder, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    /**
     *
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayout;
        private ImageView picIv;
        private TextView titleTv;
        private TextView descTv;

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }

        public void setLinearLayout(LinearLayout linearLayout) {
            this.linearLayout = linearLayout;
        }

        public ImageView getPicIv() {
            return picIv;
        }

        public void setPicIv(ImageView picIv) {
            this.picIv = picIv;
        }

        public TextView getTitleTv() {
            return titleTv;
        }

        public void setTitleTv(TextView titleTv) {
            this.titleTv = titleTv;
        }

        public TextView getDescTv() {
            return descTv;
        }

        public void setDescTv(TextView descTv) {
            this.descTv = descTv;
        }

        public ViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.item_layout);
            picIv = (ImageView) itemView.findViewById(R.id.item_pic_iv);
            titleTv = (TextView) itemView.findViewById(R.id.item_title_tv);
            descTv = (TextView) itemView.findViewById(R.id.item_desc_tv);
        }
    }
}
