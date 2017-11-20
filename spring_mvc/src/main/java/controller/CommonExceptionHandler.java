package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("spring_mvc")
public class CommonExceptionHandler {
	/*@ExceptionHandler(Exception.class)
	public String handleException() {
		return "error/commonException";
	}*/
}
