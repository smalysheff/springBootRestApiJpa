package ru.smal.springbootrestapijpa.exeption;

import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Value
public class ErrorDetail {
    private Date timestamp;
    private String message;
    private String details;
}
