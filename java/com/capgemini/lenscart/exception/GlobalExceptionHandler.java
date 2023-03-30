package com.capgemini.lenscart.exception;



import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=NoDuplicateEmailIdException.class)
	public ResponseEntity<ExceptionResponce> handleDuplicateEmailId(NoDuplicateEmailIdException e) {
		ExceptionResponce response = new ExceptionResponce();
		response.setErrorMsg("CONFLICT");
		response.setErrorCode(e.getMessage());
		response.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	
	@ExceptionHandler(value=PriceNegativeException.class)
	public ResponseEntity<ExceptionResponce> handlePriceNegativeException(PriceNegativeException e) {
	ExceptionResponce response = new ExceptionResponce();
	response.setErrorMsg("CONFLICT");
	response.setErrorCode(e.getMessage());
	response.setTimeStamp(LocalDateTime.now());
	return new ResponseEntity<ExceptionResponce>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=WrongLoginException.class)
	public ResponseEntity<ExceptionResponce> WrongLoginException(WrongLoginException e) {
		ExceptionResponce response = new ExceptionResponce();
		response.setErrorMsg("CONFLICT");
		response.setErrorCode(e.getMessage());
		response.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponce>(response, HttpStatus.CONFLICT);
		}
	
	@ExceptionHandler(value=InvalidEmailIdException.class)
	public ResponseEntity<ExceptionResponce> InvalidEmailIdException(InvalidEmailIdException e) {
		ExceptionResponce response = new ExceptionResponce();
		response.setErrorMsg("CONFLICT");
		response.setErrorCode(e.getMessage());
		response.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponce>(response, HttpStatus.CONFLICT);
		}
	
	@ExceptionHandler(value=InvalidContactNoException.class)
	public ResponseEntity<ExceptionResponce> InvalidContactNoException(InvalidContactNoException e) {
		ExceptionResponce response = new ExceptionResponce();
		response.setErrorMsg("CONFLICT");
		response.setErrorCode(e.getMessage());
		response.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponce>(response, HttpStatus.CONFLICT);
		}
	
	@ExceptionHandler(value=InvalidCardNumberException.class)
    public ResponseEntity<ExceptionResponce> handleInvalidCardNumberException(InvalidCardNumberException e) {
        ExceptionResponce response = new ExceptionResponce();
        response.setErrorMsg("CONFLICT");
        response.setErrorCode(e.getMessage());
        response.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<ExceptionResponce>(response, HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=CardIsPresentException.class)
    public ResponseEntity<ExceptionResponce> handleDebitCardException(CardIsPresentException e) {
        ExceptionResponce response = new ExceptionResponce();
        response.setErrorMsg("CONFLICT");
        response.setErrorCode(e.getMessage());
        response.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<ExceptionResponce>(response, HttpStatus.CONFLICT);
        }

}
