package br.com.softplan.avaliacaoairton.commons.validator;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.internal.engine.path.PathImpl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Classe utilizada para espeficicar um erro de propriedade.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
public class ValidatorError {

    @JsonInclude(Include.NON_NULL)
    private String field;
    private String message;

    // jackson
    ValidatorError() {

    }

    /**
     * Contrutor público para o campo e a mensagem.
     *
     * @param field o campo
     * @param message a mensagem
     */
    public ValidatorError(String field, String message) {

        this.field = field;
        this.message = message;
    }

    public static ValidatorError build(ConstraintViolation<?> cv){


        PathImpl propertyPath = (PathImpl) cv.getPropertyPath();

        ValidatorError error = new ValidatorError( propertyPath.getLeafNode().getName(), cv.getMessage());

        return error;
    }

    public String getField() {

        return field;
    }

    public void setField(String field) {

        this.field = field;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    @Override
    public String toString() {

        return "ValidatorError{"
                + "field='" + field + "'"
                + ", message='" + message + "'"
                + '}';
    }
}
