package ru.smal.springbootrestapijpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smal.springbootrestapijpa.dto.UserDto;
import ru.smal.springbootrestapijpa.persistence.entity.User;
import ru.smal.springbootrestapijpa.exeption.ResourceNotFoundException;
import ru.smal.springbootrestapijpa.persistence.repository.UserRepository;
import ru.smal.springbootrestapijpa.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<UserDto> findAll() {
        List<User> users = repository.findAll();
        return users.stream().map(UserDto::build).toList();
    }

    @Override
    public UserDto findById(Long id) {
        User user = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));
        return UserDto.build(user);
    }

    @Override
    public UserDto findByFirstName(String firstName) {
        User user = repository.findByFirstName(firstName);
        return UserDto.build(user);
    }

    @Override
    public UserDto save(User user) {
        return UserDto.build(repository.save(user));
    }

    @Override
    public UserDto update(User user, Long id) {
        User existUser = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));
        existUser.setFirstName(user.getFirstName());
        existUser.setLastName(user.getLastName());
        existUser.setLogin(user.getLogin());
        existUser.setPassword(user.getPassword());
        existUser.setEmail(user.getEmail());
        return UserDto.build(repository.save(existUser));
    }

    @Override
    public Long deleteById(Long id) {
        //check whether an employee exist in a DB or not
        repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));
        repository.deleteById(id);
        return id;
    }
}
