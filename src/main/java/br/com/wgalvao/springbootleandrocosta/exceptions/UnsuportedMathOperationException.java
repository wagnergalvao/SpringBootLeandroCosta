package br.com.wgalvao.springbootleandrocosta.exceptions;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {

    public UnsuportedMathOperationException(String message) {
        super(message);
    }

    // private static final long serialVersionUid = 1L;
}
