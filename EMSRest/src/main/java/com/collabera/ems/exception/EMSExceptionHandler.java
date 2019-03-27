/**
 * 
 */
package com.collabera.ems.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	Logger logger = LogManager.getLogger(EMSExceptionHandler.class);

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> empNFException(EmployeeNotFoundException e) {
		logger.error(e.getMessage(), e);
		return ((BodyBuilder) ResponseEntity.notFound()).body(e.getMessage());
	}

	@ExceptionHandler(ManagerNotFoundException.class)
	public ResponseEntity<?> manNFException(ManagerNotFoundException e) {
		logger.error(e.getMessage(), e);
		return ((BodyBuilder) ResponseEntity.notFound()).body(e.getMessage());
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> nullFoundException(NullPointerException e) {
		logger.error(e.getMessage(), e);
		return ResponseEntity.badRequest().body("NULL");
	}
}
