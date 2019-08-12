package com.toyRobot.exception;
/**
 * Invalid instruction exception
 *
 */
public class InvalidInstructionException extends Exception {

	private static final long serialVersionUID = 7914130839525648493L;

	public InvalidInstructionException(String string) {
        super(string);
    }

}