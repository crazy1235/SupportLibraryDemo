package com.jacksen.supportlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * detail activity
 *
 * @author jacksen
 */
public class ContentDetailActivity extends AppCompatActivity {

    @Bind(R.id.content_toolbar)
    Toolbar contentToolbar;
    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.content_appbar_layout)
    AppBarLayout contentAppbarLayout;
    @Bind(R.id.content_fab)
    FloatingActionButton contentFab;

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
                contentAppbarLayout.setExpanded(false, true);
            }
        });
    }
}
