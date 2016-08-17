package ru.lionzxy.easystudy.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.views.DrawerItemViewHolder;
import ru.lionzxy.easystudy.models.DrawerItem;

/**
 * Created by LionZXY on 17.08.2016.
 */
public class DrawerItemAdapter extends RecyclerView.Adapter<DrawerItemViewHolder> {
    public List<DrawerItem> drawerItems;

    public DrawerItemAdapter(@NonNull List<DrawerItem> drawerItems) {
        this.drawerItems = drawerItems;
    }

    @Override
    public DrawerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.drawer_element, parent, false);
        return new DrawerItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DrawerItemViewHolder holder, int position) {
        holder.setItem(drawerItems.get(position));
    }

    @Override
    public int getItemCount() {
        return drawerItems.size();
    }

    public void addItem(DrawerItem drawerItem) {
        drawerItems.add(drawerItem);
        notifyItemInserted(drawerItems.size() - 1);
    }
}
