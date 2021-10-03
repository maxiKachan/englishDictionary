package com.maximKachan.englishDictionary.repository.jpa;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.repository.WordRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaWordRepository implements WordRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Word> getWords(String pattern) throws DaoException {
        return em.createNamedQuery("Word.findAll").getResultList();
    }

    @Override
    public Word getWordById(Long id) throws DaoException {
        return null;
    }

    @Override
    public void addWord(Word word) throws DaoException {

    }

    @Override
    public void updateWord(Long id, Word word) throws DaoException {

    }

    @Override
    public void deleteWord(Long id) throws DaoException {

    }
}
