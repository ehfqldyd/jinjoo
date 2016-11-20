package com.work.spring15.dto;

import java.io.Serializable;

import com.work.spring15.util.Utility;

/**
 * <pre>
 * ȸ������ �𵨸� ������ Ŭ����
 * </pre>
 *
 * @author �Ӱ���
 * @sinse jdk 1.7
 * @see work.model.dao.MemberDAO
 */
public class Member implements Serializable {
   /** ���̵� 6�ڸ�~12�ڸ� */
   private String userid;
   /** ��й�ȣ 6�ڸ�~16�ڸ� */ 
   private String userpw;
   /** �̸� */
   private String name;
   /** �޴��� ���� 010-1234-1234 */
   private String mobile;
   /** �̸��� */
   private String email;
   /** ������ ���� : �⵵4�ڸ�/��2�ڸ�/��2�ڸ� */
   private String gender;
   /** ���ϸ��� �ִ�6�ڸ� */
   private String birth;
   /** ��� ������(A) ���ȸ��(S) �Ϲ�ȸ��(G) */
   private String grade;
   
   /**
    * @return the userid
    */
   public String getUserid() {
      return userid;
   }
   /**
    * @param userid the userid to set
    */
   public void setUserid(String userid) {
      this.userid = userid;
   }
   /**
    * @return the userpw
    */
   public String getUserpw() {
      return userpw;
   }
   /**
    * @param userpw the userpw to set
    */
   public void setUserpw(String userpw) {
      this.userpw = userpw;
   }
   /**
    * @return the name
    */
   public String getName() {
      return name;
   }
   /**
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }
   /**
    * @return the mobile
    */
   public String getMobile() {
      return mobile;
   }
   /**
    * @param mobile the mobile to set
    */
   public void setMobile(String mobile) {
      this.mobile = mobile;
   }
   /**
    * @return the email
    */
   public String getEmail() {
      return email;
   }
   /**
    * @param email the email to set
    */
   public void setEmail(String email) {
      this.email = email;
   }
   /**
    * @return the gender
    */
   public String getGender() {
      return gender;
   }
   /**
    * @param entryDate the entryDate to set
    */
   public void setGender(String gender) {
      this.gender = gender;
   }
   /**
    * @return the grade
    */
   public String getGrade() {
      return grade;
   }
   /**
    * @param grade the grade to set
    */
   public void setGrade(String grade) {
      this.grade = grade;
   }
   /**
    * @return the mileage
    */
   public String getBirth() {
      return birth;
   }
   /**
    * @param mileage the mileage to set
    */
   public void setBirth(String birth) {
      this.birth = birth;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder info = new StringBuilder();
      info.append(userid);
      info.append("\t | ");
      info.append(Utility.getSecureString(userpw));
      info.append("\t | ");
      info.append(name);
      info.append("\t | ");
      info.append(mobile);
      info.append("\t | ");
      info.append(email);
      info.append("\t | ");
      info.append(gender);
      info.append("\t | ");
      info.append(grade);
      info.append("\t | ");
      info.append(birth);
   
      return info.toString();
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((userid == null) ? 0 : userid.hashCode());
      return result;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj) {
      if(obj != null && obj instanceof Member) {
         Member dto = (Member)obj;
         if(dto.getUserid().equals(userid)) {
            return true;
         }
      }
      return false;
   }
   
   /**
    * �⺻ ������
    */
   public Member() {
      super();
   }
   
   /**
    * �ʼ������� �ʱ�ȭ ������
    * @param userid
    * @param userpw
    * @param name
    * @param mobile
    * @param email
    */
   public Member(String userid, String userpw, String name, String mobile, String email) {
      super();
      this.userid = userid;
      this.userpw = userpw;
      this.name = name;
      this.mobile = mobile;
      this.email = email;
   }
   
   /**
    * ��絥���� �ʱ�ȭ ������
    * @param userid
    * @param userpw
    * @param name
    * @param mobile
    * @param email
    * @param entryDate
    * @param grade
    * @param mileage
    */
   public Member(String userid, String userpw, String name,  String gender,String birth,String mobile, String email,
         String grade) {
      super();
      this.userid = userid;
      this.userpw = userpw;
      this.name = name;
      this.mobile = mobile;
      this.email = email;
      this.gender = gender;
      this.grade = grade;
      this.birth = birth;
   }
}