package ru.lionzxy.easystudy.activitys;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.bugsnag.android.Bugsnag;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.fragments.ToolBarWithTabs;
import ru.lionzxy.easystudy.helpers.DrawerWithUser;

/**
 * Created by LionZXY on 22.07.2016.
 */
public class ThemeListActivity extends AppCompatActivity implements ToolBarWithTabs.FragmentCallbacks {
    byte actionBarMenuState = 0;
    DrawerWithUser drawerWithUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_list);
        ToolBarWithTabs fragment = new ToolBarWithTabs().setFragmentManager(getSupportFragmentManager());

        Bugsnag.init(this);

        drawerWithUser = new DrawerWithUser(this);
        drawerWithUser.setFragment(fragment);
        drawerWithUser.addItem("Добавить дисциплинну");
        drawerWithUser.addItem("Добавить вопрос");
        drawerWithUser.addItem("Редактировать вопрос");
        drawerWithUser.addItem("Оповещения");
        drawerWithUser.addItem("Настройки");
        drawerWithUser.addItem("Тех.поддержка");
        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // Might need to change the status bar color if it is not the theme
            Window w = getWindow();
            if (w.getStatusBarColor() != getResources().getColor(R.color.colorPrimaryDark))
                w.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }


        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void menuClick(MaterialMenuDrawable materialMenu) {
        switch (actionBarMenuState) {
            case 0: {
                actionBarMenuState = 1;
                materialMenu.animateIconState(MaterialMenuDrawable.IconState.ARROW);
                drawerWithUser.openDrawer();
                break;
            }
            case 1: {
                actionBarMenuState = 0;
                materialMenu.animateIconState(MaterialMenuDrawable.IconState.BURGER);
                new DrawerWithUser(this).openDrawer();
                drawerWithUser.closeDrawer();
                break;
            }
        }
    }

    @Override
    public void onPageSelected(int position, ViewPager viewPager) {

    }


}
