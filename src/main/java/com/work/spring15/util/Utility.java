package com.work.spring15.util;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/** �������� ����ϱ� ���� ��ƿ Ŭ���� */
public class Utility {
	
	/**
	 * �����ø����̼ǿ��� get ��û�����Ϳ� ���� �ѱ� ���ڵ� ���� ��ȯ �޼���
	 * @param data
	 * @return
	 */
	public static String toKorEncoding(String data) {
		try {
			return new String(data.getBytes("8859_1"), "euc-kr");
		} catch(UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	/**
	 * �⺻ 4�ڸ� ���������� ���ڿ��� ��ȯ�ϴ� �޼���
	 * 
	 * @see java.lang.Math#random()
	 * @see java.util.Random#nextInt()
	 * @see java.lang.System.currentTimeMillis()
	 * @see java.lang.StringBuilder
	 * 
	 * @return
	 */
	public static String getSecureCode() {
		return getSecureCode(4);
	}

	/**
	 * �ƱԸ�Ʈ�� ���޹��� ������ ���������� ���ڿ��� ��ȯ�ϴ� �޼���
	 * 
	 * @return
	 */
	public static String getSecureCode(int length) {
		Random random = new Random((long)(System.currentTimeMillis() * Math.random()));
		StringBuilder code = new StringBuilder();
		
		for(int i=0; i < length; i++) {
			code.append(random.nextInt(10));  // 0 ~ 9
		}
		return code.toString();
	}

	/**
	 * 2��¥�� ����, �������� ���� ������ ���ڿ� ��ȯ
	 * @param length
	 * @return
	 */
	public static String getSecureCodeString(int length) {
		Random random = new Random((long)(System.currentTimeMillis() * Math.random()));
		StringBuilder code = new StringBuilder();
		
		for(int i=0; i < length; i++) {
			if(i < 2) {
				code.append((char)(random.nextInt(26) + 65)) ;  // �����빮��
			} else {
				code.append(random.nextInt(10));  // 0 ~ 9
			}
		}
		return code.toString();
	}
	
	/**
	 * <pre>
	 * ���糯¥�� �⵵4�ڸ�/��2�ڸ�/��2�ڸ� �⺻������ ���ڿ� ��ȯ
	 * ## ��¥���� 
	 * -- java.text.SimpleDateFormat ����
	 * -- �� : y
	 * -- �� : M
	 * -- �� : d
	 * -- 12�ð� : h
	 * -- 24�ð� : H
	 * -- �� : m
	 * -- �� : s
	 * -- �������� : a
	 * -- ���� : E
	 * </pre>
	 * @see java.util.Date
	 * @see java.text.SimpleDateFormat#format(java.util.Date)
	 * @return �⺻������ ���糯¥ ���ڿ�
	 */
	public static String getCurrentDate() {
		return getCurrentDate("yyyy/MM/dd");
	}

	/**
	 * ���糯¥�� ���޹��� �ƱԸ�Ʈ ������ ���ڿ� ��ȯ
	 * @param pattern
	 * @return ���������� ���糯¥ ���ڿ�
	 */
	public static String getCurrentDate(String pattern) {
		return new SimpleDateFormat(pattern).format(new Date());
	}
	
	/**
	 * ���糯¥�� ���޹��� �ƱԸ�Ʈ ������, Locale�� ���ڿ� ��ȯ
	 * @param pattern
	 * @param locale
	 * @return
	 */
	public static String getCurrentDate(String pattern, Locale locale) {
		return new SimpleDateFormat(pattern, locale).format(new Date());
	}
	
	/**
	 * ������ �����Ϳ� õ���� �ĸ� ������ ���ڿ� ��ȯ
	 * @param number
	 * @return
	 */
	public static String getNumber(long number) {
		return NumberFormat.getInstance().format(number);
	}
	
	/**
	 * �Ǽ��� �����Ϳ� õ���� �ĸ� ������ ���ڿ� ��ȯ
	 * @param number
	 * @return
	 */
	public static String getNumber(double number) {
		return NumberFormat.getInstance().format(number);
	}
	
	/**
	 * ������ �����Ϳ� õ���� �ĸ� ������ �⺻ ��ȭ���� ���ڿ� ��ȯ
	 * @param number
	 * @return
	 */
	public static String getCurrencyNumber(long number) {
		return NumberFormat.getCurrencyInstance().format(number);
	}
	
	/**
	 * ������ �����Ϳ� õ���� �ĸ� ������ ������ Locale ��ȭ���� ���ڿ� ��ȯ
	 * @param number
	 * @return
	 */
	public static String getCurrencyNumber(long number, Locale locale) {
		return NumberFormat.getCurrencyInstance(locale).format(number);
	}
	
	/**
	 * ù2���ڸ� ������ ���ڴ� * ��ȣ ��ü ��ȯ
	 * @param data
	 * @return
	 */
	public static String getSecureString(String data) {
		StringBuilder info = new StringBuilder(data.substring(0, 2));
		for(int i=2; i < data.length(); i++) {
			info.append("*");
		}
		
		return info.toString();
	}
}



