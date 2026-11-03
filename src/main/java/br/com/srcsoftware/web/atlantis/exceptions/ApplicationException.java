package br.com.srcsoftware.web.atlantis.exceptions;

/**
 * Representa os erros de negócio e fluxo da aplicação tratados para o cliente.
 */
public final class ApplicationException extends AbstractException {

    private static final long serialVersionUID = 1L;

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
}