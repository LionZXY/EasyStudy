package ru.lionzxy.easystudy.models.interfaces;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LionZXY on 07.08.2016.
 */
public interface ITheme extends Serializable, Parcelable{

    String getTitle();
    List<IQuestion> getQuestions();
}
