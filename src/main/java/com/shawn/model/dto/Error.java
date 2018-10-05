package com.shawn.model.dto;
import java.io.Serializable;

/**
 * @author Xiaoyue Xiao
 */
public class Error implements Serializable {

    private static final long serialVersionUID = 7660756960387438399L;

    private int code; // Error code
    private String message; // Error message
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
