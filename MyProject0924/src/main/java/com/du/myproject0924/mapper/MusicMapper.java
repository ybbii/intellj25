package com.du.myproject0924.mapper;

import com.du.myproject0924.domain.Music;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MusicMapper {

    @Select("SELECT * FROM music ORDER BY id desc")
    List<Music> findAll();

    @Select("SELECT * FROM music WHERE title = #{title}")
    Music findById(Long title);

    @Insert("INSERT INTO music(id, title, artist, genre) VALUES (#{id}, #{title}, #{artist}, #{genre})")
    void insert(Music music);

    @Update("UPDATE music SET title = #{title}, artist = #{artist}, genre = #{genre} WHERE id = #{id}")
    void update(Music music);

    @Delete("DELETE FROM music WHERE id = #{id}")
    void delete(Long id);

}
