package com.jacksen.supportlibrarydemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacksen.supportlibrarydemo.CustomTabsSettingsDemo;
import com.jacksen.supportlibrarydemo.DayNightThemeDemo;
import com.jacksen.supportlibrarydemo.DetailActivity;
import com.jacksen.supportlibrarydemo.R;
import com.jacksen.supportlibrarydemo.VectorDrawableDemo;
import com.jacksen.supportlibrarydemo.adapter.RecyclerAdapter;
import com.jacksen.supportlibrarydemo.adapter.RecyclerAdapter2;
import com.jacksen.supportlibrarydemo.bean.ActivityDetails;
import com.jacksen.supportlibrarydemo.bean.BeautyBean;
import com.jacksen.supportlibrarydemo.inter.RecyclerItemInter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * fragment
 *
 * @author jacksen
 */
public class ContentFragment extends Fragment implements RecyclerItemInter {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;


    public ContentFragment() {
    }

    public static ContentFragment newInstance() {
        ContentFragment fragment = new ContentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(BEAUTY_BEANS);
        recyclerView.setAdapter(adapter);
//        recyclerView.getContext();
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        adapter.setItemInter(this);


        return view;
    }


    private static final BeautyBean[] BEAUTY_BEANS = {
            new BeautyBean("Avril Lavigne1", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne2", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne3", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne4", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne5", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne6", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne7", "Avril was born in Canada, the Canadian singer, songwriter creators, actors."),
            new BeautyBean("Avril Lavigne8", "Avril was born in Canada, the Canadian singer, songwriter creators, actors.")

    };

    private static final ActivityDetails[] ITEMS = {
            new ActivityDetails(R.string.label_daynight_theme, R.string.label_daynight_theme, DayNightThemeDemo.class),
            new ActivityDetails(R.string.label_custom_tabs, R.string.desc_custom_tabs, CustomTabsSettingsDemo.class),
            new ActivityDetails(R.string.label_vector_drawable, R.string.desc_vector_drawable, VectorDrawableDemo.class)
    };

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
//        ImageView imageView = (ImageView) view.findViewById(R.id.item_pic_iv);
//        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), imageView, getContext().getString(R.string.transition_img));
//        startActivity(intent, optionsCompat.toBundle());

        startActivity(intent);
    }

    @Override
    public void onIvClick(RecyclerAdapter2.ViewHolder holder, int position) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
