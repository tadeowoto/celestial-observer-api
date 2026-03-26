package com.celestialobserver.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {


    @GetMapping("/{id}")
    public ResponseEntity<String> getPostByUserId(@PathVariable long id){
         String hello = "hello world";
        return ResponseEntity.ok(hello + id);
    }

}
