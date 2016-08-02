package ru.lionzxy.easystudy.fragments;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.balysv.materialmenu.MaterialMenuDrawable;

import java.util.ArrayList;
import java.util.List;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.SeminarAdapter;
import ru.lionzxy.easystudy.adapters.ViewpageAdapter;
import ru.lionzxy.easystudy.models.Seminar;


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
        v = inflater.inflate(R.layout.theme_tab_fragment, container, false);
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

        //WARNING: HARDCODE
        final TextView[] tabsView = new TextView[2];
        tabsView[0] = ((TextView) v.findViewById(R.id.tab1));
        tabsView[0].setText(viewpagerArrayAdapter.getPageTitle(0));
        tabsView[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        tabsView[1] = ((TextView) v.findViewById(R.id.tab2));
        tabsView[1].setText(viewpagerArrayAdapter.getPageTitle(1));
        tabsView[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) slideLine.getLayoutParams();
                params.setMargins((int) (wight / viewpagerArrayAdapter.getCount() * (positionOffset + position)), 0, 0, 0);
                slideLine.setLayoutParams(params);
                tabsView[position].setAlpha(1 - positionOffset + 0.5F);
                int newPos = position == 1 ? 0 : 1;
                tabsView[newPos].setAlpha(positionOffset + 0.5F);
            }

            @Override
            public void onPageSelected(int position) {
                tabsView[position].setAlpha(1F);
                int newPos = position == 1 ? 0 : 1;
                tabsView[newPos].setAlpha(0.5F);

                if(position == 1){
                    RecyclerView recyclerView = (RecyclerView) viewPager.findViewById(R.id.page2);
                    recyclerView.setLayoutManager(new LinearLayoutManager(viewPager.getContext()));
                    List<Seminar> seminarList = new ArrayList<>();
                    for (int i = 0; i < 100; i++)
                        seminarList.add(new Seminar("Семинар " + i));
                    recyclerView.setAdapter(new SeminarAdapter(seminarList));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    public ViewPager getViewPager(){
        return viewPager;
    }
}
