package ru.smal.springbootrestapijpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.util.CollectionUtils;
import ru.smal.springbootrestapijpa.persistence.entity.User;

import java.time.LocalDateTime;
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
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    List<TodoDto> todos;


    public static UserDto build(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt() != null ? user.getUpdatedAt() : null)
                .todos(CollectionUtils.isEmpty(user.getTodos())
                                ? null
                                : user.getTodos().stream().map(TodoDto::build).toList())
                .build();
    }

}
