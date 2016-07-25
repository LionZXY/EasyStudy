package ru.lionzxy.easystudy.views;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import ru.lionzxy.easystudy.R;

/**
 * Created by LionZXY on 22.07.2016.
 */
public class SpannableText extends TextView {
    public SpannableText(Context context, AttributeSet attrs) {
        super(context, attrs);

        String text = getText().toString();
        SpannableString content = new SpannableString(text);
        content.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        setText(content);
    }
}
