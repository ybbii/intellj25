package com.du.myproject0924.service;

import com.du.myproject0924.domain.Music;
import com.du.myproject0924.mapper.MusicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicMapper musicMapper; // static을 제거하고 final로 선언

    public List<Music> findAll() {
        return musicMapper.findAll();
    }

    public Music findById(Long id) {
        return musicMapper.findById(id);
    }

    public void create(Music music) {
        musicMapper.insert(music);
    }

    public void update(Music music) {
        musicMapper.update(music);
    }

    public void delete(Long id) {
        musicMapper.delete(id);
    }
}
