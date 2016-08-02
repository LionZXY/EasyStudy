package ru.lionzxy.easystudy.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.views.AnswerViewHolder;
import ru.lionzxy.easystudy.models.interfaces.IAnswer;

/**
 * Created by LionZXY on 01.08.2016.
 */
public class AnswerAdapter extends RecyclerView.Adapter<AnswerViewHolder> {
    public List<IAnswer> tags;

    public AnswerAdapter(@NonNull List<IAnswer> tags) {
        this.tags = tags;
    }

    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.question_answer_element, parent, false);
        return new AnswerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder holder, int position) {
        holder.setItem(tags.get(position));
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }
}
