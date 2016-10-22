package com.jacksen.supportlibrarydemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * bottom navigation
 * <p>
 * https://material.google.com/components/bottom-navigation.html#
 *
 * @author jacksen
 */
public class BottomNaviViewActivity extends BaseActivity {

    private BottomNavigationView bottomNaviView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navi_view);

        //
        bottomNaviView = (BottomNavigationView) findViewById(R.id.bottom_navi_view);

        bottomNaviView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(BottomNaviViewActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

}
