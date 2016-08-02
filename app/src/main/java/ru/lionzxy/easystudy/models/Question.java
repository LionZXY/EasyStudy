package ru.lionzxy.easystudy.models;

import java.util.ArrayList;
import java.util.List;

import ru.lionzxy.easystudy.models.interfaces.IAnswer;
import ru.lionzxy.easystudy.models.interfaces.IQuestion;

/**
 * Created by LionZXY on 01.08.2016.
 */
public class Question implements IQuestion {
    private List<IAnswer> answers = new ArrayList<>();

    private String question;

    public Question(String question) {
        this.question = question;
    }

    public void addAnswers(IAnswer... answer) {
        for (IAnswer ans : answer)
            addAnswer(ans);
    }

    public void addAnswer(IAnswer answer) {
        this.answers.add(answer);
    }

    @Override
    public List<IAnswer> getAnswers() {
        return null;
    }
}
