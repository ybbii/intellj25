package com.du.myproject0924.controller;

import com.du.myproject0924.domain.Music;
import com.du.myproject0924.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MusicController {
    private final MusicService musicService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("musics", musicService.findAll());
        return "main";
    }

    @GetMapping("/new")
    public String createForm() {
        return "form";
    }

    @PostMapping("/")
    public String create(@RequestParam String title, @RequestParam String artist, @RequestParam String genre) {
        Music music =  new Music();
        music.setTitle(title);
        music.setArtist(artist);
        music.setGenre(genre);
        musicService.create(music);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        musicService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")  // 수정 페이지로 이동
    public String updateForm(@PathVariable Long id, Model model) {
        Music music = musicService.findById(id);
        model.addAttribute("music", music);
        return "form";  // form.html을 리턴 (수정용 폼)
    }

    @PostMapping("/{id}/edit")  // 수정된 내용을 저장
    public String update(@PathVariable Long id, @RequestParam String title, @RequestParam String artist, @RequestParam String genre) {
        Music music = new Music();
        music.setId(id);
        music.setTitle(title);
        music.setArtist(artist);
        music.setGenre(genre);
        musicService.update(music);  // 음악 수정
        return "redirect:/";  // 목록 페이지로 리다이렉트
    }

    @GetMapping("/{id}")  // 상세 페이지
    public String detail(@PathVariable Long id, Model model) {
        Music music = musicService.findById(id);
        model.addAttribute("music", music);
        return "detail";  // detail.html을 리턴
    }

}
