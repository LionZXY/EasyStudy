package ru.lionzxy.easystudy.activitys;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.balysv.materialmenu.MaterialMenuDrawable;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.QuestionAdapter;
import ru.lionzxy.easystudy.models.interfaces.ITheme;

/**
 * Created by LionZXY on 28.07.2016.
 */
public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ITheme theme = (ITheme) getIntent().getSerializableExtra("theme");
        if (theme == null)
            finish();
        setContentView(R.layout.question_list_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_tabs);
        MaterialMenuDrawable drawable = new MaterialMenuDrawable(getBaseContext(), Color.WHITE, MaterialMenuDrawable.Stroke.THIN);
        drawable.setIconState(MaterialMenuDrawable.IconState.ARROW);
        toolbar.setNavigationIcon(drawable);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(new QuestionAdapter(theme.getQuestions()));

    }
}
