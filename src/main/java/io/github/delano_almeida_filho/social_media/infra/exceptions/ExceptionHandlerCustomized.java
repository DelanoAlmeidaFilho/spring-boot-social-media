package io.github.delano_almeida_filho.social_media.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerCustomized {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(
			Exception ex, WebRequest request) {

		var exceptionResponse = new ExceptionResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage(),
				"internal.error");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(
			Exception ex, WebRequest request) {

		var exceptionResponse = new ExceptionResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				"notfound.error");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(
			Exception ex, WebRequest request) {

		var exceptionResponse = new ExceptionResponse(
				HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(),
				"badrequest.error");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<BeanValidationException> handleBeanValidationExceptions(
			MethodArgumentNotValidException ex, WebRequest request) {

		var fields = ex.getFieldErrors();
		var errors = fields.stream().map(BeanValidationFieldCustomized::new).toList();

		var exceptionResponse = new BeanValidationException(errors);

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

	}
}
