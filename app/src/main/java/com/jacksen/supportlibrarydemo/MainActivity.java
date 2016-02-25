package com.jacksen.supportlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                String state = "null";
                switch (newState) {
                    case 1:
                        state = "STATE_DRAGGING";
                        break;
                    case 2:
                        state = "STATE_SETTLING";
                        break;
                    case 3:
                        state = "STATE_EXPANDED";
                        break;
                    case 4:
                        state = "STATE_COLLAPSED";
                        break;
                    case 5:
                        state = "STATE_HIDDEN";
                        break;
                }
                Log.d("MainActivity", "newState:" + state);
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
//                Log.d("MainActivity", "slideOffset:" + slideOffset);
            }
        });
        bottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "bottomSheet", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn = (Button) findViewById(R.id.hhh_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hhh", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void setModeNightNo(View view) {
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        recreate();
    }

    public void setModeNightYes(View view) {
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        recreate();
    }

    public void setModeNightAuto(View view) {
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        recreate();
    }
}
