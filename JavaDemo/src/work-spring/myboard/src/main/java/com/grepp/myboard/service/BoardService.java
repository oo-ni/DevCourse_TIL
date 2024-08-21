package com.grepp.myboard.service;

import com.grepp.myboard.model.Post;
import com.grepp.myboard.repository.BoardRepository;
import com.grepp.myboard.repository.BoardRepositoryImpl;

import java.util.List;

public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService() {
        this.boardRepository = new BoardRepositoryImpl();
    }

    public List<Post> getAllPosts() {
        return boardRepository.getPosts();
    }

    public void addPost(Post post) {
        boardRepository.addPost(post);
    }

    public Post getPostById(int id) {
        return boardRepository.getPostById(id);
    }

    public void updatePost(int id, Post post) {
        boardRepository.updatePost(id, post);
    }

    public void deletePost(int id) {
        boardRepository.deletePost(id);
    }
}
