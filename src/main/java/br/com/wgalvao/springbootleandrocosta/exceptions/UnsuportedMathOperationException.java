package br.com.wgalvao.springbootleandrocosta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {

    public UnsuportedMathOperationException(String message) {
        super(message);
    }

    // private static final long serialVersionUid = 1L;
}
