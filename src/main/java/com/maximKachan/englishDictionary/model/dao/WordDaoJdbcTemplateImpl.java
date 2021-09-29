package com.maximKachan.englishDictionary.model.dao;


import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordDaoJdbcTemplateImpl implements WordDao{

    private static final Logger log = LoggerFactory.getLogger(WordDaoJdbcTemplateImpl.class);

    private static final BeanPropertyRowMapper<Word> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Word.class);

    private final JdbcTemplate jdbcTemplate;

    public WordDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Word> getWords(String pattern) throws DaoException {
        log.info("getWords");
        return jdbcTemplate.query("SELECT * FROM sp_words WHERE word LIKE ?", ROW_MAPPER,
                "%" + pattern + "%");
    }

    @Override
    public Word getWordById(Long id) throws DaoException {
        log.info("get word by id dao");

        return jdbcTemplate.query("SELECT word_id, word, meaning_in_russian FROM sp_words WHERE word_id = ?",
                ROW_MAPPER, id).stream().findAny().orElse(null);
    }

    @Override
    public void addWord(Word word) throws DaoException {
        log.info("addWord");
        jdbcTemplate.update("INSERT INTO sp_words (word, meaning_in_russian) VALUES (?,?)",
                word.getWord(), word.getMeaningInRussian());
    }

    @Override
    public void updateWord(Long id, Word word) throws DaoException {
        log.info("updateWord");
        jdbcTemplate.update("UPDATE sp_words SET word = ?, meaning_in_russian = ? WHERE word_id = ?",
                word.getWord(), word.getMeaningInRussian(), id);
    }

    @Override
    public void deleteWord(Long id) throws DaoException {
        log.info("deleteWord");
        jdbcTemplate.update("DELETE FROM sp_words WHERE word_id = ?", id);
    }
}
