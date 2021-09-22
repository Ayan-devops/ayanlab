package my.lab.lab;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

	//@ExceptionHandler(value=Exception.class)
	//public void exceptionHandler(Exception exception)
	//{
		//System.out.println("*******");
	//}
	
	//@ExceptionHandler(value=NullPointerException.class)
	//public void exceptionHandler1(NullPointerException exception)
	//{
		//System.out.println("*******");
	//}
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public String exceptionHandler1(MethodArgumentNotValidException exception)
	{
		return "Value cannot be null";
	}
}
