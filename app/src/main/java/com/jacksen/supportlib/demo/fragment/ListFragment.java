package com.jacksen.supportlib.demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacksen.supportlib.demo.CustomTransition;
import com.jacksen.supportlib.demo.R;
import com.jacksen.supportlib.demo.adapter.RecyclerAdapter;
import com.jacksen.supportlib.demo.adapter.RecyclerAdapter2;
import com.jacksen.supportlib.demo.bean.BeautyBean;
import com.jacksen.supportlib.demo.inter.RecyclerItemInter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 列表fragment
 *
 * @author jacksen
 */
public class ListFragment extends Fragment implements RecyclerItemInter {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private Unbinder unbinder;

    private OnListItemClickListener onListItemClickListener;

    public void setOnListItemClickListener(ListFragment.OnListItemClickListener onListItemClickListener) {
        this.onListItemClickListener = onListItemClickListener;
    }

    public ListFragment() {
    }

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, view);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        RecyclerAdapter2 adapter = new RecyclerAdapter2(BEAUTY_BEANS);
        recyclerView.setAdapter(adapter);
        adapter.setItemInter(this);
        return view;
    }

    private static final BeautyBean[] BEAUTY_BEANS = {
            new BeautyBean("Avril Lavigne1", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne2", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne3", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne4", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne5", "Avril was born in Canada, the Canadian singer, songwriter creators, actors.")
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null){
            unbinder.unbind();
        }
    }

    @Override
    public void onItemClick(View view, int position) {
    }

    @Override
    public void onIvClick(RecyclerAdapter2.ViewHolder holder, int position) {
//        onListItemClickListener.onIvClick(holder.getPicIv());

        OtherFragment otherFragment = OtherFragment.newInstance();
        otherFragment.setSharedElementEnterTransition(new CustomTransition());
        otherFragment.setSharedElementReturnTransition(new CustomTransition());

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            otherFragment.setEnterTransition(new Fade());
            setExitTransition(new Fade());
        }*/

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, otherFragment)
                .addToBackStack(null)
                .addSharedElement(holder.getPicIv(), getString(R.string.transition_img))
                .commit();
    }

    public interface OnListItemClickListener {
        void onIvClick(View v);
    }
}
