package ru.lionzxy.easystudy.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ru.lionzxy.easystudy.models.interfaces.IAuthor;

/**
 * Created by LionZXY on 01.08.2016.
 */
public class Author implements IAuthor {
    public static final IAuthor UNKNOWN = new Author(0, "UNKNOWN", null);
    private String name, surname;
    private ImageData avatar;
    private int userid;

    public Author(int userid, @NonNull String name, @Nullable String surname) {
        this.userid = userid;
        this.name = name;
        this.surname = surname;
    }

    public Author setImage(ImageData avatar){
        this.avatar = avatar;
        return this;
    }

    @Override
    @NonNull
    public String getFullName() {
        return name + (surname == null ? "" : " " + surname);
    }

    @Override
    @NonNull
    public String getTitleName() {
        return name + (surname == null ? "" : " " + surname.charAt(0) + '.');
    }

    @Override
    @Nullable
    public String getSurname() {
        return surname;
    }

    @Override
    @NonNull
    public String getName() {
        return name;
    }

    @Override
    @NonNull
    public ImageData getAvatar() {
        return avatar == null ? new ImageData() : avatar;
    }
}
