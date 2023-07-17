package com.skumar.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> userExceptionHandler(UserException de, WebRequest web){
        ErrorDetails err = new ErrorDetails();
        err.setMessage(de.getMessage());
        err.setTimeStamp(LocalDateTime.now());
        err.setDescription(web.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(PostException.class)
    public ResponseEntity<ErrorDetails> postExceptionHandler(PostException de, WebRequest web){
    	ErrorDetails err = new ErrorDetails();
    	err.setMessage(de.getMessage());
    	err.setTimeStamp(LocalDateTime.now());
    	err.setDescription(web.getDescription(false));
    	return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(CommentException.class)
    public ResponseEntity<ErrorDetails> commentExceptionHandler(CommentException de, WebRequest web){
    	ErrorDetails err = new ErrorDetails();
    	err.setMessage(de.getMessage());
    	err.setTimeStamp(LocalDateTime.now());
    	err.setDescription(web.getDescription(false));
    	return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
   

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> walletExceptionHandler(NoHandlerFoundException ex ,WebRequest req){
		ErrorDetails err= new ErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ex.getLocalizedMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> walletExceptionHandler(MethodArgumentNotValidException ex){
		ErrorDetails err= new ErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ex.getLocalizedMessage());
		err.setDescription(ex.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
}
