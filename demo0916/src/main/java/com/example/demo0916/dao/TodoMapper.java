package com.example.demo0916.dao;

import com.example.demo0916.model.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todos")
    List<Todo> findAll();

    @Insert("INSERT INTO todos (title) VALUES (#{title})")
    void add(String title);

    @Delete("DELETE FROM todos WEHERE id = #{id}")
    void delete(int id);

    @Update("UPDATE todos SET completed = NOT completed WHERE id = #{id}")
    void toggleCompleted(int id);
}
