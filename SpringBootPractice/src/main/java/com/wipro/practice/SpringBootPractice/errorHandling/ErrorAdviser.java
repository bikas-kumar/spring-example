package com.wipro.practice.SpringBootPractice.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorAdviser {

	@ExceptionHandler(BadRequestError.class)
	public ResponseEntity<CentralErrorService> mapException(BadRequestError error) {
		CentralErrorService addEmpErr = new CentralErrorService(HttpStatus.BAD_REQUEST.value(), error.getMessage());
		return new ResponseEntity<CentralErrorService>(addEmpErr, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<CentralErrorService> mapException(InternalServerError error) {
		CentralErrorService addEmpErr = new CentralErrorService(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				error.getMessage());
		return new ResponseEntity<CentralErrorService>(addEmpErr, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
