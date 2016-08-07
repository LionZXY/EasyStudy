package ru.lionzxy.easystudy;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

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
        ToolBarWithTabs fragment = new ToolBarWithTabs().setFragmentManager(getSupportFragmentManager());

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

    @Override
    public void onPageSelected(int position, ViewPager viewPager) {
        //RecyclerView recyclerView;
        //List<ITheme> themes = new ArrayList<ITheme>();
        //switch (position) {
        //    case 1:
        //        recyclerView = (RecyclerView) viewPager.findViewById(R.id.page2);
        //        for (String str : getResources().getStringArray(R.array.lections_test)) {
        //            Theme theme = new Theme(str);
        //            for (String quest : getResources().getStringArray(R.array.questions_test)) {
        //                Question question = new Question(quest);
        //                Answer answer = new Answer(question, new AdvancedText(getResources().getString(R.string.test)));
        //                answer.setAuthor(new Author(0, "Кирил", "Коноплев"));
        //                answer.setFavorites(240);
        //                List<Tag> tags = new ArrayList<>();
        //                tags.add(new Tag("менеджмент"));
        //                tags.add(new Tag("очередной бред"));
        //                answer.setTags(tags);
        //                for (int i = 0; i < 64; i++) {
        //                    question.addAnswer(answer);
        //                }
        //                theme.addQuestions(question);
        //            }
        //            themes.add(theme);
        //        }
//
        //        break;
        //    case 0:
        //        recyclerView = (RecyclerView) viewPager.findViewById(R.id.page1);
        //        for (String str : getResources().getStringArray(R.array.lections_test)) {
        //            Theme theme = new Theme(str);
        //            for (String quest : getResources().getStringArray(R.array.questions_test)) {
        //                Question question = new Question(quest);
        //                Answer answer = new Answer(question, new AdvancedText(getResources().getString(R.string.test)));
        //                answer.setAuthor(new Author(0, "Кирил", "Коноплев"));
        //                answer.setFavorites(240);
        //                List<Tag> tags = new ArrayList<>();
        //                tags.add(new Tag("менеджмент"));
        //                tags.add(new Tag("очередной бред"));
        //                answer.setTags(tags);
        //                for (int i = 0; i < 64; i++) {
        //                    question.addAnswer(answer);
        //                }
        //                theme.addQuestions(question);
        //            }
        //            themes.add(theme);
        //        }
        //        break;
        //    default:
        //        recyclerView = null;
        //}
        //if (recyclerView != null) {
        //    recyclerView.setLayoutManager(new LinearLayoutManager(viewPager.getContext()));
        //    recyclerView.setAdapter(new ThemeAdapter(themes));
        //}
    }
    /*
    Answer answer = new Answer(question, new AdvancedText(getResources().getString(R.string.test)));
        answer.setAuthor(new Author(0, "Кирил", "Коноплев"));
        answer.setFavorites(240);
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("менеджмент"));
        tags.add(new Tag("очередной бред"));
        answer.setTags(tags);
        List<IAnswer> answers = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            answers.add(answer);
        }
     */
}
