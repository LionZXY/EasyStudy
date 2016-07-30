package ru.lionzxy.easystudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import cdflynn.android.library.crossview.CrossView;

/**
 * Created by LionZXY on 28.07.2016.
 */
public class QuestionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_answer_list);

        CrossView crossView = (CrossView) findViewById(R.id.cross_view);
        crossView.cross();
        crossView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView questions = (TextView) findViewById(R.id.questions_question);
        questions.setText(Html.fromHtml("<b>" + getResources().getString(R.string.question) + "</b> Понятие и сущность менеджмента"));
    }
}
