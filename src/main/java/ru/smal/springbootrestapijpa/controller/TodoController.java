package ru.smal.springbootrestapijpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smal.springbootrestapijpa.dto.TodoDto;
import ru.smal.springbootrestapijpa.persistence.entity.Todo;
import ru.smal.springbootrestapijpa.service.TodoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoDto> getObjectList() {
        return todoService.findAll();
    }

    @PostMapping
    public ResponseEntity<TodoDto> saveObject(@RequestBody Todo todo,
                           @RequestParam Long userId) {
        TodoDto save = todoService.save(todo, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping
    public ResponseEntity<TodoDto> updateObject(@RequestParam Long id) {
        return ResponseEntity.ok(todoService.update(id));
    }
}
