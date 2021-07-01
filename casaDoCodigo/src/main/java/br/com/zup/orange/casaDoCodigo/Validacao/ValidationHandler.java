package br.com.zup.orange.casaDoCodigo.Validacao;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ValidationHandler {

	    @Autowired
	    private MessageSource messageSource;
	  

	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ValidationErrorsOutputDto ExceptionCampoUnico(MethodArgumentNotValidException exception) {

	        List<ObjectError> erros = exception.getBindingResult().getGlobalErrors();
	        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
 
	        ValidationErrorsOutputDto va = new ValidationErrorsOutputDto(messageSource);
	        
	        return va.buildValidationErrors(erros, fieldErrors);
	    }

	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(IllegalStateException.class)
	    public ValidationErrorsOutputDto argsInvalids(IllegalStateException exception) {

	        ValidationErrorsOutputDto va = new ValidationErrorsOutputDto(messageSource);
	        va.addError(exception.getMessage());
	        
	        return va;
	    }
	    
	    	
}
