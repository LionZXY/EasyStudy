package ru.lionzxy.easystudy.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by lionzxy on 7/21/16.
 */
public class OdudaBoldText extends TextView {

    public OdudaBoldText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Oduda-Bold-Demo.ttf"));
    }
}
