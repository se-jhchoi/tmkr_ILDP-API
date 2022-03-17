package se.app.homepage;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class, basePackages = "se.app.testdrive")
public class ApiExceptionAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(ApiExceptionAdvice.class);
	
	@ExceptionHandler({ApiException.class})
	public ResponseEntity<ApiResponseEntity> exceptionHandler(ApiException e) {
		return ResponseEntity
				.status(e.getError().getStatus())
				.body(ApiResponseEntity.builder()
						.code(e.getError().getCode())
						.message(e.getError().getMessage())
						.build());
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<ApiResponseEntity> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		final StringBuilder errorMessageBuilder = new StringBuilder();
		errorMessageBuilder.append("[");
		for(Iterator<ObjectError> it=e.getBindingResult().getAllErrors().iterator(); it.hasNext();) {
			ObjectError err = it.next();
			errorMessageBuilder.append(err.getDefaultMessage());
		}
		errorMessageBuilder.append("]");
		
		return ResponseEntity
				.status(ApiStatusEnum.VALIDATION_EXCEPTION.getStatus())
				.body(ApiResponseEntity.builder()
						.code(ApiStatusEnum.VALIDATION_EXCEPTION.getCode())
						.message(errorMessageBuilder.toString())
						.build());
	}	
}
