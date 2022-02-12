package ru.smal.springbootrestapijpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.smal.springbootrestapijpa.persistence.entity.User;

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

    public static UserDto build(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setLogin(user.getLogin());
        dto.setEmail(user.getEmail());
        return dto;
    }

}
