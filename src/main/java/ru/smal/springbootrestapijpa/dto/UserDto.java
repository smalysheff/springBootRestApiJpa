package ru.smal.springbootrestapijpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.smal.springbootrestapijpa.persistence.entity.User;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    String login;
    String email;
    List<TodoDto> todos;

    public static UserDto build(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .email(user.getEmail())
                .todos(user.getTodos().stream().map(TodoDto::build).toList())
                .build();
    }

}
