package com.maximKachan.englishDictionary.domain;

import javax.persistence.*;

@Entity
@Table(name = "sp_words")
@NamedQueries(
        @NamedQuery(name = "Word.findAll", query = "SELECT w FROM Word w")
)
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private Integer wordId;

    @Column(name = "word")
    private String word;
//    private TypeOfWord type;
    @Column(name = "meaning_in_russian")
    private String meaningInRussian;
//    private List<String> opposite;
//    private List<String> synonym;
//    private String describe;
//    private String using;
//    private double usingPercent;

    public Word() {
    }

    public Word(String word){
        this.word = word;
    }

    public Word(String word, String meaningInRussian){
        this.word = word;
        this.meaningInRussian = meaningInRussian;
    }

    public Word(Integer wordId, String word, String meaningInRussian){
        this.wordId = wordId;
        this.word = word;
        this.meaningInRussian = meaningInRussian;
    }

//    public Word(String word, TypeOfWord type, String meaningInRussian) {
//        this.word = word;
//        this.type = type;
//        this.meaningInRussian = meaningInRussian;
//    }


    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

//    public TypeOfWord getType() {
//        return type;
//    }
//
//    public void setType(TypeOfWord type) {
//        this.type = type;
//    }

    public String getMeaningInRussian() {
        return meaningInRussian;
    }

    public void setMeaningInRussian(String meaningInRussian) {
        this.meaningInRussian = meaningInRussian;
    }

//    public List<String> getOpposite() {
//        return opposite;
//    }
//
//    public void setOpposite(List<String> opposite) {
//        this.opposite = opposite;
//    }
//
//    public List<String> getSynonym() {
//        return synonym;
//    }
//
//    public void setSynonym(List<String> synonym) {
//        this.synonym = synonym;
//    }
//
//    public String getDescribe() {
//        return describe;
//    }
//
//    public void setDescribe(String describe) {
//        this.describe = describe;
//    }
//
//    public String getUsing() {
//        return using;
//    }
//
//    public void setUsing(String using) {
//        this.using = using;
//    }
//
//    public double getUsingPercent() {
//        return usingPercent;
//    }
//
//    public void setUsingPercent(double usingPercent) {
//        this.usingPercent = usingPercent;
//    }

    @Override
    public String toString() {
        return "Word{" +
                "id='" + wordId + '\'' +
                "word='" + word + '\'' +
//                ", type=" + type +
                ", meaningInRussian='" + meaningInRussian + '\'' +
//                ", opposite=" + opposite +
//                ", synonym=" + synonym +
//                ", describe='" + describe + '\'' +
//                ", using='" + using + '\'' +
//                ", usingPercent=" + usingPercent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Word that = (Word) o;
        return wordId != 0 && wordId.equals(that.wordId);
    }

    @Override
    public int hashCode() {
        return wordId == null ? 0 : wordId;
    }
}