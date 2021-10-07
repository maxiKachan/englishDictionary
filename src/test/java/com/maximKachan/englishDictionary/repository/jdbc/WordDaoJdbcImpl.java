package com.maximKachan.englishDictionary.repository.jdbc;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.repository.WordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WordDaoJdbcImpl implements WordRepository {
    private static final Logger log = LoggerFactory.getLogger(WordDaoJdbcImpl.class);

    public static final String GET_WORDS_BY_PATTERN = "SELECT word, meaning_in_russian FROM sp_words WHERE word LIKE ?";
    public static final String ADD_WORD = "INSERT INTO sp_words (word, meaning_in_russian) VALUES (?,?)";
    public static final String UPDATE_WORD = "UPDATE sp_words SET word = ?, meaning_in_russian = ? WHERE word_id = ?";
    public static final String DELETE_WORD = "DELETE FROM sp_words WHERE word_id = ?";

    @Override
    public List<Word> getWords(String pattern) throws DaoException {
        log.info("getWords");
        List<Word> words = new ArrayList<>();

        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(GET_WORDS_BY_PATTERN)){

            stmt.setString(1, "%" + pattern + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Word word = new Word();
                word.setWord(rs.getString("word"));
                word.setMeaningInRussian(rs.getString("meaning_in_russian"));
                words.add(word);
            }

        } catch (SQLException e){
            throw new DaoException(e);
        }

        return words;
    }

    //This method is mock, because this class is example how JDBC works
    @Override
    public Word getWordById(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void addWord(Word word) throws DaoException {
        log.info("addWord");
        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(ADD_WORD)){

            stmt.setString(1, word.getWord());
            stmt.setString(2, word.getMeaningInRussian());

            stmt.executeUpdate();
        } catch (SQLException e){
            throw new DaoException(e);
        }
    }

    @Override
    public void updateWord(Integer id, Word word) throws DaoException {
        log.info("updateWord");
        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(UPDATE_WORD)){

            stmt.setString(1, word.getWord());
            stmt.setString(2, word.getMeaningInRussian());
            stmt.setLong(3, id);

            stmt.executeUpdate();
        } catch (SQLException e){
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteWord(Integer id) throws DaoException {
        log.info("deleteWord");
        try (Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(DELETE_WORD)){

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new DaoException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }
}
