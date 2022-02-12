package ru.smal.springbootrestapijpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smal.springbootrestapijpa.entity.Employee;
import ru.smal.springbootrestapijpa.exeption.ResourceNotFoundException;
import ru.smal.springbootrestapijpa.repository.EmployeeRepository;
import ru.smal.springbootrestapijpa.service.EmployeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Long id) {
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
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(Employee employee, Long id) {
        Employee existingEmployee = findById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        return repository.save(existingEmployee);
    }

    @Override
    public void deleteById(Long id) {
        //check whether a employee exist in a DB or not
        findById(id);
        repository.deleteById(id);
    }
}
