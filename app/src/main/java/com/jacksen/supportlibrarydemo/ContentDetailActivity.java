package com.jacksen.supportlibrarydemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

//import com.jacksen.supportlibrarydemo.adapter.DetailRecyclerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * detail activity
 *
 * @author jacksen
 */
public class ContentDetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    @Bind(R.id.content_toolbar)
    Toolbar contentToolbar;
    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.content_appbar_layout)
    AppBarLayout appbarLayout;
    @Bind(R.id.content_fab)
    FloatingActionButton contentFab;
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    @Bind(R.id.detail_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_detail);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        setSupportActionBar(contentToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setTitle("Details");

        contentFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appbarLayout.setExpanded(false, true);
            }
        });

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ContentDetailActivity.this, "sss", Toast.LENGTH_SHORT).show();
                        swipeRefresh.setRefreshing(false);
                    }
                }, 1000);
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

//        DetailRecyclerAdapter adapter = new DetailRecyclerAdapter(10);
//        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        appbarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        appbarLayout.removeOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0) {
            swipeRefresh.setEnabled(true);
        } else {
            swipeRefresh.setEnabled(false);
        }
    }
}
