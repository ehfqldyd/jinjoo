package com.work.spring15.exception;

public class AuthorizationException extends Exception {
	public AuthorizationException() {
		super("�ش� ���񽺿� ���� ���� ������ �����ϴ�.");
	}
	
	public AuthorizationException(String key) {
		super(key + " : �ش� ���񽺿� ���� ���� ������ �����ϴ�.");
	}
}

