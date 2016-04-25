package com.jacksen.supportlibrarydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import com.jacksen.supportlibrarydemo.fragment.ListFragment;
import com.jacksen.supportlibrarydemo.fragment.OtherFragment;
import com.jacksen.supportlibrarydemo.inter.OnViewClickListener;

public class DetailActivity extends AppCompatActivity implements OnViewClickListener, ListFragment.OnListItemClickListener {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        /*ContentDetailFragment contentDetailFragment = ContentDetailFragment.newInstance();

        contentDetailFragment.setOnViewClickListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, contentDetailFragment)
                .commit();*/

        ListFragment listFragment = ListFragment.newInstance();
        listFragment.setOnListItemClickListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, listFragment)
                .commit();
    }

    @Override
    public void onFabClick(View v) {
        OtherFragment otherFragment = OtherFragment.newInstance();

        ChangeBounds changeBoundsTransition = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            changeBoundsTransition = new ChangeBounds();
            changeBoundsTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
            otherFragment.setSharedElementEnterTransition(changeBoundsTransition);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, otherFragment)
                .addSharedElement(v, getString(R.string.transition_fab))
                .commit();
    }

    @Override
    public void onIvClick(View v) {
        OtherFragment otherFragment = OtherFragment.newInstance();

        Slide slideTransition = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            slideTransition = new Slide(Gravity.RIGHT);
            slideTransition.setDuration(800);
            otherFragment.setEnterTransition(slideTransition);
        }

        ChangeBounds changeBoundsTransition = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            changeBoundsTransition = new ChangeBounds();
            changeBoundsTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
            otherFragment.setSharedElementEnterTransition(changeBoundsTransition);
            otherFragment.setSharedElementReturnTransition(changeBoundsTransition);
        }

//        otherFragment.setSharedElementEnterTransition(new CustomTransition());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, otherFragment)
//                .addToBackStack("otherFragment")
                .addSharedElement(v, getString(R.string.transition_img))
                .commit();
    }

}
