package com.maximKachan.englishDictionary.domain;

import java.util.List;

public class PhrasalVerb {
    private String first_part;
    private String second_part;
    private TypeOfPhrasalVerb type;
    private String meaningInRussian;
    private List<String> opposite;
    private List<String> synonym;
    private String describe;
    private String using;

    public String getFirst_part() {
        return first_part;
    }

    public void setFirst_part(String first_part) {
        this.first_part = first_part;
    }

    public String getSecond_part() {
        return second_part;
    }

    public void setSecond_part(String second_part) {
        this.second_part = second_part;
    }

    public TypeOfPhrasalVerb getType() {
        return type;
    }

    public void setType(TypeOfPhrasalVerb type) {
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
}
