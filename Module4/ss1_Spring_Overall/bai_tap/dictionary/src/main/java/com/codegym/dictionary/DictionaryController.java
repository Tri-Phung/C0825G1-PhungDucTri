package com.codegym.dictionary;


import com.codegym.dictionary.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/")
    public ModelAndView showDictionary(){
        return new ModelAndView("dictionary");
    }
    @PostMapping("/translate")
    public ModelAndView translate(@RequestParam("word") String word){
        ModelAndView modelAndView = new ModelAndView("result");
        String translateWord = word.toLowerCase().trim();
        String meaning = dictionaryService.translate(translateWord);
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
