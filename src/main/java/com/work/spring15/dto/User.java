package com.work.spring15.dto;

/**
 * �α��� �������� ���� ������Ŭ����
 */
public class User {
	private String userid;
	private String userpw;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	
	public User(){}
	
	public User(String userid, String userpw) {
		this.userid = userid;
		this.userpw = userpw;
	}
}



