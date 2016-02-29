package com.jacksen.supportlibrarydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jacksen.supportlibrarydemo.adapter.RecyclerAdapter;
import com.jacksen.supportlibrarydemo.bean.ActivityDetails;
import com.jacksen.supportlibrarydemo.inter.RecyclerItemInter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RecyclerItemInter {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    /**
     *
     */
    private void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(ITEMS);
        recyclerView.setAdapter(adapter);
        adapter.setItemInter(this);

    }

    private static final ActivityDetails[] ITEMS = {
            new ActivityDetails(R.string.label_daynight_theme, R.string.label_daynight_theme, DayNightThemeDemo.class),
            new ActivityDetails(R.string.label_custom_tabs, R.string.desc_custom_tabs, CustomTabsSettingsDemo.class),
            new ActivityDetails(R.string.label_bottom_sheet, R.string.desc_bottom_sheet, BottomSheetDemo.class)
    };


    @Override
    public void onItemClick(View view, int position) {
        ActivityDetails details = ITEMS[position];
        Intent intent = new Intent(MainActivity.this, details.getActivityClass());
        startActivity(intent);
    }
}
