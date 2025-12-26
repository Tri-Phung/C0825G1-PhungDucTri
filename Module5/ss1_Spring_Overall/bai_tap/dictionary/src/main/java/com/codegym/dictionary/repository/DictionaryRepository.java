package com.codegym.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository {
    private static Map<String, String> dictionary;
    static {
        dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("goodbye", "Tạm biệt");
        dictionary.put("cat", "Con mèo");
        dictionary.put("dog", "Con chó");
        dictionary.put("book", "Quyển sách");
        dictionary.put("computer", "Máy tính");
        dictionary.put("phone", "Điện thoại");
        dictionary.put("water", "Nước");
        dictionary.put("food", "Thức ăn");
        dictionary.put("love", "Tình yêu");
    }
    public String translate(String word) {
        return dictionary.get(word);
    }
}
