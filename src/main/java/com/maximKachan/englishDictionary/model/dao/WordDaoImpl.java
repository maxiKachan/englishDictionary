package com.maximKachan.englishDictionary.model.dao;

import com.maximKachan.englishDictionary.domain.TypeOfWord;
import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordDaoImpl implements WordDao{

    public static void main(String[] args) throws DaoException {

        List<Word> words;

        Word word;
        WordDaoImpl wordDao = new WordDaoImpl();
        words = wordDao.getWordsByPattern("ag");

//        System.out.println(word);
        words.forEach(System.out::println);
    }

    public static final String GET_ALL_WORDS = "SELECT * FROM ed_common_dictionary_word";

    public static final String GET_WORD_BY_NAME = "SELECT * FROM ed_common_dictionary_word " +
            "WHERE word = ?";

    public static final String GET_WORDS_BY_PATTERN = "SELECT * FROM ed_common_dictionary_word " +
            "WHERE word LIKE ?";

    @Override
    public List<Word> getWords() throws DaoException {

        List<Word> result = new LinkedList<>();

        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(GET_ALL_WORDS)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Word word = new Word();

                word.setWord(rs.getString("word"));
                word.setType(TypeOfWord.valueOf(rs.getString("type_of_word")));
                word.setMeaningInRussian(rs.getString("meaning_in_russian_word_w"));

                result.add(word);
            }
        } catch (SQLException ex){
            throw new DaoException(ex);
        }

        return result;
    }

    @Override
    public List<Word> getWordsByPattern(String pattern) throws DaoException {

        List<Word> result = new ArrayList<>(20);

        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(GET_WORDS_BY_PATTERN)){

            stmt.setString(1,"%" + pattern + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Word word = new Word();

                word.setWord(rs.getString("word"));
                word.setType(TypeOfWord.valueOf(rs.getString("type_of_word")));
                word.setMeaningInRussian("meaning_in_russian_word_w");

                result.add(word);
            }
        } catch (SQLException ex){
            throw new DaoException();
        }
        return result;
    }

    @Override
    public Word getWordByName(String name) throws DaoException {

        Word word = new Word();

        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(GET_WORD_BY_NAME)){

            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                word.setWord(rs.getString("word"));
                word.setType(TypeOfWord.valueOf(rs.getString("type_of_word")));
                word.setMeaningInRussian(rs.getString("meaning_in_russian_word_w"));
            }
        } catch (SQLException ex){
            throw new DaoException(ex);
        }

        return word;
    }

    @Override
    public void addWord(Long id) {

    }

    @Override
    public void updateWord(Long id) {

    }

    @Override
    public void deleteWord(Long id) {

    }

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }
}
