package ru.smal.springbootrestapijpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.smal.springbootrestapijpa.persistence.entity.Todo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoDto {
    private Long id;
    private String title;
    private Boolean completed;

    public static TodoDto build(Todo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }
}
