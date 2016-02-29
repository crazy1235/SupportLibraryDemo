package com.jacksen.supportlibrarydemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jacksen.supportlibrarydemo.R;
import com.jacksen.supportlibrarydemo.bean.ActivityDetails;
import com.jacksen.supportlibrarydemo.inter.RecyclerItemInter;

/**
 * Created by jacksen on 2016/2/29.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private ActivityDetails[] items;

    private RecyclerItemInter itemInter;


    public void setItemInter(RecyclerItemInter itemInter) {
        this.itemInter = itemInter;
    }

    public RecyclerAdapter(ActivityDetails[] items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.getTitleTv().setText(items[position].getTitleId());
        holder.getDescTv().setText(items[position].getDescriptionId());
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

        private LinearLayout linearLayout;
        private TextView titleTv;
        private TextView descTv;

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }

        public void setLinearLayout(LinearLayout linearLayout) {
            this.linearLayout = linearLayout;
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
            titleTv = (TextView) itemView.findViewById(R.id.item_title_tv);
            descTv = (TextView) itemView.findViewById(R.id.item_desc_tv);
        }
    }
}
