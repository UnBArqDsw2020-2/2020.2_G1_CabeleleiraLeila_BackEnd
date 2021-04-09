package br.unb.leilas.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(Exception e) {

        CustomErrorResponse error = new CustomErrorResponse();
        error.setError(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

}
