package com.du.myproject0925.controller;

import com.du.myproject0925.domain.Music;
import com.du.myproject0925.service.MusicService;
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

    @GetMapping("/musics")
    public String findAll(Model model){
        model.addAttribute("musics",musicService.findAll());
        return "main";
    }

    @GetMapping("musics/{id}")
    public String findById(@PathVariable Long id, Model model){
        Music music = musicService.findById(id);
        model.addAttribute("music",music);
        return "detail";
    }

    @GetMapping("/musics/new")
    public String createForm(Model model) {
        return "form";
    }

    @PostMapping("/musics")
    public String create(@RequestParam String nickname, @RequestParam String title, @RequestParam String artist) {
        Music existing = musicService.findByNickname(nickname);
        if (existing != null) {
            // 기존 닉네임이 있으면 곡 추가
            musicService.addTrack(existing, title, artist);
        } else {
            // 새 플레이리스트 생성
            Music music = new Music();
            music.setNickname(nickname);
            music.setTitle(title);
            music.setArtist(artist);
            musicService.create(music);
        }

        return "redirect:/musics";
    }

    @GetMapping("/musics/{id}/edit")
    public String editForm(@PathVariable Long id, Model model){
        Music music = musicService.findById(id);
        model.addAttribute("music",music);
        return "form";
    }

    @PostMapping("/musics/{id}/edit")
    public String update(@PathVariable Long id, @RequestParam String nickname, @RequestParam String title, @RequestParam String artist) {
        Music music = new Music();
        music.setId(id);
        music.setNickname(nickname);
        music.setTitle(title);
        music.setArtist(artist);
        musicService.update(music);
        return "redirect:/musics/" + id;
    }


    @PostMapping("/musics/{id}/delete")
    public String delete(@PathVariable Long id){
        musicService.delete(id);
        return "redirect:/musics";
    }
}
