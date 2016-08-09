package ru.lionzxy.easystudy.helpers;

import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.TagsAdapter;
import ru.lionzxy.easystudy.models.interfaces.IAnswer;

/**
 * Created by LionZXY on 07.08.2016.
 */
public class ViewHolderHelper {

    public static void setAnswer(CardView cardView, IAnswer answer) {

        ((RecyclerView) cardView.findViewById(R.id.question_tags)).setLayoutManager(new LinearLayoutManager(cardView.getContext(),
                LinearLayoutManager.HORIZONTAL, false));

        answer.getAuthor().getAvatar().setImage((CircleImageView) cardView.findViewById(R.id.question_avatar_image));
        ((TextView) cardView.findViewById(R.id.question_user_name)).setText(answer.getAuthor().getTitleName());
        ((TextView) cardView.findViewById(R.id.question_text)).setText(answer.getAnswer().getText());
        ((TextView) cardView.findViewById(R.id.question_favor)).setText(String.valueOf(answer.getFavorites()));
        ((TextView) cardView.findViewById(R.id.question_time)).setText(TimeHelper.timeToString(answer.getDateCreated()));
        ((RecyclerView) cardView.findViewById(R.id.question_tags)).setAdapter(new TagsAdapter(answer.getTags()));
    }
}
