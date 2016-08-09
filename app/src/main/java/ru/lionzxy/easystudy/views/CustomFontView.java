package ru.lionzxy.easystudy.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import ru.lionzxy.easystudy.R;

/**
 * Created by LionZXY on 09.08.2016.
 */
public class CustomFontView extends TextView {
    public CustomFontView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomFontView,
                0, 0);

        Typeface typeface;
        switch (a.getInt(R.styleable.CustomFontView_font, -1)) {
            case 0:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
                break;
            case 1:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
                break;
            case 2:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Oduda-Bold-Demo.ttf");
                break;
            default:
                typeface = null;
        }

        if(typeface != null)
            this.setTypeface(typeface);
    }
}
