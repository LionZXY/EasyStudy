package ru.lionzxy.easystudy;

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

import java.util.ArrayList;
import java.util.List;

import cdflynn.android.library.crossview.CrossView;
import ru.lionzxy.easystudy.adapters.AnswerAdapter;
import ru.lionzxy.easystudy.helpers.PixelHelper;
import ru.lionzxy.easystudy.models.AdvancedText;
import ru.lionzxy.easystudy.models.Answer;
import ru.lionzxy.easystudy.models.Author;
import ru.lionzxy.easystudy.models.Question;
import ru.lionzxy.easystudy.models.Tag;
import ru.lionzxy.easystudy.models.interfaces.IAnswer;

/**
 * Created by LionZXY on 28.07.2016.
 */
public class QuestionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        Answer answer = new Answer(new Question(""), new AdvancedText("Менеджмент также — академическая дисциплина, социальная наука, предметом которой является изучение социальной организации. Сегодня вряд ли кто скажет, как и когда зародилось искусство..."));
        answer.setAuthor(new Author(0, "Кирил", "Коноплев"));
        answer.setFavorites(240);
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("менеджмент"));
        tags.add(new Tag("очередной бред"));
        answer.setTags(tags);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewAnswers);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<IAnswer> answers = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            answers.add(answer);
        }
        final View view = findViewById(R.id.question_card);
        final float startY = view.getY() + PixelHelper.pixelFromDP(getResources(),6);

        recyclerView.setAdapter(new AnswerAdapter(answers));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                float newY = (view.getY() - dy);
                if (startY > newY)
                    if (startY - view.getHeight() < newY)
                        view.setY(view.getY() - dy);
                    else view.setY(startY - view.getHeight() - PixelHelper.pixelFromDP(getResources(),6));
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
        questions.setText(Html.fromHtml("<b>" + getResources().getString(R.string.question) + "</b> Понятие и сущность менеджмента"));
    }
}
