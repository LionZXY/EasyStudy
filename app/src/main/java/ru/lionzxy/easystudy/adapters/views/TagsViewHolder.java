package ru.lionzxy.easystudy.adapters.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.models.Tag;

/**
 * Created by LionZXY on 01.08.2016.
 */
public class TagsViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public TagsViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.questions_tag);
    }

    public TagsViewHolder setItem(@NonNull Tag tag) {
        if (tag == null)
            return this;

        textView.setText("# " + tag.getTag());

        return this;
    }
}
