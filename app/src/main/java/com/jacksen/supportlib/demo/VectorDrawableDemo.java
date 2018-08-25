package com.jacksen.supportlib.demo;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class VectorDrawableDemo extends AppCompatActivity {


    @BindView(R.id.vector_drawable_iv)
    ImageView vectorDrawableIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_drawable_demo);
        ButterKnife.bind(this);


        Drawable drawable = vectorDrawableIv.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

    }
}
