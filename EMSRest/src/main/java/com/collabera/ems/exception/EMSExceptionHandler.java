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

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> empNFException(EmployeeNotFoundException e) {
		return ((BodyBuilder) ResponseEntity.notFound()).body(e.getMessage());
	}

	@ExceptionHandler(ManagerNotFoundException.class)
	public ResponseEntity<?> manNFException(ManagerNotFoundException e) {
		return ((BodyBuilder) ResponseEntity.notFound()).body(e.getMessage());
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> nullFoundException(NullPointerException e) {
		return ResponseEntity.badRequest().body("NULL");
	}
}
