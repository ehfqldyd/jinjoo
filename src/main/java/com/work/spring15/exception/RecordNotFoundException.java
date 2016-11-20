package com.work.spring15.exception;

/**
 * ## ����� ���� ����Ŭ���� ��Ģ
 * 1. extends Exception
 * 2. super("���ܸ޼���");
 * 
 * ���ڵ� ���°�� ���� Ŭ����
 * 
 * @author �Ӱ���
 * @version ver.1.0
 * @since jdk 1.7
 * @see java.lang.Exception
 */
public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		super("�ش� ���ڵ带 ã�� �� �����ϴ�.");
	}
	
	public RecordNotFoundException(String key) {
		super(key + " : �ش� ���ڵ带 ã�� �� �����ϴ�.");
	}
}
