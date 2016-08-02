package ru.lionzxy.easystudy.models.interfaces;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import ru.lionzxy.easystudy.models.Tag;

/**
 * Created by LionZXY on 01.08.2016.
 */
public interface IAnswer extends Serializable{

    IQuestion onQuestion();
    IAdvancedText getAnswer();
    IAuthor getAuthor();
    List<Tag> getTags();
    int getFavorites();
    Time getDateCreated();

}
