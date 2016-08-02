package ru.lionzxy.easystudy.models;

import ru.lionzxy.easystudy.models.interfaces.IAdvancedText;

/**
 * Text with image and link
 */
public class AdvancedText implements IAdvancedText {
    private String answer;

    public AdvancedText(String answer) {
        this.answer = answer;
    }

    @Override
    public String getText() {
        return this.answer;
    }
}
