package com.maximKachan.englishDictionary.repository.dataJpa;

import com.maximKachan.englishDictionary.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProxyWordRepository extends JpaRepository<Word, Integer> {

    List<Word> findAllByWordIsContaining(String str);

    Word findByWordId(Integer wordId);

    @Override
    @Transactional
    <S extends Word> S save(S entity);

    @Transactional
    void deleteByWordId(Integer wordId);
}
