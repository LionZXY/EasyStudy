package ru.lionzxy.easystudy.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.animations.ChangeBackgroundColorAnimation;
import ru.lionzxy.easystudy.animations.ChangeTextColorAnimation;

/**
 * Created by LionZXY on 25.07.2016.
 */
public class OnPressedButton extends Button {
    final int normalColor, onPressedColor;

    public OnPressedButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.PressedButtonAttrs,
                0, 0);

        normalColor = a.getColor(R.styleable.PressedButtonAttrs_normalColor, 0);
        onPressedColor = a.getColor(R.styleable.PressedButtonAttrs_onPressedColor, 0);

        this.setBackgroundColor(normalColor);

        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf"));

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onTouchEvent(event);
                int color;
                AnimationSet animationSet;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        clearAnimation();
                        color = ((ColorDrawable) OnPressedButton.this.getBackground()).getColor();
                        animationSet = new AnimationSet(true);
                        animationSet.addAnimation(new ChangeBackgroundColorAnimation(v, color, onPressedColor, 500L));
                        animationSet.addAnimation(new ChangeTextColorAnimation((TextView) v, ((OnPressedButton) v).getCurrentTextColor(), normalColor, 500L));
                        v.startAnimation(animationSet);
                        return true;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        clearAnimation();
                        color = ((ColorDrawable) OnPressedButton.this.getBackground()).getColor();
                        animationSet = new AnimationSet(true);
                        animationSet.addAnimation(new ChangeBackgroundColorAnimation(v, color, normalColor, 300L));
                        animationSet.addAnimation(new ChangeTextColorAnimation((TextView) v, ((OnPressedButton) v).getCurrentTextColor(), Color.BLACK, 300L));
                        v.startAnimation(animationSet);
                        return true;
                }
                return false;
            }
        });
    }

    public void clear() {
        int color;
        AnimationSet animationSet;

        color = ((ColorDrawable) OnPressedButton.this.getBackground()).getColor();
        animationSet = new AnimationSet(true);
        animationSet.addAnimation(new ChangeBackgroundColorAnimation(this, color, normalColor, 300L));
        animationSet.addAnimation(new ChangeTextColorAnimation(this, this.getCurrentTextColor(), Color.BLACK, 300L));
        startAnimation(animationSet);
    }
}
