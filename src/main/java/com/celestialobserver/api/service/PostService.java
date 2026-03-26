package com.celestialobserver.api.service;


import com.celestialobserver.api.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> listPostByUserId(Long userId);

    Optional<Post> findByPostId(Long postId);

    Post updatePost(Long idPost, Post updatedPost);

    void deletePost(Long idPost);

    Post createPost(Post post);

}
