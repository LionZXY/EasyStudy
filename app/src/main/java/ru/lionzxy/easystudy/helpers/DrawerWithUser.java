package ru.lionzxy.easystudy.helpers;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.balysv.materialmenu.MaterialMenuDrawable;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.DrawerItemAdapter;
import ru.lionzxy.easystudy.fragments.ToolBarWithTabs;
import ru.lionzxy.easystudy.models.DrawerItem;

/**
 * Created by LionZXY on 17.08.2016.
 */
public class DrawerWithUser {
    private DrawerLayout drawerLayout;
    private DrawerItemAdapter drawerItemAdapter;

    public DrawerWithUser(Activity activity) {
        drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(activity,
                drawerLayout,
                R.string.test1, R.string.test2);

        RecyclerView recyclerView = (RecyclerView) drawerLayout.findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        drawerItemAdapter = new DrawerItemAdapter(new ArrayList<DrawerItem>());
        recyclerView.setAdapter(drawerItemAdapter);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

    }

    public void addItem(DrawerItem drawerItem) {
        drawerItemAdapter.addItem(drawerItem);
    }

    public void addItem(String text, View.OnClickListener onClickListener) {
        drawerItemAdapter.addItem(new DrawerItem(text).setOnClickListener(onClickListener));
    }

    public void addItem(String text) {
        drawerItemAdapter.addItem(new DrawerItem(text));
    }

    public void addItem(@StringRes int resourceId, View.OnClickListener onClickListener) {
        drawerItemAdapter.addItem(new DrawerItem(drawerLayout.getContext().getString(resourceId)).setOnClickListener(onClickListener));
    }

    public void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    public void setFragment(final ToolBarWithTabs toolBarWithTabs) {
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                toolBarWithTabs.getMaterialMenu().setTransformationOffset(MaterialMenuDrawable.AnimationState.BURGER_ARROW, slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
    }
}
