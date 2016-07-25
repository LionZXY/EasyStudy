package ru.lionzxy.easystudy.fragments;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.balysv.materialmenu.MaterialMenu;
import com.balysv.materialmenu.MaterialMenuDrawable;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.ViewpageAdapter;
import ru.lionzxy.easystudy.helpers.PixelHelper;


/**
 * Created by LionZXY on 22.07.2016.
 */
public class ToolBarWithTabs extends Fragment {
    private FragmentCallbacks mCallbacks;

    public static interface FragmentCallbacks {
        void menuClick(MaterialMenuDrawable materialMenu);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallbacks = (FragmentCallbacks) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Context must implement Fragment Three.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_with_tabs, container, false);
        findViewsById();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window w = getActivity().getWindow();
            w.setStatusBarColor(getResources().getColor(R.color.primary_dark_two));
        }
        return v;
    }

    Toolbar toolbar;
    ViewPager viewPager;
    ViewpageAdapter viewpagerArrayAdapter;
    private MaterialMenuDrawable materialMenu;

    private void findViewsById() {
        toolbar = (Toolbar) v.findViewById(R.id.toolbar_tabs);
        materialMenu = new MaterialMenuDrawable(getActivity(), Color.WHITE, MaterialMenuDrawable.Stroke.THIN);
        toolbar.setNavigationIcon(materialMenu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.menuClick(materialMenu);
            }
        });
        toolbar.inflateMenu(R.menu.activity_bar);

        viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        viewpagerArrayAdapter = new ViewpageAdapter(v.getContext());
        viewPager.setAdapter(viewpagerArrayAdapter);

        final int wight = v.getContext().getResources().getDisplayMetrics().widthPixels;

        //Add horizontal scroll line
        final RelativeLayout relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayoutForSlide);
        final View slideLine = new View(v.getContext());
        slideLine.setLayoutParams(new RelativeLayout.LayoutParams(wight / viewpagerArrayAdapter.getCount(),
                ViewGroup.LayoutParams.MATCH_PARENT));
        slideLine.setBackgroundColor(v.getContext().getResources().getColor(R.color.colorPrimaryLightDark));
        relativeLayout.addView(slideLine);



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) slideLine.getLayoutParams();
                params.setMargins((int) (wight / viewpagerArrayAdapter.getCount() * (positionOffset + position)), 0, 0, 0);
                slideLine.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("onPageScrollStateChange", String.valueOf(state));
            }
        });

        //pagerSlidingTabStrip = (PagerSlidingTabStrip) v.findViewById(R.id.tabs);
        //pagerSlidingTabStrip.setViewPager(viewPager);
        //pagerSlidingTabStrip.setTextColorResource(R.color.white);
        //pagerSlidingTabStrip.setTypeface(Typeface.DEFAULT,R.style.LoginStyle);
        //pagerSlidingTabStrip.setTextSize((int) PixelHelper.pixelFromDP(context.getResources(),16));

    }
}
