package com.wesleyreisz.battlebot.exceptions;

public class InvalidCharacterStatisticException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidCharacterStatisticException()
	  {
	    super();  
	  }
	  
	  public InvalidCharacterStatisticException(String err)
	  {
	    super(err); 
	  }
	  

}
