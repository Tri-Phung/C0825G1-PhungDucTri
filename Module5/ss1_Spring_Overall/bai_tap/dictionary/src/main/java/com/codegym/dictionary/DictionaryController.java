package com.codegym.dictionary;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
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

    @GetMapping("/")
    public ModelAndView showDictionary(){
        return new ModelAndView("dictionary");
    }
    @PostMapping("/translate")
    public ModelAndView translate(@RequestParam("word") String word){
        ModelAndView modelAndView = new ModelAndView("result");
        String translateWord = word.toLowerCase().trim();
        String meaning = dictionary.get(translateWord);
        modelAndView.addObject("word",word);
        if (meaning != null) {
            modelAndView.addObject("found",true);
            modelAndView.addObject("meaning", meaning);
        }
        else {
            modelAndView.addObject("found",false);
        }
        return modelAndView;
    }
}
