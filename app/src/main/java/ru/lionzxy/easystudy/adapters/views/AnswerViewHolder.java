package ru.lionzxy.easystudy.adapters.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ru.lionzxy.easystudy.activitys.AnswerActivity;
import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.helpers.ViewHolderHelper;
import ru.lionzxy.easystudy.models.interfaces.IAnswer;

/**
 * Created by LionZXY on 01.08.2016.
 */
public class AnswerViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;

    public AnswerViewHolder(View itemView) {
        super(itemView);

        cardView = (CardView) itemView.findViewById(R.id.question_card);
    }

    public AnswerViewHolder setItem(@NonNull final IAnswer answer) {
        if (answer == null)
            return this;

        ViewHolderHelper.setAnswer(cardView, answer);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AnswerActivity.class);
                intent.putExtra("answer", answer);
                v.getContext().startActivity(intent);
            }
        });
        return this;
    }
}
