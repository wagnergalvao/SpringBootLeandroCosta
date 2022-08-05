package br.com.wgalvao.springbootleandrocosta.exceptions.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleHttpStatusCodeException(
            Exception ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleHttpClientErrorException(
            HttpClientErrorException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleHttpMediaTypeException(
            HttpMediaTypeException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptableException(
            HttpMediaTypeNotAcceptableException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleHttpMediaTypeNotSupportedException(
            HttpMediaTypeNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleHttpMessageConversionException(
            HttpMessageConversionException ex,
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

    protected ResponseEntity<Object> handleHttpMessageNotWritableException(
            HttpMessageNotWritableException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleHttpServerErrorExceptionException(
            HttpServerErrorException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return buildResponseEntity(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleHttpStatusCodeException(
            HttpStatusCodeException ex,
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

        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        return new ResponseEntity<>(servletWebRequest.getNativeRequest(), status);
    }

}
