package com.suddenlyjune.financialinvestment.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseErrorHandler {
	//in case of database down, put error handler to avoid bad customer experience. Using annotation to 
		@ExceptionHandler(DataAccessException.class)
		public String handleDatabaseException(DataAccessException ex){
			return "error";
		}
}
