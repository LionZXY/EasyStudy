package ru.lionzxy.easystudy.adapters.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.Serializable;

import ru.lionzxy.easystudy.activitys.QuestionsActivity;
import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.models.interfaces.ITheme;
import ru.lionzxy.easystudy.views.OnPressedButton;

/**
 * Created by LionZXY on 02.08.2016.
 */
public class ThemeViewHolder extends RecyclerView.ViewHolder {
    OnPressedButton button;

    public ThemeViewHolder(View itemView) {
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

    public ThemeViewHolder setItem(@NonNull final ITheme theme) {
        if (theme == null)
            return this;

        this.button.clear();
        this.button.setText(theme.getTitle());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(button.getContext(), QuestionsActivity.class);
                intent.putExtra("theme",(Serializable) theme);
                button.getContext().startActivity(intent);
            }
        });
        return this;
    }
}
