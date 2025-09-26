package com.du.jpa0926.repository;


import com.du.jpa0926.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
