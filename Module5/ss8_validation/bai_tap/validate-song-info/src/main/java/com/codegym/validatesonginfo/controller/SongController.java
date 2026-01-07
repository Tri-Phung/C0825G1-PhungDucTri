package com.codegym.validatesonginfo.controller;

import com.codegym.validatesonginfo.entity.Song;
import com.codegym.validatesonginfo.service.SongService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    public SongController(SongService songService) {
        this.songService = songService;
    }
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "song/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "song/form";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "song/form";
        }
        songService.save(song);
        return "redirect:/songs";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "song/form";
    }
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "song/form";
        }
        song.setId(id);
        songService.save(song);
        return "redirect:/songs";
    }
}
