package ru.lionzxy.easystudy.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.views.ThemeViewHolder;
import ru.lionzxy.easystudy.models.interfaces.ITheme;

/**
 * Created by LionZXY on 02.08.2016.
 */
public class ThemeAdapter extends RecyclerView.Adapter<ThemeViewHolder> {
    public List<ITheme> seminars = new ArrayList<>();

    public ThemeAdapter(@NonNull List<ITheme> seminars) {
        this.seminars = seminars;
    }

    @Override
    public ThemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.theme_list_element, parent, false);
        return new ThemeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ThemeViewHolder holder, int position) {
        holder.setItem(seminars.get(position));
    }

    @Override
    public int getItemCount() {
        return seminars.size();
    }
}
