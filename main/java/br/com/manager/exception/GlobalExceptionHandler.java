package br.com.manager.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(SQLIntegrityConstraintViolationException ex) {
        String errorMessage = "Dados duplicados encontrados. Por favor, verifique se o item já foi registrado.";
        String errorCode = "DATA_DUPLICATE";

        if (ex.getMessage().contains("Duplicate entry")) {
            if (ex.getMessage().contains("users.email")) {
                errorMessage = "Este email já está registrado. Por favor, forneça um email diferente.";
            } else if (ex.getMessage().contains("users.phone")) {
                errorMessage = "Este telefone já está registrado. Por favor, forneça um telefone diferente.";
            } else if (ex.getMessage().contains("users.cpf")) {
                errorMessage = "Este CPF já está registrado. Por favor, forneça um CPF diferente.";
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("message", errorMessage);
        response.put("errorCode", errorCode);
        response.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(MethodArgumentNotValidException ex) {
        String errorMessage = "Campos obrigatórios não preenchidos corretamente.";
        String errorCode = "VALIDATION_ERROR";

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("message", errorMessage);
        response.put("errorCode", errorCode);
        response.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException ex) {
        String errorMessage = ex.getMessage();
        String errorCode = "ENTITY_NOT_FOUND";

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("message", errorMessage);
        response.put("errorCode", errorCode);
        response.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}