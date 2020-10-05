package br.com.softplan.avaliacaoairton.commons.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * Classe responsável por devolver os erros de propriedade alinhados.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
public class ValidatorResult {

    private List<ValidatorError> errors = new ArrayList<>();
    private String message = "Inconsistent data";

    public ValidatorResult(List<ValidatorError> errors, String message) {

        this(errors);
        this.message = message;
    }

    public ValidatorResult(List<ValidatorError> errors) {

        this.errors = errors;
    }

    public ValidatorResult(Set<? extends ConstraintViolation<?>> violations) {
        violations.stream().forEach(cv ->
            errors.add(ValidatorError.build(cv))
        );
    }

    public ValidatorResult(String message) {

        this.message = message;
    }

    public ValidatorResult() {

    }

    @Override
    public String toString() {

        return "ValidatorResult{"
                + "errors=" + errors
                + ", message='" + message + '\''
                + '}';
    }

    public List<ValidatorError> getErrors() {

        return errors;
    }

    public void setErrors(List<ValidatorError> errors) {

        this.errors = errors;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

}
