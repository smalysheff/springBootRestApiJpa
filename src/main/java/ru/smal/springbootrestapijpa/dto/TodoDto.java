package ru.smal.springbootrestapijpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.smal.springbootrestapijpa.persistence.entity.Todo;

import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TodoDto build(Todo todo) {
        if (todo == null) {
            return null;
        }
        return TodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdateAt() != null ? todo.getUpdateAt() : null)
                .build();
    }
}
