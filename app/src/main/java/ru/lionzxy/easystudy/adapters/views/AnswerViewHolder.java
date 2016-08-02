package ru.lionzxy.easystudy.adapters.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.TagsAdapter;
import ru.lionzxy.easystudy.helpers.TimeHelper;
import ru.lionzxy.easystudy.models.interfaces.IAnswer;

/**
 * Created by LionZXY on 01.08.2016.
 */
public class AnswerViewHolder extends RecyclerView.ViewHolder {
    CircleImageView circleImageView;
    TextView name, text, favor, time;
    RecyclerView tags;

    public AnswerViewHolder(View itemView) {
        super(itemView);

        circleImageView = (CircleImageView) itemView.findViewById(R.id.question_avatar_image);
        name = (TextView) itemView.findViewById(R.id.question_user_name);
        text = (TextView) itemView.findViewById(R.id.question_text);
        favor = (TextView) itemView.findViewById(R.id.question_favor);
        time = (TextView) itemView.findViewById(R.id.question_time);
        tags = (RecyclerView) itemView.findViewById(R.id.question_tags);
        tags.setLayoutManager(new LinearLayoutManager(itemView.getContext(),
                LinearLayoutManager.HORIZONTAL, false));

    }

    public AnswerViewHolder setItem(@NonNull IAnswer answer) {
        if (answer == null)
            return this;

        answer.getAuthor().getAvatar().setImage(circleImageView);
        name.setText(answer.getAuthor().getTitleName());
        text.setText(answer.getAnswer().getText());
        favor.setText(String.valueOf(answer.getFavorites()));
        time.setText(TimeHelper.timeToString(answer.getDateCreated()));
        tags.setAdapter(new TagsAdapter(answer.getTags()));

        return this;
    }
}
