package exceptions;

/**
 * Exception class to raise an Exception when the argument Invalid
 * @author naveen.chauhan on 06/08/22
 */
public class InvalidArgumentException extends RuntimeException {

	public InvalidArgumentException(String message) {
		super(message);
	}
}
