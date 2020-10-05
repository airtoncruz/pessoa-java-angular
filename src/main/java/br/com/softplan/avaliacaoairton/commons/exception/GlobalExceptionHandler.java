package br.com.softplan.avaliacaoairton.commons.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.softplan.avaliacaoairton.commons.i18n.I18nService;
import br.com.softplan.avaliacaoairton.commons.validator.ValidatorResult;

/**
 * Classe responsável por tratar as excptions de um modo global na aplicacao.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private I18nService i18nService;

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> resourceConstraintViolationException(ConstraintViolationException ex) {

        return new ResponseEntity<>(new ValidatorResult(ex.getConstraintViolations()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex) {

        return new ResponseEntity<>(new ValidatorResult(i18nService.i(ex.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DoubleCpfFoundException.class)
    public ResponseEntity<?> doubleCpfFoundException(DoubleCpfFoundException ex) {

        return new ResponseEntity<>(new ValidatorResult(i18nService.i(ex.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
