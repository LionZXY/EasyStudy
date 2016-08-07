package ru.lionzxy.easystudy.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.views.QuestionViewHolder;
import ru.lionzxy.easystudy.models.interfaces.IQuestion;

/**
 * Created by LionZXY on 07.08.2016.
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionViewHolder> {
    public List<IQuestion> questions;

    public QuestionAdapter(@NonNull List<IQuestion> questions) {
        this.questions = questions;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.theme_list_element, parent, false);
        return new QuestionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        holder.setItem(questions.get(position));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
