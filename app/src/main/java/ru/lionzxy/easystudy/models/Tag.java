package ru.lionzxy.easystudy.models;

import java.io.Serializable;

/**
 * Created by LionZXY on 01.08.2016.
 */
public class Tag implements Serializable{
    private String tag;

    public Tag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return this.tag;
    }
}
