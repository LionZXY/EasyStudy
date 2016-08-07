package ru.lionzxy.easystudy.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import ru.lionzxy.easystudy.models.interfaces.IQuestion;
import ru.lionzxy.easystudy.models.interfaces.ITheme;

/**
 * Created by LionZXY on 07.08.2016.
 */
public class Theme implements ITheme {
    private String title;
    private List<IQuestion> questions = new ArrayList<>();

    public Theme(String title) {
        this.title = title;
    }

    public void addQuestions(IQuestion... question) {
        for (IQuestion ques : question)
            addQuestion(ques);
    }

    public void addQuestion(IQuestion question) {
        this.questions.add(question);
    }

    @Override
    public List<IQuestion> getQuestions() {
        return questions;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Theme> CREATOR = new Parcelable.Creator<Theme>(){
        @Override
        public Theme createFromParcel(Parcel source) {
            return (Theme) source.readSerializable();
        }

        @Override
        public Theme[] newArray(int size) {
            return new Theme[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this);
    }
}
