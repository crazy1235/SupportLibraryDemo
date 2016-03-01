package com.jacksen.supportlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Bottom Sheet
 *
 * @author jacksen
 */
public class BottomSheetDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_demo);

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


        Button dialogBtn = (Button) findViewById(R.id.bottom_sheet_dialog_btn);
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog(BottomSheetDemo.this);
                dialog.setContentView(R.layout.bottom_sheet_dialog_layout);
                dialog.show();
            }
        });

    }
}
