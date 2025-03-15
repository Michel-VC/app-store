package com.mx.appstore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase para el manejo global de errores/excepciones generales.
 *
 * @author Michel Velázquez
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalErrorHandler {

    // Crear un logger estático para esta clase
    private static final Logger logger = LoggerFactory.getLogger(GlobalErrorHandler.class);

    /**
     * Maneja todas las excepciones y devuelve un objeto ErrorDetails en formato JSON.
     *
     * @param ex La excepción ocurrida.
     * @return Un objeto ErrorDetails con información detallada sobre el error.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDetails handleException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return new ErrorDetails("Error detectado",
                ex.getMessage(),
                System.currentTimeMillis());
    }

    // Clase interna para representar el detalle del error de forma genérica
    public static class ErrorDetails {
        private String error;
        private String message;
        private long timestamp;

        public ErrorDetails(String error, String message, long timestamp) {
            this.error = error;
            this.message = message;
            this.timestamp = timestamp;
        }

        // Getters y setters
        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }
}
