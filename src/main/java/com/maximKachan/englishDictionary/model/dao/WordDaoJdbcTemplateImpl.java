package com.maximKachan.englishDictionary.model.dao;


import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordDaoJdbcTemplateImpl implements WordDao{

    private static final Logger log = LoggerFactory.getLogger(WordDaoJdbcTemplateImpl.class);

    private static final BeanPropertyRowMapper<Word> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Word.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public WordDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Word> getWords(String pattern) throws DaoException {
        log.info("getWords");
        return null;
    }

    @Override
    public void addWord(Word word) throws DaoException {
        log.info("addWord");
    }

    @Override
    public void updateWord(Long id, Word word) throws DaoException {
        log.info("updateWord");
    }

    @Override
    public void deleteWord(Long id) throws DaoException {
        log.info("deleteWord");
    }
}
