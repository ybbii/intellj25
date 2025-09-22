package com.du.post1.controller;

import com.du.post1.domain.Post;
import com.du.post1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public String list(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "list";
    }

    @GetMapping("/posts/new")
    public String createForm() {
        return "form";
    }

    @PostMapping("/posts")
    public String create(@RequestParam String title, @RequestParam String content, @RequestParam String writer) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setWriter(writer);
        postService.create(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "detail";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "form";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable Long id, @RequestParam String title, @RequestParam String content, @RequestParam String writer) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setWriter(writer);
        postService.update(post);
        return "redirect:/posts/" + id;
    }

}
