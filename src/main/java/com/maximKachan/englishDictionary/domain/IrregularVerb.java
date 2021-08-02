package com.maximKachan.englishDictionary.domain;

public class IrregularVerb {
    private String word;
    private String[] forms = new String[3];
    private String meaningInRussian;
    private String describe;
    private String using;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String[] getForms() {
        return forms;
    }

    public void setForms(String[] forms) {
        this.forms = forms;
    }

    public String getMeaningInRussian() {
        return meaningInRussian;
    }

    public void setMeaningInRussian(String meaningInRussian) {
        this.meaningInRussian = meaningInRussian;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUsing() {
        return using;
    }

    public void setUsing(String using) {
        this.using = using;
    }
}
