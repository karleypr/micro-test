package com.test.micro.adapters.input.rest.errorhandler;

import com.test.micro.adapters.input.rest.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.ParseException;
import java.util.NoSuchElementException;

/**
 * Clase que controla las excepciones que se puedan producir
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Controla las excepciones cuando no se encuentran registros
     *
     * @param ex La excepcion a tratar
     * @return ResponseEntity de ErrorResponseDTO con estado 404
     * y el mensaje de la excepción
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDTO> getPriceByNotFoundException(NoSuchElementException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
                .body(new ErrorResponseDTO().httpCode(HttpStatus.NOT_FOUND.value())
                        .httpMessage(ex.getMessage()));
    }

    /**
     * Controla las excepciones cuando no se puede parsear una fecha de
     * tipo string a tipo Instant
     *
     * @param ex La excepcion a tratar
     * @return ResponseEntity de ErrorResponseDTO con estado 400
     * y el mensaje de la excepción
     */
    @ExceptionHandler(ParseException.class)
    public ResponseEntity<ErrorResponseDTO> parseException(ParseException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body(new ErrorResponseDTO().httpCode(HttpStatus.BAD_REQUEST.value())
                        .httpMessage(ex.getMessage()));
    }
}
