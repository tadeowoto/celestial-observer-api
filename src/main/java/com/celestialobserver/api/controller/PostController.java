package com.celestialobserver.api.controller;

import com.celestialobserver.api.entity.Post;
import com.celestialobserver.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody Post p){
        Post newPost = postService.createPost(p);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Post>> getPostByUserId(@PathVariable long id){
        List<Post> posts = postService.listPostByUserId(id);

        return ResponseEntity.ok(posts);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        Optional<Post> post = postService.findByPostId(id);

        if (post.isPresent()) {
            postService.deletePost(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: El post con ID " + id + " no existe.");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody Post newPost) {
        try {
            Post updated = postService.updatePost(id, newPost);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
