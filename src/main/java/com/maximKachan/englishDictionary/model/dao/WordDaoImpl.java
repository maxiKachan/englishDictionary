package com.maximKachan.englishDictionary.model.dao;

import com.maximKachan.englishDictionary.domain.TypeOfWord;
import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordDaoImpl implements WordDao{

    public static final String GET_WORDS_BY_PATTERN = "SELECT * FROM ed_common_dictionary_word " +
            "WHERE word LIKE ?";

    public static final String ADD_WORD = "INSERT INTO ed_common_dictionary_word (word, type_of_word, " +
            "meaning_in_russian_word_w) " +
            "VALUES (?, ?, ?)";

    public static final String UPDATE_WORD = "UPDATE ed_common_dictionary_word SET word = ?," +
            " type_of_word = ?, meaning_in_russian_word_w = ? " +
            "WHERE word_id = ?";

    @Override
    public List<Word> getWords(String pattern) throws DaoException {

        List<Word> result = new ArrayList<>(20);

        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(GET_WORDS_BY_PATTERN)){

            stmt.setString(1,"%" + pattern + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Word word = new Word();

                word.setWord(rs.getString("word"));
                word.setType(TypeOfWord.valueOf(rs.getString("type_of_word")));
                word.setMeaningInRussian(rs.getString("meaning_in_russian_word_w"));

                result.add(word);
            }
        } catch (SQLException ex){
            throw new DaoException();
        }
        return result;
    }

    @Override
    public void addWord(Word word) throws DaoException{
        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(ADD_WORD)){

            stmt.setString(1, word.getWord());
            stmt.setString(2, word.getType().toString());
            stmt.setString(3, word.getMeaningInRussian());

            stmt.executeUpdate();
        } catch (SQLException ex){
            throw new DaoException();
        }
    }

    @Override
    public void updateWord(Long id, Word word) throws DaoException {
        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(UPDATE_WORD)){

            stmt.setString(1, word.getWord());
            stmt.setString(2, word.getType().toString());
            stmt.setString(3, word.getMeaningInRussian());
            stmt.setLong(4, id);

            stmt.executeUpdate();
        } catch (SQLException ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public void deleteWord(Long id) throws DaoException{

    }

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }
}
