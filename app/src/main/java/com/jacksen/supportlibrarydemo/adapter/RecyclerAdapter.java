package com.jacksen.supportlibrarydemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jacksen.supportlibrarydemo.R;
import com.jacksen.supportlibrarydemo.bean.BeautyBean;
import com.jacksen.supportlibrarydemo.inter.RecyclerItemInter;

/**
 * Created by jacksen on 2016/2/29.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private BeautyBean[] items;

    private RecyclerItemInter itemInter;


    public void setItemInter(RecyclerItemInter itemInter) {
        this.itemInter = itemInter;
    }

    public RecyclerAdapter(BeautyBean[] items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (items[position].getImageId() != 0) {
            holder.getPicIv().setImageResource(items[position].getImageId());
        }
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
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    /**
     *
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout linearLayout;
        private ImageView picIv;
        private TextView titleTv;
        private TextView descTv;

        public RelativeLayout getLinearLayout() {
            return linearLayout;
        }

        public void setLinearLayout(RelativeLayout linearLayout) {
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

            linearLayout = (RelativeLayout) itemView.findViewById(R.id.item_layout);
            picIv = (ImageView) itemView.findViewById(R.id.item_pic_iv);
            titleTv = (TextView) itemView.findViewById(R.id.item_title_tv);
            descTv = (TextView) itemView.findViewById(R.id.item_desc_tv);
        }
    }
}
