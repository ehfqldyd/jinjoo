package com.work.spring15.exception;

public class InvalidDataException extends Exception {
	public InvalidDataException() {
		super("�����͸� �ùٸ��� �Է��Ͻñ� �ٶ��ϴ�.");
	}
	
	public InvalidDataException(String key) {
		super(key + " : �����͸� �ùٸ��� �Է��Ͻñ� �ٶ��ϴ�.");
	}
}

