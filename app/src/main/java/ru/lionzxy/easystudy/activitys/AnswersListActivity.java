package ru.lionzxy.easystudy.activitys;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.balysv.materialmenu.MaterialMenuDrawable;

import cdflynn.android.library.crossview.CrossView;
import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.adapters.AnswerAdapter;
import ru.lionzxy.easystudy.helpers.PixelHelper;
import ru.lionzxy.easystudy.models.interfaces.IQuestion;
import ru.lionzxy.easystudy.views.RelativeLayoutWithLine;

/**
 * Created by LionZXY on 07.08.2016.
 */
public class AnswersListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IQuestion question = (IQuestion) getIntent().getSerializableExtra("question");
        if (question == null)
            finish();
        setContentView(R.layout.question_answer_list);

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

        //Test


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewAnswers);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        final View view = findViewById(R.id.question_card);
        final float startY = view.getY() + PixelHelper.pixelFromDP(getResources(), 6);

        recyclerView.setAdapter(new AnswerAdapter(question.getAnswers()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                float newY = (view.getY() - dy);
                if (startY > newY)
                    if (startY - view.getHeight() < newY)
                        view.setY(view.getY() - dy);
                    else
                        view.setY(startY - view.getHeight() - PixelHelper.pixelFromDP(getResources(), 6));
                else view.setY(startY);
            }
        });


        CrossView crossView = (CrossView) findViewById(R.id.cross_view);
        crossView.cross();
        crossView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView questions = (TextView) findViewById(R.id.questions_question);
        questions.setText(Html.fromHtml("<b>" + getResources().getString(R.string.question) + "</b> " + question.getQuestion()));

        ((RelativeLayoutWithLine) findViewById(R.id.relative)).setOnDrowListener(new RelativeLayoutWithLine.OnDrowListener() {
            @Override
            public void onDrow(Canvas canvas) {
                int height = (int) (canvas.getHeight() + PixelHelper.pixelFromDP(getResources(), 20));
                recyclerView.setPadding(0, height, 0, 0);
                ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(0, height);
            }
        });


    }
}
