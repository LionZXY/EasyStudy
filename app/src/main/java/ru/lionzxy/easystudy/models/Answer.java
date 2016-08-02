package ru.lionzxy.easystudy.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import ru.lionzxy.easystudy.models.interfaces.IAdvancedText;
import ru.lionzxy.easystudy.models.interfaces.IAnswer;
import ru.lionzxy.easystudy.models.interfaces.IAuthor;
import ru.lionzxy.easystudy.models.interfaces.IQuestion;

/**
 * Created by LionZXY on 01.08.2016.
 */
public class Answer implements IAnswer {
    private IQuestion onQuestion;
    private IAdvancedText advancedText;
    private IAuthor author;
    private List<Tag> tags;
    private int favorites;
    private Time dateCreated;

    public Answer(IQuestion onQuestion,
                  IAdvancedText answer) {
        this.onQuestion = onQuestion;
        this.advancedText = answer;
        this.author = Author.UNKNOWN;
        this.tags = new ArrayList<>();
        this.favorites = 0;
        this.dateCreated = new Time(System.currentTimeMillis());
    }

    public Answer setTime(Time time){
        this.dateCreated = time;
        return this;
    }

    public Answer setAuthor(IAuthor author) {
        this.author = author;
        return this;
    }

    public Answer setTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Answer setFavorites(int favorites) {
        this.favorites = favorites;
        return this;
    }

    @Override
    public IQuestion onQuestion() {
        return onQuestion;
    }

    @Override
    public IAdvancedText getAnswer() {
        return advancedText;
    }

    @Override
    public IAuthor getAuthor() {
        return author;
    }

    @Override
    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public int getFavorites() {
        return favorites;
    }

    @Override
    public Time getDateCreated() {
        return dateCreated;
    }
}
