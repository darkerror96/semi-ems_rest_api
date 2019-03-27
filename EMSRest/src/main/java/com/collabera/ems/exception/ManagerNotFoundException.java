/**
 * 
 */
package com.collabera.ems.exception;

/**
 * @author rutpatel
 *
 */
public class ManagerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManagerNotFoundException(String msg) {
		super(msg);
	}
}
