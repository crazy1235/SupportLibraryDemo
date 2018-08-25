package com.jacksen.supportlib.demo.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacksen.supportlib.demo.R;
//import com.jacksen.supportlibrarydemo.adapter.DetailRecyclerAdapter;
import com.jacksen.supportlib.demo.inter.OnViewClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 内容详情fragment
 * 图片 + 文字
 *
 * @author jacksen
 */
public class ContentDetailFragment extends Fragment {

    @BindView(R.id.content_fab)
    FloatingActionButton contentFab;

    @BindView(R.id.detail_recycler_view)
    RecyclerView recyclerView;

    private Unbinder unbinder;

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
        unbinder = ButterKnife.bind(this, view);

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


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

//        DetailRecyclerAdapter adapter = new DetailRecyclerAdapter(10);
//        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
