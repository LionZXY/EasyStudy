package ru.lionzxy.easystudy.helpers;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by LionZXY on 25.07.2016.
 */
public class PixelHelper {
    public static float pixelFromDP(Resources r, int dp) {
        if (r == null)
            return 0;
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }
}
