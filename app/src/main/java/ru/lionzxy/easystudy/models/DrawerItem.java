package ru.lionzxy.easystudy.models;

import android.view.View;

/**
 * Created by LionZXY on 17.08.2016.
 */
public class DrawerItem {
    private String itemName;
    private View.OnClickListener onClickListener;

    public DrawerItem(String itemName) {
        this.itemName = itemName;
    }

    public DrawerItem setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }
}
