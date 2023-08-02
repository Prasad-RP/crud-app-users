package Exceptions;

@SuppressWarnings("serial")
public class DuplicateEmailFoundException extends RuntimeException{
	
	String msg="Duplicate Email Found";
	
	public String getMessage(){
		return msg;
	}

}
