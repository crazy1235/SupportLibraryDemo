package com.jacksen.supportlibrarydemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;

/**
 * Created by Admin on 2016/4/25.
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class CustomTransition extends TransitionSet {

    public CustomTransition() {
        setOrdering(ORDERING_TOGETHER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            addTransition(new ChangeBounds())
                    .addTransition(new ChangeTransform())
                    .addTransition(new ChangeImageTransform());
        }
    }
}