package simple;

import java.io.Serializable;

public class Command implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7386258182412348165L;
	private char CharGuessed;
	
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	public char getCharGuessingFromClient() {
		
		return this.CharGuessed;
	}
	
	
	
}
