package ru.lionzxy.easystudy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.balysv.materialmenu.MaterialMenu;
import com.balysv.materialmenu.MaterialMenuDrawable;

import ru.lionzxy.easystudy.fragments.ToolBarWithTabs;

/**
 * Created by LionZXY on 22.07.2016.
 */
public class ThemeListActivity extends AppCompatActivity implements ToolBarWithTabs.FragmentCallbacks {
    byte actionBarMenuState = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_list);
        Fragment fragment = new ToolBarWithTabs();

        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // Might need to change the status bar color if it is not the theme
            Window w = getWindow();
            if (w.getStatusBarColor() != getResources().getColor(R.color.colorPrimaryDark))
                w.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    public void menuClick(MaterialMenuDrawable materialMenu) {
        switch (actionBarMenuState){
            case 0:{
                actionBarMenuState = 1;
                materialMenu.animateIconState(MaterialMenuDrawable.IconState.ARROW);
                //TODO navigationDrawer.openDrawer();
                break;
            }
            case 1: {
                actionBarMenuState = 0;
                materialMenu.animateIconState(MaterialMenuDrawable.IconState.BURGER);
                //TODO navigationDrawer.closeDrawer();
                break;
            }
        }
    }
}
