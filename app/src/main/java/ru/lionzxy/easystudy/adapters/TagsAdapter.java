package ru.lionzxy.easystudy.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.views.TagsViewHolder;
import ru.lionzxy.easystudy.models.Tag;

/**
 * Created by LionZXY on 01.08.2016.
 */
public class TagsAdapter extends RecyclerView.Adapter<TagsViewHolder> {
    public List<Tag> tags;

    public TagsAdapter(@NonNull List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public TagsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.question_answer_tag, parent, false);
        return new TagsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TagsViewHolder holder, int position) {
        holder.setItem(tags.get(position));
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }
}
