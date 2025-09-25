package com.du.myproject0925.service;

import com.du.myproject0925.domain.Music;
import com.du.myproject0925.mapper.MusicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicMapper musicMapper;

    public List<Music> findAll(){
        return musicMapper.findAll();
    }

    public Music findById(Long id){
        return musicMapper.findById(id);
    }

    public void create(Music music) {
        musicMapper.insert(music);
    }

    public Music findByNickname(String nickname){
        return musicMapper.findByNickname(nickname);
    }

    public void addTrack(Music music, String title, String artist) {
        String newTitle = music.getTitle() + "<br>" + title;
        String newArtist = music.getArtist() + "<br>" + artist;
        music.setTitle(newTitle);
        music.setArtist(newArtist);
        musicMapper.update(music); // 기존 update 사용
    }


    public void update(Music music) {
        musicMapper.update(music);
    }

    public void delete(Long id) {
        musicMapper.delete(id);
    }
}
