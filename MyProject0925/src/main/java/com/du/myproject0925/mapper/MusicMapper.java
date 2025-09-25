package com.du.myproject0925.mapper;

import com.du.myproject0925.domain.Music;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MusicMapper {

    @Select("SELECT * FROM music ORDER BY id DESC")
    List<Music> findAll();

    @Select("SELECT * FROM music WHERE id = #{id}")
    Music findById(Long id);

    @Select("SELECT * FROM music WHERE nickname = #{nickname}")
    Music findByNickname(String nickname);

    @Insert("INSERT INTO music(nickname, title, artist) VALUES(#{nickname}, #{title}, #{artist})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Music music);

    @Update("UPDATE music SET nickname = #{nickname}, title = #{title}, artist = #{artist} WHERE id = #{id}")
    void update(Music music);

    @Delete("DELETE FROM music WHERE id = #{id}")
    void delete(Long id);
}
