package com.celestialobserver.api.service.impl;

import com.celestialobserver.api.entity.Post;
import com.celestialobserver.api.repository.PostRepository;
import com.celestialobserver.api.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {


     private final PostRepository postRepository;


    @Override
    public List<Post> listPostByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public Optional<Post> findByPostId(Long postId) {
        return postRepository.findByPostId(postId);
    }

    @Override
    @SneakyThrows
    public Post updatePost(Long idPost, Post updatedPost) {

        Post post = postRepository.findById(idPost)
                .orElseThrow(() -> new Exception("Post con id " + idPost + " no encontrado"));

        post.setTitle(updatedPost.getTitle());
        post.setCelestialBody(updatedPost.getCelestialBody());
        post.setEquipment(updatedPost.getEquipment());
        post.setAtmosphereCondition(updatedPost.getAtmosphereCondition());
        post.setDescription(updatedPost.getDescription());
        post.setLocation(updatedPost.getLocation());

        return postRepository.save(post);
    }

    @Override
    @SneakyThrows
    public void deletePost(Long idPost) {
        Post post = postRepository.findById(idPost)
                .orElseThrow(() -> new Exception("Post con id " + idPost + " no encontrado"));
        postRepository.deleteById(post.getPostId());
    }

    @Override
    public Post createPost(Post post) {
       return postRepository.save(post);
    }
}
