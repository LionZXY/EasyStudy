package ru.lionzxy.easystudy.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import ru.lionzxy.easystudy.R;

/**
 * Created by LionZXY on 28.07.2016.
 */
public class RelativeLayoutWithLine extends RelativeLayout {
    private int color, paddingLeft, paddingRight, paddingTop, paddingBottom, orientation, gravity, size;
    private OnDrowListener event;

    public static interface OnDrowListener {
        void onDrow(Canvas canvas);
    }

    public RelativeLayoutWithLine(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RelativeLayoutWithLine,
                0, 0);

        orientation = a.getInt(R.styleable.RelativeLayoutWithLine_orientation, 0);
        paddingBottom = a.getDimensionPixelSize(R.styleable.RelativeLayoutWithLine_paddingBottom, 0);
        paddingTop = a.getDimensionPixelSize(R.styleable.RelativeLayoutWithLine_paddingTop, 0);
        paddingRight = a.getDimensionPixelSize(R.styleable.RelativeLayoutWithLine_paddingRight, 0);
        paddingLeft = a.getDimensionPixelSize(R.styleable.RelativeLayoutWithLine_paddingLeft, 0);
        gravity = a.getInt(R.styleable.RelativeLayoutWithLine_gravity, 0);
        size = a.getDimensionPixelSize(R.styleable.RelativeLayoutWithLine_sizeLine, 0);
        color = a.getColor(R.styleable.RelativeLayoutWithLine_colorLine, Color.BLACK);

        this.setWillNotDraw(false);
    }

    public void setOnDrowListener(OnDrowListener listener) {
        event = listener;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int startX = 0, startY = 0, endX = canvas.getWidth(), endY = canvas.getHeight();
        switch (gravity) {
            case 0: //Top
                startY = 0;
                break;
            case 1: //Bottom
                startY = canvas.getHeight();
                break;
            case 2: //Left
                startX = 0;
                break;
            case 3: //Right
                startX = canvas.getWidth();
                break;
        }

        startX += paddingLeft;
        startY += paddingTop;

        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(size);

        switch (orientation) {
            case 0:
                startY -= paddingBottom;
                endX -= paddingRight;
                endY = startY;
                break;
            case 1:
                startX -= paddingRight;
                endY -= paddingBottom;
                endX = startX;
                break;
        }

        canvas.drawLine(startX, startY, endX, endY, paint);

        if (event != null)
            event.onDrow(canvas);
    }
}
