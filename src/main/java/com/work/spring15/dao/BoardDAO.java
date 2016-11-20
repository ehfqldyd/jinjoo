package com.work.spring15.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.work.spring15.dto.Board;
import com.work.spring15.dto.Member;


/**
 */
//���强�� ��� �������丮 
@Repository
public class BoardDAO {
   @Autowired
   private SqlSessionTemplate session;
      
   public int insertBoard(String userid , String title , String contents ){
      Board dto = new Board(userid, title , contents);
         int boardNo = session.insert("insertBoard", dto);
         System.out.println("dao Board success:" + boardNo);
      return boardNo;
      
   }
   
   
   
//   public Board(
//   1. int categoryNo, 
//   2. int boardNo , 
//   3. String userid, 
//   4. String title , 
//   5. String contents,
//   6.  String writeDate ) {}
   public List<Board> selectAllBoard( ){
      List<Board> list = new ArrayList<Board>();
      list = session.selectList("selectAllBoard");
      System.out.println("dao selectAllBoard success:"+list);
      return list;
   
   }
   
   private static BoardDAO instance = new BoardDAO();
   
   public static BoardDAO getInstance() {
      return instance;
   }
   
   private BoardDAO() {}

   
}