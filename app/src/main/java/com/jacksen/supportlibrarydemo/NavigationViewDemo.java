package com.jacksen.supportlibrarydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author jacksen
 */
public class NavigationViewDemo extends AppCompatActivity implements OnClickListener {

    @Bind(R.id.simple_navi_view_btn)
    Button simpleNaviViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view_demo);
        ButterKnife.bind(this);
    }


    @OnClick(value = {R.id.simple_navi_view_btn})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simple_navi_view_btn:
                startActivity(new Intent(NavigationViewDemo.this, SimpleNaviView.class));
                break;
            default:

                break;
        }
    }
}
