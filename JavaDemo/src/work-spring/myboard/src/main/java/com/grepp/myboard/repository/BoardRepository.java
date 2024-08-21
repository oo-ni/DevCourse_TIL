package com.grepp.myboard.repository;

import com.grepp.myboard.model.Post;

import java.util.List;

public interface BoardRepository {
    List<Post> getPosts();

    void addPost(Post post);

    Post getPostById(int id);

    void deletePost(int id);

    void updatePost(int id, Post post);
}
