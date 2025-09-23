package com.du.post0922.mapper;

import com.du.post0922.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("SELECT * FROM comment WHERE post_id = #{postId} ORDER BY created_at ASC")
    List<Comment> findByPostId(Long postId);

    @Insert("INSERT INTO comment(post_id, writer, content) VALUES (#{postId}, #{writer}, #{content})")
    void insert(Comment comment);
}
