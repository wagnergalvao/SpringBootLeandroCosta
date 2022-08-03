package br.com.wgalvao.springbootleandrocosta.exceptions.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleGenericException(
            Exception ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        ResponseEntity<?> responseEntity = new ResponseEntity<>(status);

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(responseEntity.getStatusCodeValue());
        stringBuilder.append(responseEntity.getStatusCode());
        stringBuilder.append(ex.getMessage());
        stringBuilder.append(ex.getCause());
        stringBuilder.append(request.getDescription(false));
        return new ResponseEntity<>(stringBuilder, responseEntity.getStatusCode());
    }
}
