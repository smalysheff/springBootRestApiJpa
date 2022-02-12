package ru.smal.springbootrestapijpa.service;

import ru.smal.springbootrestapijpa.dto.UserDto;
import ru.smal.springbootrestapijpa.persistence.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto findByFirstName(String firstName);
    UserDto save(User user);
    UserDto update(User user, Long id);
    Long deleteById(Long id);

}
