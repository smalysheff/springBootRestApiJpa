package ru.smal.springbootrestapijpa.exeption;

import lombok.Data;
import lombok.Value;

import java.util.Date;

@Value
public class ErrorDetail {
    private Date timestamp;
    private String message;
    private String details;
}
