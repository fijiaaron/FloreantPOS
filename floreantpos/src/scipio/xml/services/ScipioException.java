/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scipio.xml.services;

/**
 *
 * @author Aaron
 */
public class ScipioException extends Exception {
	public ScipioException() {
		super();
	}
	public ScipioException(String message) {
		super(message);
	}
	public ScipioException(String message, Throwable t) {
		super(message, t);
	}
	public ScipioException(Throwable t) {
		super(t);
	}
}
