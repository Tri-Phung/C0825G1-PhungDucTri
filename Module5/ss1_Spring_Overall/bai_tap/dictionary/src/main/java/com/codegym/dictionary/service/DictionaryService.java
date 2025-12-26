package com.codegym.dictionary.service;

import com.codegym.dictionary.repository.DictionaryRepository;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
    private DictionaryRepository dictionaryRepository;

    public DictionaryService(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    public String translate(String word){
        return dictionaryRepository.translate(word);
    }
}
