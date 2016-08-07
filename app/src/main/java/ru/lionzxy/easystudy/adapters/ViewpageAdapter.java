package ru.lionzxy.easystudy.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ru.lionzxy.easystudy.R;
import ru.lionzxy.easystudy.fragments.ThemeListFragment;
import ru.lionzxy.easystudy.models.AdvancedText;
import ru.lionzxy.easystudy.models.Answer;
import ru.lionzxy.easystudy.models.Author;
import ru.lionzxy.easystudy.models.Question;
import ru.lionzxy.easystudy.models.Tag;
import ru.lionzxy.easystudy.models.Theme;
import ru.lionzxy.easystudy.models.interfaces.ITheme;

/**
 * Created by LionZXY on 22.07.2016.
 */
public class ViewpageAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragments = new ArrayList<>();

    public ViewpageAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
        List<ITheme> themes = new ArrayList<>();

        for (String str : context.getResources().getStringArray(R.array.lections_test)) {
            Theme theme = new Theme(str);
            for (String quest : context.getResources().getStringArray(R.array.questions_test)) {
                Question question = new Question(quest);
                Answer answer = new Answer(question, new AdvancedText(context.getResources().getString(R.string.test)));
                answer.setAuthor(new Author(0, "Кирил", "Коноплев"));
                answer.setFavorites(240);
                List<Tag> tags = new ArrayList<>();
                tags.add(new Tag("менеджмент"));
                tags.add(new Tag("очередной бред"));
                answer.setTags(tags);
                for (int i = 0; i < 64; i++) {
                    question.addAnswer(answer);
                }
                theme.addQuestions(question);
            }
            themes.add(theme);
        }

        fragments.add(ThemeListFragment.newInstance(themes));
        fragments.add(ThemeListFragment.newInstance(themes));
    }

    @Override
    public CharSequence getPageTitle(int position) { // Tab text
        if (position == 0) {
            return context.getResources().getString(R.string.lectures);
        }
        if (position == 1) {
            return context.getResources().getString(R.string.questions);
        }
        return getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
