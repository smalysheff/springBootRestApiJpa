package ru.smal.springbootrestapijpa.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.smal.springbootrestapijpa.persistence.entity.Todo;
import ru.smal.springbootrestapijpa.persistence.entity.User;
import ru.smal.springbootrestapijpa.persistence.repository.TodoRepository;
import ru.smal.springbootrestapijpa.persistence.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoServiceImplTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAll() {
    }

    @Test
    void save() {
        User user = userRepository.getById(1L);
        Todo todo = new Todo();
        todo.setUser(user);
        todo.setTitle("Test title");
        todo.setCompleted(false);
        Todo save = todoRepository.save(todo);
        assertNotNull(save);

    }

    @Test
    void update() {
    }
}