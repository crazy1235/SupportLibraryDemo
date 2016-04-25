package com.jacksen.supportlibrarydemo.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacksen.supportlibrarydemo.R;
import com.jacksen.supportlibrarydemo.inter.OnViewClickListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 内容详情fragment
 * 图片 + 文字
 *
 * @author jacksen
 */
public class ContentDetailFragment extends Fragment {

    @Bind(R.id.content_fab)
    FloatingActionButton contentFab;

    private OnViewClickListener onViewClickListener;

    public void setOnViewClickListener(OnViewClickListener onViewClickListener) {
        this.onViewClickListener = onViewClickListener;
    }

    public ContentDetailFragment() {
    }

    public static ContentDetailFragment newInstance() {
        ContentDetailFragment fragment = new ContentDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_content_detail, container, false);
        ButterKnife.bind(this, view);

        contentFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*OtherFragment otherFragment = OtherFragment.newInstance();

                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, otherFragment)
                        .addSharedElement(contentFab, getContext().getString(R.string.transition_fab))
                        .commit();*/
                onViewClickListener.onFabClick(v);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
