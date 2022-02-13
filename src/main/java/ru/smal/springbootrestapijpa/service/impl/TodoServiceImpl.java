package ru.smal.springbootrestapijpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smal.springbootrestapijpa.dto.TodoDto;
import ru.smal.springbootrestapijpa.exeption.ResourceNotFoundException;
import ru.smal.springbootrestapijpa.persistence.entity.Todo;
import ru.smal.springbootrestapijpa.persistence.entity.User;
import ru.smal.springbootrestapijpa.persistence.repository.TodoRepository;
import ru.smal.springbootrestapijpa.persistence.repository.UserRepository;
import ru.smal.springbootrestapijpa.service.TodoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Override
    public List<TodoDto> findAll() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(TodoDto::build).toList();
    }

    @Override
    public TodoDto save(Todo todo, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", userId));
        todo.setUser(user);
        return TodoDto.build(todoRepository.save(todo));
    }

    @Override
    public TodoDto update(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo", "id", id));
        todo.setCompleted(!todo.getCompleted());
        Todo update = todoRepository.save(todo);
        return TodoDto.build(update);
    }
}
