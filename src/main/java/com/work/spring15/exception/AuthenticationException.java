package com.work.spring15.exception;

/**
 * ����� ���� ���� Ŭ����
 * 
 * @author �Ӱ���
 * @version ver.1.0
 * @since jdk 1.7
 * @see java.lang.Exception
 */
public class AuthenticationException extends Exception {
	public AuthenticationException() {
		super("����� ������ �����߽��ϴ�.");
	}
	
	public AuthenticationException(String message) {
		super(message);
	}	
}
