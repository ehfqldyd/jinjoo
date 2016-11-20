package com.work.spring15.exception;

/**
 * ## ����� ���� ����Ŭ���� ��Ģ
 * 1. extends Exception
 * 2. super("���ܸ޼���");
 * 
 * ���ڵ� �ߺ��� ��� ���� Ŭ����
 * 
 * @author �Ӱ���
 * @version ver.1.0
 * @since jdk 1.7
 * @see java.lang.Exception
 */
public class DuplicateException extends Exception {
	public DuplicateException() {
		super("�ش� ���ڵ尡 �̹� ��� �Ǿ� �ֽ��ϴ�.");
	}
	
	public DuplicateException(String key) {
		super(key + " : �ش� ���ڵ尡 �̹� ��� �Ǿ� �ֽ��ϴ�.");
	}
}
