package ru.lionzxy.easystudy.animations;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by LionZXY on 25.07.2016.
 */
public class ChangeBackgroundColorAnimation extends Animation {
    final View view;
    final int colorFrom, colorTo;

    public ChangeBackgroundColorAnimation(View view, int colorFrom, int colorTo, long time) {
        this.view = view;
        this.colorFrom = colorFrom;
        this.colorTo = colorTo;
        this.setFillAfter(true);
        this.setFillEnabled(true);
        this.setDuration(time);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        view.setBackgroundColor((Integer) new ArgbEvaluator().evaluate(interpolatedTime, colorFrom, colorTo));
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }
}
