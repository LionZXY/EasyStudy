package ru.lionzxy.easystudy.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.balysv.materialmenu.MaterialMenuDrawable;

import cdflynn.android.library.crossview.CrossView;
import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.helpers.ViewHolderHelper;
import ru.lionzxy.easystudy.models.interfaces.IAnswer;

/**
 * Created by LionZXY on 07.08.2016.
 */
public class AnswerActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IAnswer answer = (IAnswer) getIntent().getSerializableExtra("answer");
        if (answer == null)
            finish();
        setContentView(R.layout.question_answer_activity);

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

        CardView cardView = (CardView) findViewById(R.id.question_card);
        ViewHolderHelper.setAnswer(cardView, answer);
        ((TextView) findViewById(R.id.question_text)).setMaxLines(Integer.MAX_VALUE);

        TextView questions = (TextView) findViewById(R.id.questions_question);
        questions.setText(Html.fromHtml("<b>" + getResources().getString(R.string.question) + "</b> " + answer.onQuestion().getQuestion()));

        findViewById(R.id.answerCount).setVisibility(View.GONE);

        CrossView crossView = (CrossView) findViewById(R.id.cross_view);
        crossView.cross();
        crossView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getBaseContext(), HideAppActivity.class));
    }
}
