package ru.smal.springbootrestapijpa.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smal.springbootrestapijpa.dto.UserDto;
import ru.smal.springbootrestapijpa.persistence.entity.User;
import ru.smal.springbootrestapijpa.service.UserService;
import ru.smal.springbootrestapijpa.service.impl.UserServiceImpl;

import javax.validation.Valid;
import java.text.MessageFormat;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserDto> getObjectList() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getObjectById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> saveObject(@Valid @RequestBody User user) {
        UserDto save = service.save(user);
        log.info(MessageFormat.format("Save successfully! {0}", user));
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateObject(@PathVariable("id") Long id, @RequestBody User user) {
        return ResponseEntity.ok(service.update(user, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteObject(@PathVariable("id") Long id) {
        Long deleteById = service.deleteById(id);
        return ResponseEntity.ok("Deleted successfully!." + deleteById);
    }
}
