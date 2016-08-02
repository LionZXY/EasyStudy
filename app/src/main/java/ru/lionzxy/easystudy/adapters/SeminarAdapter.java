package ru.lionzxy.easystudy.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.views.SeminarViewHolder;
import ru.lionzxy.easystudy.models.Seminar;

/**
 * Created by LionZXY on 02.08.2016.
 */
public class SeminarAdapter extends RecyclerView.Adapter<SeminarViewHolder> {
    public List<Seminar> seminars;

    public SeminarAdapter(@NonNull List<Seminar> seminars) {
        this.seminars = seminars;
    }

    @Override
    public SeminarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.theme_list_element, parent, false);
        return new SeminarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SeminarViewHolder holder, int position) {
        holder.setItem(seminars.get(position));
    }

    @Override
    public int getItemCount() {
        return seminars.size();
    }
}
