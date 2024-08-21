package com.grepp.myboard.repository;

import com.grepp.myboard.model.Post;

import java.util.ArrayList;
import java.util.List;

public class BoardRepositoryImpl implements BoardRepository {
    private static final List<Post> posts = new ArrayList<>();

    @Override
    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    @Override
    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public Post getPostById(int id) {
        return posts.get(id);
    }

    @Override
    public void deletePost(int id) {
        posts.remove(id);
    }

    @Override
    public void updatePost(int id, Post post) {
        posts.set(id, post);
    }
}
