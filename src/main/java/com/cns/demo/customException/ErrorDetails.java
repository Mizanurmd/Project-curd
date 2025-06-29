package com.cns.demo.customException;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
	private String message;
    private String details;
    private LocalDateTime timestamp;

}
