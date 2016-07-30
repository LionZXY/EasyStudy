package ru.lionzxy.easystudy.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by LionZXY on 26.07.2016.
 */
public class RobotoLightText extends TextView {

    public RobotoLightText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Roboto-Light.ttf"));
    }
}
