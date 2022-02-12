package ru.smal.springbootrestapijpa.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smal.springbootrestapijpa.dto.UserDto;
import ru.smal.springbootrestapijpa.persistence.entity.User;
import ru.smal.springbootrestapijpa.service.impl.UserServiceImpl;

import java.text.MessageFormat;
import java.util.List;

@Slf4j
@RestController //@Controller + @ResponseBody
@RequiredArgsConstructor
@RequestMapping("/employees")
public class UserController {

    private final UserServiceImpl service;

    @GetMapping
    public List<UserDto> getEmployeeList() {
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
    public ResponseEntity<UserDto> saveEmployee(@RequestBody User user) {
        UserDto save = service.save(user);
        log.info(MessageFormat.format("Save successfully! {0}", user));
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    /** localhost:8080/api/employees/1 */
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("search")
    public ResponseEntity<UserDto> getEmployeeByFirstName(@RequestParam String firstName) {
        return ResponseEntity.ok(service.findByFirstName(firstName));
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
    public ResponseEntity<UserDto> updateEmployee(@PathVariable("id") Long id,
                                               @RequestBody User user) {
        return ResponseEntity.ok(service.update(user, id));
    }

    /** localhost:8081/api/employee/1 */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        Long deleteById = service.deleteById(id);
        return ResponseEntity.ok("Deleted successfully!." + deleteById);
    }

    /**
     * Добавить объект через RequestParam
     */
    @PutMapping(path = "/employee")
    public ResponseEntity<User> putEmployeeRequestParam(@RequestParam String firstName,
                                                        @RequestParam String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        service.save(user);
        log.info("Save success");
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
