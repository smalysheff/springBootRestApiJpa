package ru.smal.springbootrestapijpa.service;

import org.springframework.stereotype.Service;
import ru.smal.springbootrestapijpa.dto.TodoDto;
import ru.smal.springbootrestapijpa.persistence.entity.Todo;

import java.util.List;

@Service
public interface TodoService {
    List<TodoDto> findAll();
    TodoDto save(Todo todo, Long userId);

    TodoDto update(Long id);
}
