package com.work.spring15.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.spring15.dao.MemberDAO;
import com.work.spring15.dto.Member;
import com.work.spring15.exception.AuthenticationException;
import com.work.spring15.util.Utility;

@Service
public class MemberService {
   /* spring di : setter injection */
   private MemberDAO dao;
   @Autowired
   public void setDao(MemberDAO dao) {
      this.dao = dao;
   }
   
   public MemberService(){}
   
   /** �α��� ��û ���� */
   public String login(String userid, String userpw) throws AuthenticationException {
      HashMap<String, String> hashmap = new HashMap<String, String>();
      hashmap.put("userid", userid);
      hashmap.put("userpw", userpw);
      
      System.out.println("service login hashmap : " + hashmap);
      String grade = dao.loginCheck(hashmap);
      
      if(grade == null) {
         throw new AuthenticationException("�α��� ������ �ùٸ��� �ʽ��ϴ�.");
      }
      
      return grade;
   }
   
   public int join(Member member) throws AuthenticationException {
      // ����� �Է����� : ���̵�, ��ȣ, �̸�, ����ó, �̸���
      // �ý��� �����߰� : ������, ���, ���ϸ���
      member.setGrade("G");
      
      int checknum = dao.insertMember(member);
      if (checknum!= 0 ){
         return checknum;
      }
      
      return 0;
   }
   
   public Member selectOne(String userid) throws AuthenticationException{
      Member member =new Member();
      member=dao.selectOne(userid);
      return member;
   }
   
}