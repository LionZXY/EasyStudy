package ru.lionzxy.easystudy.animations;

import android.animation.ArgbEvaluator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

/**
 * Created by LionZXY on 25.07.2016.
 */
public class ChangeTextColorAnimation extends Animation {
    final TextView view;
    final int colorFrom, colorTo;

    public ChangeTextColorAnimation(TextView view, int colorFrom, int colorTo, long time) {
        this.view = view;
        this.colorFrom = colorFrom;
        this.colorTo = colorTo;
        this.setFillAfter(true);
        this.setFillEnabled(true);
        this.setDuration(time);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        view.setTextColor((Integer) new ArgbEvaluator().evaluate(interpolatedTime, colorFrom, colorTo));
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }
}
