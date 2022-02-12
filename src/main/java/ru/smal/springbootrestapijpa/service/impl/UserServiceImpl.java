package ru.smal.springbootrestapijpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
//        Optional<Employee> employee = repository.findById(id);
//        if (employee.isPresent()) {
//            return employee.get();
//        } else {
//            throw new ResourceNotFoundException("Employee", "id", id);
//        }
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public User findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user, Long id) {
        User existingUser = findById(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return repository.save(existingUser);
    }

    @Override
    public void deleteById(Long id) {
        //check whether a employee exist in a DB or not
        findById(id);
        repository.deleteById(id);
    }
}
