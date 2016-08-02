package ru.lionzxy.easystudy.adapters.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import ru.lionzxy.easystudy.QuestionsActivity;
import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.models.Seminar;

/**
 * Created by LionZXY on 02.08.2016.
 */
public class SeminarViewHolder extends RecyclerView.ViewHolder {
    Button button;

    public SeminarViewHolder(View itemView) {
        super(itemView);

        this.button = (Button) itemView.findViewById(R.id.pressedButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(button.getContext(), QuestionsActivity.class);
                button.getContext().startActivity(intent);
            }
        });
    }

    public SeminarViewHolder setItem(@NonNull Seminar seminar) {
        if (seminar == null)
            return this;

        this.button.setText(seminar.getTitle());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(button.getContext(), QuestionsActivity.class);
                button.getContext().startActivity(intent);
            }
        });
        return this;
    }
}
