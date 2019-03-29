/**
 * 
 */
package com.collabera.ems.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author rutpatel
 *
 */
@ControllerAdvice
public class EMSExceptionHandler {

	@ExceptionHandler(EmployeeIdMismatchFormatException.class)
	public ResponseEntity<?> empIdMismatchException(EmployeeIdMismatchFormatException e) {
		return ((BodyBuilder) ResponseEntity.badRequest()).body(e.getMessage());
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> empNFException(EmployeeNotFoundException e) {
		return ((BodyBuilder) ResponseEntity.notFound()).body(e.getMessage());
	}
}
