package ru.smal.springbootrestapijpa.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smal.springbootrestapijpa.entity.Employee;
import ru.smal.springbootrestapijpa.service.impl.EmployeeServiceImpl;

import java.text.MessageFormat;
import java.util.List;

@Slf4j
@RestController //@Controller + @ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeServiceImpl service;

    @GetMapping
    public List<Employee> getEmployeeList() {
        return service.findAll();
    }

    /**
     * body
     * {
     * "firstName": "Ivan",
     * "lastName": "Ivanov",
     * "email": "mail@mail.ru"
     * }
     */
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee save = service.save(employee);
        log.info(MessageFormat.format("Initial save {0} in database", save));
        log.info(MessageFormat.format("Save success", employee));
        return new ResponseEntity<Employee>(save, HttpStatus.CREATED);
    }

    /** localhost:8080/api/employees/1 */
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * 1) requestBody
     *  {
     *     "firstName": "Ivan",
     *     "lastName": "Ivanov",
     *     "email": "mail@mail.ru"
     *  }
     *
     * 2) localhost:8080/api/employees/1
     */
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
                                                   @RequestBody Employee employee) {
        return ResponseEntity.ok(service.update(employee, id));
    }

    /** localhost:8081/api/employee/1 */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }

    /**
     * Добавить объект через RequestParam
     */
    @PutMapping(path = "/employee")
    public ResponseEntity<Employee> putEmployeeRequestParam(@RequestParam() String firstName,
                                                            @RequestParam String lastName) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        service.save(employee);
        log.info("Save success");
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
}
