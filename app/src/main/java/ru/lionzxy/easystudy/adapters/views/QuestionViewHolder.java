package ru.lionzxy.easystudy.adapters.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ru.lionzxy.easystudy.activitys.AnswersListActivity;
import ru.lionzxy.easystudy.activitys.QuestionsActivity;
import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.models.interfaces.IQuestion;
import ru.lionzxy.easystudy.views.OnPressedButton;

/**
 * Created by LionZXY on 07.08.2016.
 */
public class QuestionViewHolder extends RecyclerView.ViewHolder {
    OnPressedButton button;

    public QuestionViewHolder(View itemView) {
        super(itemView);

        this.button = (OnPressedButton) itemView.findViewById(R.id.pressedButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(button.getContext(), QuestionsActivity.class);
                button.getContext().startActivity(intent);
            }
        });
    }

    public QuestionViewHolder setItem(@NonNull final IQuestion question) {
        if (question == null)
            return this;

        this.button.clear();
        this.button.setText(question.getQuestion());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(button.getContext(), AnswersListActivity.class);
                intent.putExtra("question", question);
                button.getContext().startActivity(intent);
            }
        });
        return this;
    }
}
