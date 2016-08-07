package ru.lionzxy.easystudy.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.ThemeAdapter;
import ru.lionzxy.easystudy.models.interfaces.ITheme;

/**
 * Created by LionZXY on 07.08.2016.
 */
public class ThemeListFragment extends Fragment {
    private List<ITheme> themes = null;

    public static ThemeListFragment newInstance(List<ITheme> themes) {
        ThemeListFragment themeListFragment = new ThemeListFragment();

        Bundle args = new Bundle();
        args.putParcelableArrayList("themes", new ArrayList<Parcelable>(themes));
        themeListFragment.setArguments(args);

        return themeListFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themes = getArguments().getParcelableArrayList("themes");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragments_themepage, container, false).findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ThemeAdapter(themes));
        return recyclerView;
    }
}
