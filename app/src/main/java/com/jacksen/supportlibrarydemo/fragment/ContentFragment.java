package com.jacksen.supportlibrarydemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacksen.supportlibrarydemo.BottomSheetDemo;
import com.jacksen.supportlibrarydemo.CustomTabsSettingsDemo;
import com.jacksen.supportlibrarydemo.DayNightThemeDemo;
import com.jacksen.supportlibrarydemo.NavigationViewDemo;
import com.jacksen.supportlibrarydemo.R;
import com.jacksen.supportlibrarydemo.VectorDrawableDemo;
import com.jacksen.supportlibrarydemo.adapter.RecyclerAdapter;
import com.jacksen.supportlibrarydemo.bean.ActivityDetails;
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
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContentFragment.
     */
    public static ContentFragment newInstance(String param1, String param2) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(ITEMS);
        recyclerView.setAdapter(adapter);
        adapter.setItemInter(this);


        return view;
    }

    private static final ActivityDetails[] ITEMS = {
            new ActivityDetails(R.string.label_daynight_theme, R.string.label_daynight_theme, DayNightThemeDemo.class),
            new ActivityDetails(R.string.label_custom_tabs, R.string.desc_custom_tabs, CustomTabsSettingsDemo.class),
            new ActivityDetails(R.string.label_bottom_sheet, R.string.desc_bottom_sheet, BottomSheetDemo.class),
            new ActivityDetails(R.string.label_vector_drawable, R.string.desc_vector_drawable, VectorDrawableDemo.class),
            new ActivityDetails(R.string.label_bottom_sheet, R.string.desc_bottom_sheet, BottomSheetDemo.class),
            new ActivityDetails(R.string.label_vector_drawable, R.string.desc_vector_drawable, VectorDrawableDemo.class),
            new ActivityDetails(R.string.label_bottom_sheet, R.string.desc_bottom_sheet, BottomSheetDemo.class),
            new ActivityDetails(R.string.label_vector_drawable, R.string.desc_vector_drawable, VectorDrawableDemo.class),
            new ActivityDetails(R.string.label_navigation_view, R.string.desc_navigation_view, NavigationViewDemo.class)
    };

    @Override
    public void onItemClick(View view, int position) {
        ActivityDetails details = ITEMS[position];
        Intent intent = new Intent(getActivity(), details.getActivityClass());
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
