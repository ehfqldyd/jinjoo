package com.work.spring15.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.spring15.dao.BoardDAO;
import com.work.spring15.dao.MemberDAO;
import com.work.spring15.dto.Board;
import com.work.spring15.dto.Member;
import com.work.spring15.exception.AuthenticationException;
import com.work.spring15.util.Utility;

@Service
public class BoardService {
   /* spring di : setter injection */
   private BoardDAO bdao;
   @Autowired
   public void setDao(BoardDAO bdao) {
      this.bdao = bdao;
   }
   
   public BoardService(){}
   
   public int insertBoard(String userid,String title,String contents) throws AuthenticationException{
      System.out.println("service insertBoard :" );
      int boardNo = bdao.insertBoard(userid, title , contents);
      
      return boardNo ;
   }
   public List<Board> selectAllBoard(){
      System.out.println("service selectAllBoard :" );
      return bdao.selectAllBoard();
   }
   

   
   
   
   
}