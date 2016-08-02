package ru.lionzxy.easystudy.models.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LionZXY on 01.08.2016.
 */
public interface IQuestion extends Serializable{
    List<IAnswer> getAnswers();

}
