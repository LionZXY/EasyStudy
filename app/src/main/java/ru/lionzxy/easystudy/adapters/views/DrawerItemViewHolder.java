package ru.lionzxy.easystudy.adapters.views;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.models.DrawerItem;

/**
 * Created by LionZXY on 17.08.2016.
 */
public class DrawerItemViewHolder extends RecyclerView.ViewHolder {
    View itemView;

    public DrawerItemViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public DrawerItemViewHolder setItem(@Nullable DrawerItem drawerItem) {
        TextView textView = (TextView) itemView.findViewById(R.id.text);

        if (drawerItem == null) {
            textView.setText("");
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else {
            textView.setText(drawerItem.getItemName());
            itemView.setOnClickListener(drawerItem.getOnClickListener());
        }

        return this;
    }
}
