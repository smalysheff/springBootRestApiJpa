package ru.smal.springbootrestapijpa.service;

import ru.smal.springbootrestapijpa.persistence.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User findByFirstName(String firstName);
    User save(User user);
    User update(User user, Long id);
    void deleteById(Long id);

}
