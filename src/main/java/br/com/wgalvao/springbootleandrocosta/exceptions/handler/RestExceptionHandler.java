package br.com.wgalvao.springbootleandrocosta.exceptions.handler;

import java.util.Date;
import java.util.HashMap;

import javax.xml.bind.ValidationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleRestClientResponseExcption(
            RestClientResponseException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleGenericException(
            Exception ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleJsonParseException(
            JsonParseException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> ValidationException(
            ValidationException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> buildResponseEntity(
            Exception ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        ResponseEntity<?> responseEntity = new ResponseEntity<>(status);

        HashMap<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("timestamp", new Date().toString());
        jsonResponse.put("status", responseEntity.getStatusCode().toString());
        jsonResponse.put("message", ex.getMessage());
        jsonResponse.put("path", request.getDescription(false));

        return new ResponseEntity<>(jsonResponse, status);
    }
}
