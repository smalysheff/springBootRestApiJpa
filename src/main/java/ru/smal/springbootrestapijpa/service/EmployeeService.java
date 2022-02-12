package ru.smal.springbootrestapijpa.service;

import ru.smal.springbootrestapijpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long id) throws Throwable;
    Employee save(Employee employee);
    Employee update(Employee employee, Long id);
    void deleteById(Long id);

}
