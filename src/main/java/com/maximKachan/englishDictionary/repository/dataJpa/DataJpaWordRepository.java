package com.maximKachan.englishDictionary.repository.dataJpa;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.repository.WordRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaWordRepository implements WordRepository {

    private final ProxyWordRepository proxy;

    public DataJpaWordRepository(ProxyWordRepository proxy) {
        this.proxy = proxy;
    }

    @Override
    public List<Word> getWords(String pattern) throws DaoException {
        return proxy.findAllByWordIsContaining(pattern);
    }

    @Override
    public Word getWordById(Integer wordId) throws DaoException {
        return proxy.findByWordId(wordId);
    }

    @Override
    public void addWord(Word word) throws DaoException {
        proxy.save(word);
    }

    @Override
    public void updateWord(Integer id, Word word) throws DaoException {
        proxy.save(word);
    }

    @Override
    public void deleteWord(Integer id) throws DaoException {
        proxy.deleteByWordId(id);
    }
}
