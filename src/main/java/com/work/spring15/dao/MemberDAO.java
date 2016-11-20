package com.work.spring15.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.work.spring15.dto.Member;

/**
 * <pre>
 * ȸ�����̺�(Members) crud�� ���� dao Ŭ����
 * 
 * ## DAO Pattern
 * ## Singleton Pattern
 * ## Connection Pool : DataSource
 * </pre>
 */
//���强�� ��� �������丮 
@Repository
public class MemberDAO {
   @Autowired
   private SqlSessionTemplate session;
   
   public String loginCheck(HashMap<String,String> hashmap){
      System.out.println("dao login : " + hashmap);
      return session.selectOne("selectLogin", hashmap);
   }
   
   public int insertMember(Member dto){
      return session.insert("insertMember",dto);
   }
   
   public Member selectOne(String userid){
      return session.selectOne("selectMember",userid);
   }
   private static MemberDAO instance = new MemberDAO();
   
   public static MemberDAO getInstance() {
      return instance;
   }
   
   /**
    * �⺻������ 
    */
   private MemberDAO() {}

   
   
//   /**
//    * �α��� ����
//    * @param userid
//    * @param userpw
//    * @return
//    */
//   public String loginCheck(String userid, String userpw) {
//      String sql = "select grade from members where userid=? and userpw=?";
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      ResultSet rs = null;
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, userid);
//         pstmt.setString(2, userpw);
//         rs = pstmt.executeQuery();
//         
//         if(rs.next()) {
//            return rs.getString("grade");
//         }
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }       
//      return null;
//   }
//   
//   /**
//    * ȸ�� ���
//    * @param dto
//    * @return
//    */
//   public int insert(Member dto) {
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      String sql = "insert into members values(?,?,?,?,?,to_char(sysdate,'yyyy/mm/dd'),'G',?)";
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         
//         pstmt.setString(1, dto.getUserid());
//         pstmt.setString(2, dto.getUserpw());
//         pstmt.setString(3, dto.getName());
//         pstmt.setString(4, dto.getMobile());
//         pstmt.setString(5, dto.getEmail());
//         
//         pstmt.setInt(6, dto.getMileage());
//         
//         return pstmt.executeUpdate(); 
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      } 
//      return 0;
//   }
//   
//   /** 
//    * ȸ�� ����
//    * @param dto
//    * @return
//    */
//   public int update(Member dto) {
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      String sql = "update members set userpw=?, name=?, mobile=?, email=?,entry_date=?, grade=?, mileage=? ";
//      sql += "where userid=?";
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         
//         pstmt.setString(1, dto.getUserpw());
//         pstmt.setString(2, dto.getName());
//         pstmt.setString(3, dto.getMobile());
//         pstmt.setString(4, dto.getEmail());
//         pstmt.setString(5, dto.getEntryDate());
//         pstmt.setString(6, dto.getGrade());
//         pstmt.setInt(7, dto.getMileage());
//         pstmt.setString(8, dto.getUserid());
//         
//         return pstmt.executeUpdate(); 
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      } 
//      return 0;   
//   }
//   
//   /**
//    * ��ȣ ����
//    * @param userid ���̵�
//    * @param userpw ��й�ȣ
//    * @param newUserpw ���� ��й�ȣ
//    * @return
//    */
//   public int updateUserpw(String userid, String userpw, String newUserpw) {
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      String sql = "update members set userpw=? where userid=? and userpw=?";
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, newUserpw);
//         pstmt.setString(2, userid);
//         pstmt.setString(3, userpw);
//         return pstmt.executeUpdate(); 
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }       
//      return 0;   
//   }
//
//   public int updateUserpw(String userid, String newUserpw) {
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      String sql = "update members set userpw=? where userid=?";
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, newUserpw);
//         pstmt.setString(2, userid);
//         return pstmt.executeUpdate(); 
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }      
//      return 0;   
//   }
//   
//   /**
//    * ȸ�� Ż��
//    * @param userid
//    * @return
//    */
//   public int delete(String userid) {
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      String sql = "delete members where userid=?";
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, userid);
//         return pstmt.executeUpdate(); 
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }       
//      return 0;   
//   }
//   
//   /**
//    * ��üȸ�� Ż�� : �׽�Ʈ�� ���� ȸ�����̺� �ʱ�ȭ
//    * @return
//    */
//   public int delete() {
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      String sql = "delete members";
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         return pstmt.executeUpdate(); 
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }       
//      return 0;   
//   }
//   
//   /**
//    * ���ϸ��� ����
//    * @return
//    */
//   public int updateMileage(String userid, int mileage) {
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      String sql = "update members mileage=? where userid=?";
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setInt(1, mileage);
//         pstmt.setString(2, userid);
//         return pstmt.executeUpdate(); 
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }       
//      return 0;   
//   }
//
//   /** ȸ����� ���� */
//   public int updateGrade(String userid, String grade) {
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      String sql = "update members grade=? where userid=?";
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, grade);
//         pstmt.setString(2, userid);
//         return pstmt.executeUpdate(); 
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }       
//      return 0;   
//   }
//   
//   
//   /**
//    * ���̵� �ߺ� �˻�
//    * @param userid
//    * @return
//    */
//   public boolean selectUserid(String userid) {
//      String sql = "select name from members where userid=?";
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      ResultSet rs = null;
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, userid);
//         rs = pstmt.executeQuery();
//         
//         if(rs.next()) {
//            return true;
//         }
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      } 
//      return false;
//   }
//   
//   /**
//    * ��üȸ�� ��ȯ
//    * @return
//    */
//   public ArrayList<Member> selectList() {
//      return selectListByCondition("", "");
//   }
//   
//   /**
//    * ȸ���� ��ȯ
//    * @param userid
//    * @return
//    */
//   public Member selectOne(String userid) {
//      String sql = "select * from members where userid=?";
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      ResultSet rs = null;
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, userid);
//         rs = pstmt.executeQuery();
//         
//         String userpw = null;
//         String name = null;
//         String mobile = null;
//         String email = null;
//         String entryDate = null;
//         String grade = null;
//         int mileage = 0;
//         
//         if(rs.next()) {
//            userpw = rs.getString("userpw");
//            name = rs.getString("name");
//            mobile = rs.getString("mobile");
//            email = rs.getString("email");
//            entryDate = rs.getString("entry_date");
//            grade = rs.getString("grade");
//            mileage = rs.getInt("mileage");
//            
//            return new Member(userid, userpw, name, mobile, email, entryDate, grade, mileage);
//         }
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }      
//      return null;
//   }
//
//   /**
//    * ��ȭ��ȣ�� �˻��� ��üȸ�� ��ȯ
//    * select * from members where mobile like '%?' ==>   '%'1234''
//    * @return
//    */
//   public ArrayList<Member> selectListByPhone(String keyword) {
//      String sql = "select * from members where mobile like ?";
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      ResultSet rs = null;
//      ArrayList<Member> list = new ArrayList<Member>();
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, "%" + keyword);
//         rs = pstmt.executeQuery();
//         
//         Member dto = null;
//         String userid = null;
//         String userpw = null;
//         String name = null;
//         String mobile = null;
//         String email = null;
//         String entryDate = null;
//         String grade = null;
//         int mileage = 0;
//         
//         while(rs.next()) {
//            userid = rs.getString("userid");
//            userpw = rs.getString("userpw");
//            name = rs.getString("name");
//            mobile = rs.getString("mobile");
//            email = rs.getString("email");
//            entryDate = rs.getString("entry_date");
//            grade = rs.getString("grade");
//            mileage = rs.getInt("mileage");
//            
//            dto = new Member(userid, userpw, name, mobile, email, entryDate, grade, mileage);
//            list.add(dto);
//         }
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }       
//      return list;
//   }
//   
//   /**
//    * ���̵� ã��
//    * @param name
//    * @param mobile
//    * @return
//    */
//   public String selectUserid(String name, String mobile) {
//      String sql = "select userid from members where name=? and mobile=?";
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      ResultSet rs = null;
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, name);
//         pstmt.setString(2, mobile);
//         rs = pstmt.executeQuery();
//         
//         if(rs.next()) {
//            return rs.getString("userid");
//         }
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }       
//      return null;
//   }
//   
//   /**
//    * ��й�ȣ ã��
//    * @param userid
//    * @param email
//    * @return
//    */
////   public String selectUserpw(String userid, String email) {
//   public boolean selectUserpw(String userid, String email) {
//      String sql = "select userpw from members where userid=? and email=?";
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      ResultSet rs = null;
//      
//      try {
//         conn = factory.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, userid);
//         pstmt.setString(2, email);
//         rs = pstmt.executeQuery();
//         
//         if(rs.next()) {
////            return rs.getString("userpw");
//            return true;
//         }
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      }       
//      return false;
//   }
//   
//   /**
//    * �������� �˻�
//    * @param type
//    * @param keyword
//    * @return
//    */
//   public ArrayList<Member> selectListByCondition(String columnName, String keyword) {
//      String sql1 = "select * from members where userid=?";
//      String sql4 = "select * from members where " + columnName + " like ?";
//      String sql5 = "select * from members";
//      
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      ResultSet rs = null;
//      ArrayList<Member> list = new ArrayList<Member>();
//      
//      try {
//         conn = factory.getConnection();
//         
//         if(columnName.equals("userid")) {
//            pstmt = conn.prepareStatement(sql1);
//            pstmt.setString(1, keyword);
//         } else if(columnName.equals("name") || columnName.equals("mobile")) {
//            pstmt = conn.prepareStatement(sql4);
//            pstmt.setString(1, "%" + keyword + "%");
//         } else {
//            pstmt = conn.prepareStatement(sql5);
//         }
//         
//         rs = pstmt.executeQuery();
//
//         String userid = null;
//         String userpw = null;
//         String name = null;
//         String mobile = null;
//         String email = null;
//         String entryDate = null;
//         String grade = null;
//         int mileage = 0;
//         
//         while(rs.next()) {
//            userid = rs.getString("userid");
//            userpw = rs.getString("userpw");
//            name = rs.getString("name");
//            mobile = rs.getString("mobile");
//            email = rs.getString("email");
//            entryDate = rs.getString("entry_date");
//            grade = rs.getString("grade");
//            mileage = rs.getInt("mileage");
//            
//            list.add(new Member(userid, userpw, name, mobile, email, entryDate, grade, mileage));
//         }
//      } catch(SQLException e) {
//         System.out.println("Error : " + e.getMessage());
//         e.printStackTrace();
//      } 
//      return list;
//   }
}