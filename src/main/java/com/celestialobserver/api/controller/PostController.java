package com.celestialobserver.api.controller;

import com.celestialobserver.api.entity.Post;
import com.celestialobserver.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

     private final PostService postService;



    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable long id){
        return ResponseEntity.ok(postService.findByPostId(id));
    }



    @GetMapping("/user/{id}")
    public ResponseEntity<List<Post>> getPostByUserId(@PathVariable long id){
        List<Post> posts = postService.listPostByUserId(id);

        return ResponseEntity.ok(posts);
    }


}
