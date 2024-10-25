package com.grepp.todo.model.service

import com.grepp.todo.model.entity.TodoEntity
import com.grepp.todo.model.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(val repo: TodoRepository) {   // 의존하는 객체 생성자 주입 권장
    fun create(todo: TodoEntity) = repo.save(todo)
    fun getList(username: String) = repo.findByUsername(username)
}