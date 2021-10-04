package com.maximKachan.englishDictionary.repository.jpa;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.repository.WordRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class JpaWordRepository implements WordRepository {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public List getWords(String pattern) throws DaoException {
        return em.createNamedQuery("Word.findAll").getResultList();
    }

    @Override
    public Word getWordById(Integer id) throws DaoException {
        return em.find(Word.class, id);
    }

    @Override
    @Transactional
    public void addWord(Word word) throws DaoException {
        em.persist(word);
        em.flush();
    }

    @Override
    @Transactional
    public void updateWord(Integer id, Word word) throws DaoException {
        em.merge(word);
    }

    @Override
    @Transactional
    public void deleteWord(Integer id) throws DaoException {
        Word word = em.getReference(Word.class, id);
        em.remove(word);
    }
}
