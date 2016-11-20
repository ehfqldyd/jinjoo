package com.work.spring15.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.work.spring15.dto.Board;
import com.work.spring15.dto.Member;
import com.work.spring15.exception.AuthenticationException;
import com.work.spring15.service.BoardService;
import com.google.gson.Gson;


@Controller
public class BoardController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   /** spring di : setter injection */
   private BoardService boardservice;
   @Autowired
   public void setService(BoardService boardservice) {
      this.boardservice = boardservice;
   }
   
   
   
   @RequestMapping(value="insertBoard.do",method=RequestMethod.POST)
   public @ResponseBody List<Board> insertBoard(String userid , String title , String contents, HttpSession session,HttpServletResponse response) throws IOException ,AuthenticationException{
      
      System.out.println("=--=-=-=-=-= userid , title, contents");
      System.out.println(userid+title+contents);   
      Gson gson = new Gson();
      int boardNo = boardservice.insertBoard(userid,title,contents);
      List<Board> list = new ArrayList<Board>();
      
      if(boardNo!=0){
         list = boardservice.selectAllBoard();
         String json = gson.toJson(list);
         System.out.println(json);
         
         return list;
      } else {
         System.out.println("list null:"+ list);
         return null;
      }   
      
      
   }
   

}






