package com.maximKachan.englishDictionary.domain;

import java.util.List;

public class Word {
    private String word;
    private TypeOfWord type;
    private String meaningInRussian;
    private List<String> opposite;
    private List<String> synonym;
    private String describe;
    private String using;
    private double usingPercent;

    public Word() {
    }

    public Word(String word){
        this.word = word;
    }

    public Word(String word, TypeOfWord type, String meaningInRussian) {
        this.word = word;
        this.type = type;
        this.meaningInRussian = meaningInRussian;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public TypeOfWord getType() {
        return type;
    }

    public void setType(TypeOfWord type) {
        this.type = type;
    }

    public String getMeaningInRussian() {
        return meaningInRussian;
    }

    public void setMeaningInRussian(String meaningInRussian) {
        this.meaningInRussian = meaningInRussian;
    }

    public List<String> getOpposite() {
        return opposite;
    }

    public void setOpposite(List<String> opposite) {
        this.opposite = opposite;
    }

    public List<String> getSynonym() {
        return synonym;
    }

    public void setSynonym(List<String> synonym) {
        this.synonym = synonym;
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

    public double getUsingPercent() {
        return usingPercent;
    }

    public void setUsingPercent(double usingPercent) {
        this.usingPercent = usingPercent;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", type=" + type +
                ", meaningInRussian='" + meaningInRussian + '\'' +
                ", opposite=" + opposite +
                ", synonym=" + synonym +
                ", describe='" + describe + '\'' +
                ", using='" + using + '\'' +
                ", usingPercent=" + usingPercent +
                '}';
    }
}