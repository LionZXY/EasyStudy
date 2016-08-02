package ru.lionzxy.easystudy.models.interfaces;

import java.io.Serializable;

import ru.lionzxy.easystudy.models.ImageData;

/**
 * Created by LionZXY on 01.08.2016.
 */
public interface IAuthor extends Serializable{

    String getFullName();
    String getTitleName();
    String getSurname();
    String getName();
    ImageData getAvatar();

}
