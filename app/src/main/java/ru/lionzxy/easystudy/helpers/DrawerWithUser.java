package ru.lionzxy.easystudy.helpers;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialmenu.MaterialMenuDrawable;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.fragments.ToolBarWithTabs;

/**
 * Created by LionZXY on 17.08.2016.
 */
public class DrawerWithUser {
    private DrawerLayout drawerLayout;
    private LinearLayout linearLayout;
    private LayoutInflater layoutInflater;

    public DrawerWithUser(Activity activity) {
        drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(activity,
                drawerLayout,
                R.string.test1, R.string.test2);

        linearLayout = (LinearLayout) activity.findViewById(R.id.mainDrawerLL);
        layoutInflater = activity.getLayoutInflater();

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }


    public void addItem(String text, @Nullable View.OnClickListener onClickListener) {
        View item = layoutInflater.inflate(R.layout.drawer_element, null, false);
        ((TextView) item.findViewById(R.id.text)).setText(text);
        linearLayout.addView(item);
    }

    public void addItem(String text) {
        addItem(text, null);
    }

    public void addItem(@StringRes int resourceId, View.OnClickListener onClickListener) {
        addItem(linearLayout.getResources().getString(resourceId), onClickListener);
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
