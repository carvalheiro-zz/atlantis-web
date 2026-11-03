package br.com.srcsoftware.web.atlantis.exceptions;

/**
 * Classe responsável por representar a base abstrata das exceções de negócio e aplicação do sistema.
 */
public abstract class AbstractException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected AbstractException(String message) {
        super(message);
    }

    protected AbstractException(String message, Throwable cause) {
        super(message, cause);
    }

    protected AbstractException(Throwable cause) {
        super(cause);
    }
}